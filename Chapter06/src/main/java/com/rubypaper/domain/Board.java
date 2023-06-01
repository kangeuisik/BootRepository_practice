package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity //DB를 이용해 출력하기 위해 @entity 추가
public class Board {
	@Id @GeneratedValue
	private Long seq;
	private String title;
	@Column(updatable = false) //작성자는 update되면 안되니까 추가
	private String writer;
	private String content;
	@Column(updatable = false, insertable = false, columnDefinition = "date default sysdate")
	private Date createDate;
	@Column(updatable = false, insertable = false, columnDefinition = "number default 0")
	private Long cnt;
	//creatDate와 cnt는 null대신 기본값을 설정되게 하기 위해 columnDefinition지정

}
