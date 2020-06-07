package com.example.board1.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board1.dto.BoardDTO;
import com.example.board1.entity.Board;
import com.example.board1.repository.BoardRepository;
import com.example.board1.service.BoardService;
import com.example.board1.util.Criteria;

@Service
public class BoardServiceIpml implements BoardService {

	@Autowired
	BoardRepository repository;
	
	public boolean write(BoardDTO board, HttpSession session) {

		Board entity = new Board();

		entity.setTitle(board.getTitle());
		entity.setContents(board.getContents());
		entity.setUser((String) session.getAttribute("user_id"));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		  LocalDateTime now = LocalDateTime.now();

		entity.setInsert_date(dtf.format(now));
		
		int	writeResult = repository.write(entity);
		
		
		if(writeResult > 0) {
			return true;
		}

		return false;
	}

	
	public ArrayList<Board> boardList(Criteria cri){
		
		ArrayList<Board> boardList = repository.boardList(cri);
		
		for (Board list : boardList) {
			
			if(list.getTitle().length() > 10) {
				list.setTitle(list.getTitle().substring(0, 10).concat("..."));
			}
		}
		return boardList;
	}
	
	public int totalCount() {
		return repository.totalCount();
	}
}
