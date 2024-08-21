package com.poly.service;

import java.util.List;
import java.util.Map;

import com.poly.dto.Userdto;
import com.poly.entity.User;

public interface UserService {
		User findById(Integer id);
		User findByEmail(String email);
		User findByUsername(String username);
		User login(String username, String password);
		User resetPassword(String email);
		
		List<User>findAll();
		List<User>findAll(int bageNumber, int bageSize);
		
		User create(String username, String password, String email);
		User update(User entity);
		User delete(String username);
		List<Userdto> findUsersLikedVideoByVideoHref(String href);
	}


