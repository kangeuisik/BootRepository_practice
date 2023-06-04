package com.rubypaper.controller;


import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

	
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	@GetMapping("/insertBoard")
	public String insertBoard() {
		return "insertBoard";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(Board board){
		boardService.insertBorad(board);
		return "redirect:getBoardList";
	}
	@GetMapping("/getBoard")
	public String getBoard(Model model, Board board) {
		model.addAttribute("board",boardService.getBorad(board));
		return "getBoard";
	}
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBorad(board);
		return "forward:getBoardList";
	}
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBorad(board);
		return "forward:getBoardList";
	}
	
}
