package com.repository;

import java.util.List;

import com.domain.User;

public interface UserRepository {

	public void addUser(User user);
	
	public User getUser(long id);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public List<User> getAllUsers();
	
}
