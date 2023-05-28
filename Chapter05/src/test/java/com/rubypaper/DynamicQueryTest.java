package com.rubypaper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.domain.Board;
import com.rubypaper.domain.QBoard;
import com.rubypaper.persistence.DynamicBoardRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicQueryTest {
	@Autowired
	private DynamicBoardRepository boardRep;
	
	@Test
	public void testDynamicQuery() {
		String searchCondtion = "TITLE";
		String searchKeyword = "테스트 제목 10";
		
		BooleanBuilder builder= new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if(searchCondtion.equals("TITLE")) {
			builder.and(qboard.title.like("%"+searchKeyword +"%"));
		}else if(searchCondtion.equals("CONTENT")) {
			builder.and(qboard.content.like("%" +searchKeyword+"%"));
			//BooleanBuilder 객체를 이용하면 builder에 and/or에 해당하는 조건을 사용가능
		}
		
		Pageable paging = PageRequest.of(0,5);
		
		Page<Board> boardList = boardRep.findAll(builder, paging);
		
		System.out.println("검색결과");
		for(Board board : boardList) {
			System.out.println("-->" + board.toString());
		}
		//"테스트 제목 10"이란 글을 제목에 포함한 모든글을 5개단위로 페이징처리한 결과값을 얻을수 있다
	}

}
