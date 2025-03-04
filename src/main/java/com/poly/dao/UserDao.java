package com.poly.dao;

import java.util.List;
import java.util.Map;

import com.poly.entity.User;

public interface UserDao {
	User findById(Integer id);
	User findByEmail(String email);
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String Password);
	
	List<User>findAll();
	List<User>findAll(int bageNumber, int bageSize);
	
	User create(User entity);
	User update(User entity);
	User delete(User entity);
	List<User> findUsersLikedVideoByVideoHref(Map<String, Object> params);
}
