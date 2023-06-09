package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRep;
	//글목록

	public List<Board> getBoardList(Board board){
		return (List<Board>) boardRep.findAll();
	}
	//글작성

	public void insertBorad(Board board) {
		boardRep.save(board);
	}
	//글보기?
	public Board getBorad(Board board) {
		return boardRep.findById(board.getSeq()).get();
		// getBoard()메소드는 BoardRepository의 findById메소드를 통해 특정 게시글을 상세조회 하여 리턴...
	}
	//글수정
	public void updateBorad(Board board) {
		Board findBoard = boardRep.findById(board.getSeq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRep.save(findBoard);
	}
	//글삭제
	public void deleteBorad(Board board) {
		boardRep.deleteById(board.getSeq());
	}
}
