package com.example.board1.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board1.dto.User;
import com.example.board1.mapper.UserMapper;
import com.example.board1.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	UserMapper mapper;
	
	public User login(User user) {
		
		return mapper.login(user);
	}
	
	public int signIn(User user) {
		
		return mapper.signIn(user);
	}
}