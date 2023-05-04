package com.rubypaper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter05ApplicationTests {

	
	@Autowired
	private BoardRepository boardRep;
	
	@Test
	public void contextLoads() {
		Board board = new Board();
		board.setTitle("1번게시글");
		board.setWriter("1번작성자");
		board.setContent("1번글 내용");
		board.setCreateDate(new Date());
		board.setCnt(0L);
		
		boardRep.save(board);
	
	}

}
