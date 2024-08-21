package com.poly.service;

import java.util.List;

import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;

public interface HistoryService {
	
	List<History> findByUser(String username);
	List<History> findByuserAndIsLike(String username);
	History findByUserIdAndVideoId(Integer userId, Integer videoId);
	
	History create(User user, Video video);
	Boolean updateLikeorUnlike(User user, String videoHref);
	History delete(History entity);
	
}

