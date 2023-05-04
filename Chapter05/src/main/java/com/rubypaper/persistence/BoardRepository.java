package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

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
	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);

}
