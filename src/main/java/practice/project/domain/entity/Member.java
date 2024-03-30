package practice.project.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@Table(name = "members")
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberNo;
	
	@Column	
	private String id;
	
	@Column
	private String password;
	
	@Column
	private String name;

	@Column
	private LocalDateTime createdDate;

	@PrePersist
	public void prePersist() {
		LocalDateTime now = LocalDateTime.now();
		this.createdDate = Optional.ofNullable(this.createdDate).orElse(now);
	}
}
