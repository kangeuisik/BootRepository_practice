package com.rubypaper.persistence;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRep;
//	게시글 등록
//	@Test
//	public void testInsertBoard() {
//		Board board = new Board();
//		board.setTitle("제목예시입니다1.");
//		board.setContent("내용예시입니다1.");
//		board.setWriter("관리자");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		
//		boardRep.save(board);
//	}
	//게시글 불러오기 (검색)
//	@Test
//	public void testGetBoard() {
//		Board board = boardRep.findById(1L).get();
//		//데이터하나를 조회할때에는 findById메소드를 사용하는데 
//		//Optional타입의 객체가 리턴되는 get(); 메소드를 이용해 저장된 board객체를 받아낸다.
//		System.out.println(board.toString());
//	}
	//게시글 수정하기
//	@Test
//	public void testUpdateBoard() {
//		System.out.println("===1번 게시글 조회===");
//		Board board = boardRep.findById(1L).get();
//		//1번게시글을 조회하고
//		System.out.println("===1번 게시글 수정===");
//		board.setTitle("1번 게시글 제목을 수정했습니다.");
//		//1번 게시글을 새로 set 해주고 다시 저장
//		boardRep.save(board);
//	
//	}
	//게시글 삭제하기
	@Test
	public void testDeleteBoard() {
		boardRep.deleteById(1L);
	}
}
