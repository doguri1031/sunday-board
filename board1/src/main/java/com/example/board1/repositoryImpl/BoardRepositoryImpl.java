package com.example.board1.repositoryImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board1.entity.Board;
import com.example.board1.mapper.BoardMapper;
import com.example.board1.repository.BoardRepository;
import com.example.board1.util.Criteria;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

	@Autowired
	BoardMapper mapper;
	
	public int write(Board board) {
		
		return mapper.write(board);
	}
	
	public ArrayList<Board> boardList(Criteria cri) {
		
		return mapper.boardList(cri);
	}
	
	public int totalCount() {
		
		return mapper.totalCount();
	}
}
