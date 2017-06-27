package com.hrd.thymeleaf.service;

import java.util.List;

import com.hrd.thymeleaf.model.User;


public interface UserService {

	public List<User> findAll();
	public boolean save(User user);
//	public boolean deleteByUserHash(String userHash);
//	public boolean updateByUserHash(User user);
//	public boolean saveBatch(List<User> users);
	

	
}
