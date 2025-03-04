package com.poly.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.dao.UserDao;
import com.poly.dao.impl.UserDaoImp;
import com.poly.dto.Userdto;
import com.poly.entity.User;
import com.poly.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao dao;
	public UserServiceImpl() {
		dao = new UserDaoImp();
	}
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public User resetPassword(String email) {
		User existUser=  findByEmail(email);
		if(existUser!=null) {
			String newPass = String.valueOf((int)(Math.random() * ((9999 - 1000) + 1)) + 1000);
			existUser.setPassword(newPass); 
			return dao.update(existUser);
		}
		return null;
	}
	@Override
	public List<User> findAll(int bageNumber, int bageSize) {
		// TODO Auto-generated method stub
		return dao.findAll(bageNumber, bageSize);
	}

	@Override
	public User create(String username, String password, String email) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setIsAdmin(Boolean.FALSE);
		newUser.setIsActive(Boolean.TRUE);
		return dao.create(newUser);
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public User delete(String username) {
		User user = dao.findByUsername(username);
		user.setIsActive(Boolean.FALSE);
		return dao.update(user);
	}
	@Override
	public List<Userdto> findUsersLikedVideoByVideoHref(String href) {
		Map<String, Object> params = new HashMap<>();
		params.put("videoHref", href);
		List<User>users = dao.findUsersLikedVideoByVideoHref(params);
		List<Userdto> result = new ArrayList<>();
		users.forEach(user ->{
			Userdto dto = new Userdto();
			dto.setUsername(user.getUsername());
			dto.setEmail(user.getEmail());
			result.add(dto);
		});
		return result;
	}
	
}
