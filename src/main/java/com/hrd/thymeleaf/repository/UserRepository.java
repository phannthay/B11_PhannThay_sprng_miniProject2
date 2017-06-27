package com.hrd.thymeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hrd.thymeleaf.model.User;

@Repository
public interface UserRepository {

	@Select("SELECT "
			+ "	id, "
			+ "	username, "
			+ "	email, "
			+ "	gender, "
			+ "	phonenumber,"
			+ "	status,"
			+ "	user_hash"
			+ " FROM "
			+ "	users")
	public List<User> findAll();
	@Insert("INSERT INTO users ("
		
			+ "	username, "
			+ "	email, "
			+ "	gender, "
			+ "	phonenumber, "
			+ "	status, "
			+ "	user_hash"
			+ "	) VALUES ("
			+ "	#{user.username},"
			+ "	#{user.email},"
			+ "	#{user.gender},"
			+ " #{user.phonenumber},"
			+ "	#{user.status},"
			+ "	#{user.user_hash} "
			+ ")")
	public boolean save(@Param("user") User user);
	
	
}
	

