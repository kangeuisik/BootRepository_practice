package com.rubypaper.service;

import java.util.List;

import com.rubypaper.domain.Board;

public interface BoardService {

	//글목록
	List<Board> getBoardList(Board board);

	//글작성
	void insertBorad(Board board);

	//글보기?
	Board getBorad(Board board);

	//글수정
	void updateBorad(Board board);

	//글삭제
	void deleteBorad(Board board);

}