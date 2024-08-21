package com.poly.dao.impl;

import java.util.List;
import java.util.Map;

import com.poly.contain.NamedStored;
import com.poly.dao.AbstractDao;
import com.poly.dao.UserDao;
import com.poly.entity.User;

public class UserDaoImp extends AbstractDao<User> implements UserDao{

	@Override
	public User findById(Integer id) {
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String sql = "select o from User o where o.email= ?1";
		return super.findOne(User.class, sql, email);
	}

	@Override
	public User findByUsername(String username) {
		String sql = "select o from User o where o.username= ?1";
		return super.findOne(User.class, sql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		String sql = "select o from User o where o.username= ?1 AND o.password = ?2";
		return super.findOne(User.class, sql, username, password);
	}
	
	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}
	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return super.findAll(User.class, true, pageNumber, pageSize);
	}

	@Override
	public List<User> findUsersLikedVideoByVideoHref(Map<String, Object> params) {
		return super.callStored(NamedStored.FIND_USER_LIKED_VIDEO_BY_VIDEO_HREF, params);
	}
}
