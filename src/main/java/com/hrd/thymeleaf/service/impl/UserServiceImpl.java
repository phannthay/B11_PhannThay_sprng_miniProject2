package com.hrd.thymeleaf.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrd.thymeleaf.model.User;
import com.hrd.thymeleaf.repository.UserRepository;
import com.hrd.thymeleaf.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public boolean save(User user) {
		// TODO: save user to database
		String userHash = UUID.randomUUID().toString();
		user.setUser_hash(userHash);
		boolean status = userRepository.save(user);
		if (status) {
			System.out.println("USER ID : " + user.getId());
			System.out.println("User has been inserted!");
		} else {
			System.out.println("User has not been inserted!.");
		}
		return status;
	}
	

//	@Override
//	public boolean save(User user) {
//		// TODO: save user to database
//		String userHash = UUID.randomUUID().toString();
//		user.setUserHash(userHash);
//		boolean status = userRepository.save(user);
//		if (status) {
//			System.out.println("USER ID : " + user.getId());
//			System.out.println("User has been inserted!");
//		} else {
//			System.out.println("User has not been inserted!.");
//		}
//		return status;
//	}
//
//	@Override
//	public boolean deleteByUserHash(String userHash) {
//		// TODO: delete user from database by userHash
//		boolean status = userRepository.delete(userHash);
//		if (status) {
//			System.out.println("User has been deleted!");
//		} else {
//			System.out.println("User has not been deleted!.");
//		}
//		return status;
//	}
//
//	@Override
//	public boolean updateByUserHash(User user) {
//		// TODO: update user from database by userHash
//		boolean status = userRepository.update(user);
//		if (status) {
//			System.out.println("User has been updated!");
//		} else {
//			System.out.println("User has not been updated!");
//		}
//		return status;
//	}
//
//	@Override
//	public boolean saveBatch(List<User> users) {
//		return userRepository.saveBatch(users);
//	}

}
