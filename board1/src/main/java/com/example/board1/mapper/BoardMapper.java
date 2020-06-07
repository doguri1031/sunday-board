package com.example.board1.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.board1.entity.Board;
import com.example.board1.util.Criteria;

@Mapper
public interface BoardMapper {
	
	public int write(Board board);
	
	public ArrayList<Board> boardList(Criteria cri);
	
	public int totalCount();
}
