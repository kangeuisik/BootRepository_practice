package com.rubypaper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInitializeTest {
	
	@Autowired
	private BoardRepository boardRep;
	@Autowired
	private MemberRepository memberRep;
	
	
	@Test
	public void testDataInsert() {
		Member member1 = new Member();
		member1.setId("sonny");
		member1.setPassword("1234");
		member1.setName("손흥민");
		member1.setRole("ROLE_ADMIN");
		memberRep.save(member1);
		
		Member member2 = new Member();
		member2.setId("kim");
		member2.setPassword("1234");
		member2.setName("김민재");
		member2.setRole("ROLE_USER");
		memberRep.save(member2);
	
		for (int i = 1; i <= 3; i++) { 
			Board Board = new Board();
			Board.setWriter("손흥민");
			Board.setTitle("소니가 등록한 공지글"+i);
			Board.setContent("소니가 등록한 글의 내용"+i);
			boardRep.save(Board);
		}
		for (int i= 1; i <= 3; i++) {
			Board Board = new Board();
			Board.setWriter("김민재");
			Board.setTitle("민재가 등록한 게시글"+i);
			Board.setContent("민재가 등록한 글의 내용"+i);
			boardRep.save(Board);
			
		}
	}

}
