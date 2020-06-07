package com.example.board1.repository;

import java.util.ArrayList;

import com.example.board1.entity.Board;
import com.example.board1.util.Criteria;

public interface BoardRepository {

	public int write(Board board);
	
	public ArrayList<Board> boardList(Criteria cri);
	
	public int totalCount();
	
}
