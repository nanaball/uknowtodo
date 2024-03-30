package practice.project.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@Table(name = "todos")
@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long todoNo;
	
	@Column	
	private Long memberNo;
	
	@Column
	private String todoName;
	
	@Column
	private String todoContent;

	@Column
	private String category;
	
	@Column
	private boolean completed;

	@Column
	private boolean deleted;

	@Column
	private LocalDateTime todoDate;

	@Column
	private LocalDateTime createdDate;

	@Column
	private LocalDateTime updatedDate;

	@PrePersist
	public void prePersist() {
		LocalDateTime now = LocalDateTime.now();
		this.createdDate = Optional.ofNullable(this.createdDate).orElse(now);
		this.updatedDate = now;
	}
}
