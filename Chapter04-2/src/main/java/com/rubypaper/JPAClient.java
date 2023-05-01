package com.rubypaper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;


public class JPAClient {
	public static void main(String[] args) {
		//Entity manager생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04-2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			//트랜잭션 시작
			tx.begin();
			Board board = new Board();
			board.setTitle("JPA 제목입니다.");
			board.setWriter("JPA 관리자");
			board.setContent("글등록 잘되넹");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			//글등록
			em.persist(board);
			
			//글목록 조회
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql,Board.class).getResultList();
			for (Board brd : boardList) {
				System.out.println("-->"+brd.toString());
			}
			
//			//수정할 게시글 조회
//			Board findBoard = em.find(Board.class, 1L);
//			findBoard.setTitle("검색한 게시글의 제목을 수정");
//			//삭제할 게시글 조회
//			Board removeBoard = em.find(Board.class, 1L);
//			removeBoard.setSeq(1L);
//			//게시글 삭제
//			removeBoard.setSeq(1L);
//			em.remove(removeBoard);
			//트랜잭션 커밋
			tx.commit();
			//검색기능 테스트
			//Board searchBoard = em.find(Board.class, 1L);
			//System.out.println("--->"+ searchBoard.toString());
		} catch (Exception e) {
			e.printStackTrace();
			//트랜잭션 롤백
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
