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
	@GeneratedValue(strategy = GenerationType.AUTO)		// 자동증가
	private Long memberNo; 	// 회원번호 
	
	@Column	
	private String id;
	
	@Column
	private String password;
	
	@Column
	private String writer;	// 회원이름 

	@Column
	private LocalDateTime regdate;

	@PrePersist
	public void prePersist() {
		LocalDateTime now = LocalDateTime.now();
		this.regdate = Optional.ofNullable(this.regdate).orElse(now);
	}
}
