package com.poly.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.poly.dao.AbstractDao;
import com.poly.dao.StartsDao;
import com.poly.dto.VideoLikedInfor;
import com.poly.entity.User;

public class StartsDaoImpl extends AbstractDao<Object[]>implements StartsDao{

	@Override
	public List<VideoLikedInfor> findVideoLikedInfor() {
	    String sql = "select v.id, v.title, v.href, sum(cast(h.isLiked as int)) as totalLike"
	                + " from video v left join history h on v.id = h.videoId"
	                + " where v.isActive = 1"
	                + " group by v.id, v.title, v.href"
	                + " order by sum(cast(h.isLiked as int)) desc"; // Sửa cú pháp của ORDER BY

	    List<Object[]> objects = super.findManyByNativeQuery(sql);
	    List<VideoLikedInfor> result = new ArrayList<>();

	    // Lặp qua mỗi mảng đối tượng và tạo các đối tượng VideoLikedInfor
	    for (Object[] object : objects) {
	        VideoLikedInfor videoLikedInfo = new VideoLikedInfor();
	        videoLikedInfo.setId((Integer)object[0]); // Giả sử cột đầu tiên là ID
	        videoLikedInfo.setTitle((String) object[1]); // Giả sử cột thứ hai là Title
	        videoLikedInfo.setHref((String) object[2]); // Giả sử cột thứ ba là Href
	        videoLikedInfo.setTotalLiked((Integer) object[3]); // Giả sử cột thứ tư là TotalLike
	        result.add(videoLikedInfo);
	    }

	    return result;
	}
}
