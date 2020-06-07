package com.example.board1.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.example.board1.dto.BoardDTO;
import com.example.board1.entity.Board;
import com.example.board1.util.Criteria;

public interface BoardService {

	public boolean write(BoardDTO board, HttpSession session);
	
	public ArrayList<Board> boardList(Criteria cri);
	
	public int totalCount();
	
}
