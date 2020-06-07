package com.example.board1.repository;

import com.example.board1.dto.User;

public interface UserRepository {

	public User login(User user);
	public int signIn(User user);
	
}
