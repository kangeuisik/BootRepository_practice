package com.rubypaper;

import static org.junit.Assert.*;

import java.util.Date;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRep;
	
//	@Before
	//테스트케이스 이전에 특정조건을 세팅하기 위해 사용하는 어노테이션
	//아래 메소드는 200건의 게시글을 insert함
//	public void dataPrepare() {
//		for (int i = 1; i <= 200; i++) {
//			Board board = new Board();
//			board.setTitle("테스트 제목 "+i);
//			board.setWriter("테스터");
//			board.setContent("테스트 내용 "+i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			boardRep.save(board);
//		}
//	}
//	@Test
//	public void FindByTitle() {
//		List<Board> boardList = boardRep.findByTitle("테스트 제목 10");
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println("---->" + board.toString());
//		}
//	}
	
	
//	@Test
//	public void testByContentContining() {
//		List<Board> boardList = boardRep.findByContentContaining("17");
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println(board.toString());
//		}
//	}
	
//	@Test
//	public void findByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRep.findByTitleContainingOrContentContaining("17","17");
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println(board.toString());
//		}
//	}
	
//	@Test
//	public void findByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRep.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println(board.toString());
//		}
//	}
	
	@Test
	public void findByTitleContaining() {
		Pageable paging = PageRequest.of(0, 5);
		//첫번째 인자는 페이지번호
		//두번째인자는 검색할 데이터의 개수
		List<Board> boardList = boardRep.findByTitleContaining("제목", paging);
		
		System.out.println("검색결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
	
}
