package practice.project.domain.entity;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "members")
@Entity
public class Member extends DateTime{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)		// 자동증가
	private Long memberNo; 	// 회원번호 
	
	@Column	
	private String id;
	
	@Column
	private String password;
	
	@Column
	private String writer;	// 회원이름 
	
	

}
