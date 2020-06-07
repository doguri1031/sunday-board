package com.example.board1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.board1.entity.Board;
import com.example.board1.service.BoardService;
import com.example.board1.util.Criteria;
import com.example.board1.util.Pageable;

@Controller
public class MainController {

	public static final String EMPTY_DATA = "등록된 글이 없습니다.";

	@Autowired
	BoardService service;

	@GetMapping("/")
	public ModelAndView index(ModelAndView mv) {

		Criteria cri = new Criteria();
		
		ArrayList<Board> list = service.boardList(cri);
		int totalCount = service.totalCount();
		Pageable pageable = new Pageable();
		pageable.setCri(cri);
		pageable.setTotalCount(totalCount);

		if (list.isEmpty()) {

		} else {

			mv.addObject("boardList", list);
			mv.addObject("pageable", pageable);
		}

		mv.setViewName("index");

		return mv;
	}

}
