package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "personBoardList")
@Entity
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	private String password;
	private String name;
	private String role;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	//연관관계의 주인이 아님을 표시하는 mappedBy, 실습간 테이블의 외래키는 Board에 설정했었기때문!
	//여기서는 Board.member변수가 주인!
	//반대로 주인이 아닌 memberList.Board는 mappedBy속성에 member를 표기해 주인이 아님을 표시
	private List<Board> personBoardList = new ArrayList<Board>();
	
	//@OneToMany 의 경우 fetchType의 기본속성은 Lazy, 소스에서는 EAGER로 설정했었음..
}
