package com.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.domain.User;

public class InMemoryUserRepository implements UserRepository {
	
	private static long ID_GENERATOR = 1;
	private Set<User> users = new HashSet<>();
	
	@Override
	public void addUser(User user) {
		user.setUserId(ID_GENERATOR);
		ID_GENERATOR++;
		users.add(user);
		System.out.println(users);
	}

	@Override
	public User getUser(long id) {
		for(User user: users) {
			if(user.getUserId() == id) {
				return user;
			}
		}
		return new User();
	}

	@Override
	public void updateUser(User user) {
		users.add(user);
	}

	@Override
	public void deleteUser(User user) {
		users.remove(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usersList = new ArrayList<>(users);
		return usersList;
	}
	

}
