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
@ToString(exclude = "member")
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
	
	//member클래스에서 cascadeType.ALL로 설정할 경우 회원객체가 영속화되거나 수정,삭제 될때
	//회원과 관련된 게시판도 함께 반영됨
	//회원이 소유한 게시글도 자동으로 수정삭제 될수 있도록 board클래스에 setMember()새로이 추가하자
	
	public void setMember(Member member) {
		this.member = member;
		member.getPersonBoardList().add(this);
	}
	
	//@ManyToOne에서 사용할 수 있는 속성
	//optional : 연관되 엔티티가 반드시 있어야 하는지의 여부 결정 false로 설정하면 항상 있어야함
	//fetch : 글로버러 페치전략 설정
	//		EAGER : 연관엔티티를 동시 조회(@ManyToOne)
	//		LAZY : 연관 엔티티를 실제 사용(@OneToMany)
	//cascade : 영속성 전이기능 설정, 연관엔티티를 같이 저장하거나 삭제할때 사용
}
