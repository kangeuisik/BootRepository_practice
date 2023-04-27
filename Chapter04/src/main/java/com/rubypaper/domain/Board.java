package com.rubypaper.domain;


import java.util.Date;

import javax.persistence.*;


@Entity
@TableGenerator(name = "BOARD_SEQ_GENERATOR",
				table = "ALL_SEQUENCES",
				pkColumnValue = "BOARD_SEQ",
				initialValue = 0, //BOARD_SEQ로 시작되는 번호 0
				allocationSize = 1) //테이블에서 값을꺼낼때만다의 증가값
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, 
					generator = "BOARD_SEQ_GENERATOR")
	private Long seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private Long cnt;
	
	//@TemporalType.DATE(날짜만 출력)
	//.TIME(시간만) , .TIMESTAMP(날짜시간 모두 출력)
	//@Column(nullable = false) private String title; -기본값 -> title varchar(255) not null
	// -제목 컬럼의 길이는 255 , 빈값이면 안됨
	//@Column(unique = false) private String isbn; -> alter table Tablename add constraint UK_Xxx unique
	//
	//@Column(columnDefinition = "varchar(100) default 'No Contents'")private String content;
	// ->content varchar(100) default 'No Contents'
	// 내용컬럼 길이는 100으로 수정 기본값을 내용없음으로 저장
	//@Column(length = 40) private String writer; -> writer varchar(40)
	// 작성자의 길이는 40 
	//@Column(precesion=10, scale =2) private BigDecimal point; 
	//->point numeric(10,2) h2/PostgreSQL
	//->point number(10,2) Oracle
	//->point decimal(10,2) MySQL
	
	
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}

	
   
}
