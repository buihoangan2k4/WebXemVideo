package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.AbstractDao;
import com.poly.dao.HistoryDao;
import com.poly.entity.History;

public class HistoryDaoImp extends AbstractDao<History> implements HistoryDao{

	@Override
	public List<History> findByUser(String username) {
		String sql = "Select o From History o Where o.user.username = ?1 AND o.video.isActive = 1 "
				+" ORDER BY o.viewedDate DESC";
		return super.findMany(History.class, sql, username);
	}

	@Override
	public List<History> findByuserAndIsLike(String username) {
		String sql = "Select o From History o Where o.user.username =?1 AND o.isLiked = 1"
				 	+ " AND o.video.isActive = 1 " 
				 	+ " ORDER BY o.viewedDate DESC";
		return super.findMany(History.class, sql, username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		String sql = "SELECT o FROM History o WHERE o.user.id = ?1 AND o.video.id = ?2"
					+ " AND o.video.isActive = 1";
		return super.findOne(History.class, sql, userId, videoId);
	}
}
