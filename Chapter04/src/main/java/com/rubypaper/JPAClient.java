package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient {
	public static void main(String[] args) {
		//Entity manager생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
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
