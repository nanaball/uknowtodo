package practice.project.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@Table(name = "todo")
@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)		// 자동증가
	private Long todoNo; 			// 할 일 번호 
	
	@Column	
	private Long memberNo;			// 회원 번호(외래키)
	
	@Column
	private String todoName;		// 할일 목록
	
	@Column
	private String todoContent;		// 할일 상세내용 
	
	@Column
	private boolean completed; 		// 완료여부

	@Column
	private LocalDateTime todoDate; //  마감시간

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
