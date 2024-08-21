package com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.contain.sessionAttr;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;
	@WebServlet(urlPatterns = "/video")
	public class VideoController extends HttpServlet {
	    private VideoService videoService = new VideoServiceImpl();
	    private HistoryService historyService = new HistoryServiceImpl();

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String actionParam = req.getParameter("action");
	        String href = req.getParameter("id"); // Sử dụng phương thức getParameter để lấy giá trị của tham số "id"
	        HttpSession session = req.getSession();
	        if (actionParam != null) {
	            switch (actionParam) {
	                case "watch":
	                    doGetWatch(session, href, req, resp);
	                    break;
	                case "like":
	                	doGetLike(session, href, req, resp);
	                	break;
	            }
	        } else {
	            // Xử lý khi không có tham số "action"
	            resp.sendRedirect(req.getContextPath());
	        }
	    }

	    protected void doGetWatch(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        Video video = videoService.findByHref(href);
	        req.setAttribute("video", video);
	        User currentUser = (User)session.getAttribute(sessionAttr.CURRENT_USER);
	        
	        if (currentUser !=null) {
	        	History history = historyService.create(currentUser, video);
	        	req.setAttribute("flagLikedBtn", history.getIsLiked());
	        }
	        req.getRequestDispatcher("/views/user/video-detail.jsp").forward(req, resp);
	    }
	    protected void doGetLike(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        resp.setContentType("application/json");
	        User currentUser = (User)session.getAttribute(sessionAttr.CURRENT_USER);
	        boolean result = historyService.updateLikeorUnlike(currentUser, href);
	        if(result == true) {
	        	resp.setStatus(204);//success but no response data
	        }else {
	        	resp.setStatus(400);
	        }
	        req.getRequestDispatcher("/views/user/video-detail.jsp").forward(req, resp);
	    }
	    

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        // Xử lý phương thức POST nếu cần
	        super.doPost(req, resp);
	    }
	}

