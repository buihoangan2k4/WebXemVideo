package com.poly.service.impl;

import java.util.List;

import com.poly.dao.StartsDao;
import com.poly.dao.impl.StartsDaoImpl;
import com.poly.dto.VideoLikedInfor;
import com.poly.service.StartsService;

public class StartsServiceImpl implements StartsService{
	private StartsDao startsDao;
	public StartsServiceImpl() {
		startsDao = new StartsDaoImpl();
	}
	@Override
	public List<VideoLikedInfor> findVideoLikedInfor() {
		
		return startsDao.findVideoLikedInfor();
	}
	
}
