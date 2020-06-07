package com.example.board1.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.board1.dto.BoardDTO;
import com.example.board1.entity.Board;
import com.example.board1.service.BoardService;
import com.example.board1.util.Criteria;
import com.example.board1.util.Pageable;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping("/write")
	public ModelAndView writePage(ModelAndView mv, HttpSession session) {

		if (session.getAttribute("user_id") == null) {

			mv.setViewName("error");
		} else {

			mv.setViewName("write");
		}

		return mv;
	}

	@PostMapping("/write")
	public ModelAndView doWrite(ModelAndView mv, BoardDTO board, HttpSession session) {

		boolean writeResult = service.write(board, session);

		if (writeResult) {
			mv.setViewName("redirect:/");
		} else {
			mv.setViewName("error");
		}
		return mv;
	}
	
	@GetMapping("/listPage")
	public ModelAndView getListPage(ModelAndView mv, Criteria cri) {
		int totalCount = service.totalCount();
		Pageable pageable = new Pageable();
		pageable.setCri(cri);
		pageable.setTotalCount(totalCount);
		
		ArrayList<Board> list = service.boardList(cri);
		
		mv.addObject("boardList", list);
		mv.addObject("pageable", pageable);
		
		mv.setViewName("index");
		
		
		return mv;
	}
}
