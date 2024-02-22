package practice.project.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "todo")
@Entity
public class Todo extends DateTime {

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
}
