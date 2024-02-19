package practice.project.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)	// 생성일자와 수정일자 자동관리위해 사용
public class DateTime {
	
	@CreatedDate						// 현재시간 자동 설정
	private LocalDateTime regdate;		// 가입 시간
	
	@CreatedDate
	private LocalDateTime createdDate;	// 글 등록시간
	
	@CreatedDate
	private LocalDateTime todoDate;		// 마감시간
	
	@Setter								// 수정시에만 적용되어야 해서 별도로 setter 지정
	@LastModifiedDate					// 수정시간 자동 설정
	private LocalDateTime updateDate;	// 글 수정시간
	
}
