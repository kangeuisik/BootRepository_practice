package com.rubypaper;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.Date;
import java.util.List;

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
public class RelationMappingTest {
	@Autowired
	private BoardRepository boardRep; 
	@Autowired
	private MemberRepository memberRep;
	
	
//	@Test
//	public void testManyToOneInsert() {
//		Member member1 = new Member();
//		member1.setId("회원1");
//		member1.setName("손흥민");
//		member1.setPassword("1234");
//		member1.setRole("User");
//		
////		memberRep.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("회원2");
//		member2.setName("김민재");
//		member2.setPassword("1234");
//		member2.setRole("관리자");
//		
////		memberRep.save(member2);
//		
//		for (int i = 1; i <= 5; i++) {
//			Board board = new Board();
//			board.setMember(member1);
//			board.setTitle("흥민이가 등록한 글" + i);
//			board.setContent("흥민이가 등록한 글 내용"+i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
////			boardRep.save(board);
//		}
//		for (int i = 1; i <= 5; i++) {
//			Board board = new Board();
//			board.setMember(member2);
//			board.setTitle("민재가 등록한 글" + i);
//			board.setContent("민재가 등록한 글 내용"+i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
////			boardRep.save(board);
//		}
//	}
//	@Test //글 조회 검색 테스트
//	public void testManyToOneSelect() {
//		Board board = boardRep.findById(5L).get();
//		
//		System.out.println("[ "+board.getSeq()+"번 게시글 정보 ]");
//		System.out.println("제목 : " + board.getTitle());
//		System.out.println("내용 : " + board.getContent());
//		System.out.println("작성자 : " + board.getWriter());
//		System.out.println("작성일 : " + board.getCreateDate());
//		System.out.println("작성자 권한 : " + board.getMember().getRole());
//	}
//
//	@Test
//	public void testTwoWayMapping() {
//		Member member = memberRep.findById("회원1").get();
//		
//		System.out.println("===============");
//		System.out.println(member.getName() + "이(가) 저장한 게시글 목록");
//		System.out.println("==============");
//		List<Board> list = member.getPersonBoardList();
//		
//		for(Board board : list) {
//			System.out.println(board.toString());
//		}
//		//stackOverFlow가 발생하는 것을 두개의 객체에서 서로 계속해서 참조를 반복하기 때문..
//		//상호호출의 고리르 끊으려면  Board엔티티의 @ToString을 수정한다
//		
//	}
	
	@Test
	public void testCascadeDelete() {
		memberRep.deleteById("회원2");
	}
}
