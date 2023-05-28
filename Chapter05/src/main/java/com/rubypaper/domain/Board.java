package com.rubypaper.domain;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Board {
	//Entity 이름과 클래스 이름이 "Board"이름과 동일해서 생략
	@Id @GeneratedValue
	private Long seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	
	@ManyToOne //다대일
	@JoinColumn(name = "MEMBER_ID", nullable = false) //관계를 맺을 컬럼
	private Member member;
	
	//@ManyToOne에서 사용할 수 있는 속성
	//optional : 연관되 엔티티가 반드시 있어야 하는지의 여부 결정 false로 설정하면 항상 있어야함
	//fetch : 글로버러 페치전략 설정
	//		EAGER : 연관엔티티를 동시 조회(@ManyToOne)
	//		LAZY : 연관 엔티티를 실제 사용(@OneToMany)
	//cascade : 영속성 전이기능 설정, 연관엔티티를 같이 저장하거나 삭제할때 사용
}
