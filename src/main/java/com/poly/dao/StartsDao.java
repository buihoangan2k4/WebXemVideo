package com.poly.dao;

import java.util.List;

import com.poly.dto.VideoLikedInfor;
import com.poly.entity.User;

public interface StartsDao {
	List<VideoLikedInfor> findVideoLikedInfor();
}
