package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

	//searchKeyword는 검색기능 사용할때.
	List<Board> findByTitle(String searchKeyword);
	
	
	//게시글 내부에 특정 단어가 있는지 포함 목록을 검색할때 findByContentContaining 메소드 추가.
	List<Board> findByContentContaining(String searchKeyword);
	//Containing은 특정 단어를 포함한 검색조건을 활용할때 사용
	
	//AND,OR연산자 사용하여 여러조건 사용하기
	//WHERE절에 추가될 여러도건을 메소드이름으로 표현해야하기 때문에 길이가 길수 밖에 없음.
	//OR연산자를 사용하여 Title과 Content 두가지를 지정했기 때문에 변수는 2개가 된다.
	List<Board> findByTitleContainingOrContentContaining(String title, String content);

	
	//데이터정렬조회 OrderBy+변수+'Asc' Or 'Desc'
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	//seq 변수값을 내림차순으로 출력
	
	//페이징처리 마지막 파라미터로 Pageable인터페이스아 sort인터페이스 추가가능
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

//	//@Query 어노테이션 활용
//	//JPQL을 사용해야 하거나 성능상 특정데이터베이스에 종속적인 네이티브쿼리를 사용할때
//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);
//	//검색대상 테이블이 아니라 영속성 컨텍스트에 등록된 엔티티기 때문에 
//	//select/FROM/where절의 테이블명을 대소문자 구분하여 작성
//
//	//이름 기반으로 파라미터 사용
//	@Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
//	//:searchKeyword파라미터에 매개변수로 받은 searchKeyword값을 @Param 어노테이션으로 바인딩 시킴
//
//	//특정변수만 조회
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate "
//			+ "FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);
////	//엔티티 객체가 조회되는 것이 아니라 여러변수의 값들이 조회되는 것이므로 return타입을
//	//Object[]로 한 것.
//	//@Query로 등록한 Sql은 프로젝트가 실행될때 파싱되는 것이므로 오류나 예외가 있을경우 실행되지 않는다
	
	
	//네이티브 쿼리 사용하기
	//특정 DB에 종속되는다는 문제도 있지만
	//특정 DB에 최적화된 쿼리를 사용한경우 유용
//	@Query(value="SELECT seq, title, writer, create_date "
//			+ "FROM Board WHERE title like '%'||?1||'%' "
//			+ "ORDER BY seq DESC", nativeQuery=true)
//	List<Object[]> queryAnnotationTest4(String searchKeyword);
//	
//	//페이징 및 정렬 처리하기
//	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest5(Pageable paging);
//	


}
