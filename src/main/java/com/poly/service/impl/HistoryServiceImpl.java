package com.poly.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.poly.dao.HistoryDao;
import com.poly.dao.impl.HistoryDaoImp;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;

public class HistoryServiceImpl implements HistoryService{
	private HistoryDao dao;
	private VideoService videoService;
	public HistoryServiceImpl() {
		dao = new HistoryDaoImp();
		videoService = new VideoServiceImpl();
	}
	@Override
	public List<History> findByUser(String username) {
		return dao.findByUser(username);
	}

	@Override
	public List<History> findByuserAndIsLike(String username) {
		// TODO Auto-generated method stub
		return dao.findByuserAndIsLike(username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		// TODO Auto-generated method stub
		return dao.findByUserIdAndVideoId(userId, videoId);
	}

	@Override
	public History create(User user, Video video) {
		History existHistory = findByUserIdAndVideoId(user.getID(), video.getID());
		if(existHistory == null) {
			existHistory = new History();
			existHistory.setUser(user);
			existHistory.setVideo(video);
			existHistory.setIsLiked(Boolean.FALSE);
			existHistory.setViewdDate(new Timestamp(System.currentTimeMillis()));
			return dao.create(existHistory);
		}
		return existHistory;
	}

	
//	@Override
//	public Boolean updateLikeorUnlike(User user, String videoHref) {
//	    Video video = videoService.findByHref(videoHref);
//	    History exitsHistory = findByUserIdAndVideoId(user.getID(), video.getID());
//	    if (exitsHistory != null) {
//	        if (exitsHistory.getIsLiked() == Boolean.FALSE) {
//	            exitsHistory.setIsLiked(Boolean.TRUE);
//	            exitsHistory.setLikeDate(new Timestamp(System.currentTimeMillis()));
//	        } else {
//	            exitsHistory.setIsLiked(Boolean.FALSE);
//	            exitsHistory.setLikeDate(null);
//	        }
//	        History updateHistory = dao.update(exitsHistory);
//	        return updateHistory != null;
//	    } else {
//	        return false;
//	    }
//	}


	@Override
	public Boolean updateLikeorUnlike(User user, String videoHref) {
		Video video = videoService.findByHref(videoHref);
		History exitsHistory = findByUserIdAndVideoId(user.getID(), video.getID());
		if(exitsHistory.getIsLiked() == Boolean.FALSE) {
			exitsHistory.setIsLiked(Boolean.TRUE);
			exitsHistory.setLikeDate(new Timestamp(System.currentTimeMillis()));
		}else {
			exitsHistory.setIsLiked(Boolean.FALSE);
			exitsHistory.setLikeDate(null);
		}
		History updateHistory = dao.update(exitsHistory);
		return updateHistory!=null ? true : false;
	}

	@Override
	public History delete(History entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
