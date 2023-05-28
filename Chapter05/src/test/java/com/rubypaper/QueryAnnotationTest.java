package com.rubypaper;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRep;
	
//	@Test
//	public void testQueryAnnotationTest1() {
//		List<Board> boardList = boardRep.queryAnnotationTest1("테스트 제목 10");
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println("-->" + board.toString());
//		}
//	}
//	@Test
//	public void testQueryAnnotationTest2() {
//		List<Board> boardList = boardRep.queryAnnotationTest2("테스트 제목 10");
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println("-->" + board.toString());
//		}
//	}
//	@Test
//	public void testQueryAnnotationTest3() {
//		List<Object[]> boardList = boardRep.queryAnnotationTest3("테스트 제목 10");
//		
//		System.out.println("검색결과");
//		for(Object[] row : boardList) {
//			System.out.println("-->" + Arrays.toString(row));
//		}
//	}
//	@Test
//	public void testQueryAnnotationTest4() {
//		List<Object[]> boardList = boardRep.queryAnnotationTest4("테스트 제목 10");
//		
//		System.out.println("검색결과");
//		for(Object[] row : boardList) {
//			System.out.println("-->" + Arrays.toString(row));
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest5() {
//		Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "seq"); 
//		List<Board> boardList = boardRep.queryAnnotationTest5(paging);
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println("-->" + board.toString());
//		}
//	}
//	//게시글 3개 단위로 페이징 처리 됨
}
