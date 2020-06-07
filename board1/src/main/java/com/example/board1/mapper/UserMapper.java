package com.example.board1.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.board1.dto.User;

@Mapper
public interface UserMapper {
	
	public User login(User user);
	public int signIn(User user);
	
}
