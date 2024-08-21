package com.poly.controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.contain.sessionAttr;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.VideoService;
import com.poly.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = { "/admin/video" }, name = "VideoControllerOfAdmin")
public class VideoControllerAdmin extends HttpServlet {

	private VideoService videoSevice = new VideoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(sessionAttr.CURRENT_USER);

//		if(currentUser != null|| currentUser.getIsAdmin() == Boolean.TRUE) {
		String action = req.getParameter("action");
		switch (action) {
		case "view": {
			doGetOverViews(req, resp);
			break;
		}
		case "delete": {
			doGetDelete(req, resp);
			break;
		}
		case "add": {
			req.setAttribute("isEdit", false);
			doGetAdd(req, resp);
			break;
		}
		case "edit": {
			req.setAttribute("isEdit", true);
			doGetEdit(req, resp);
			break;
		}
		}
	}

	private void doGetOverViews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Video> videos = videoSevice.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/video-overview.jsp").forward(req, resp);

	}

	private void doGetDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		String href = req.getParameter("href");
		Video videoDelete = videoSevice.delete(href);
		if (videoDelete != null) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}

		List<Video> videos = videoSevice.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/video-overview.jsp").forward(req, resp);
	}

	private void doGetAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
	}

	private void doGetEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String href = req.getParameter("href");
		Video video = videoSevice.findByHref(href);
		req.setAttribute("video", video);
		req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(sessionAttr.CURRENT_USER);

		if (currentUser != null || currentUser.getIsAdmin() == Boolean.TRUE) {
			String action = req.getParameter("action");
			switch (action) {
			case "add": {
				
				doPostAdd(req, resp);
				break;
			}
			case "edit": {
				
				doPostEdit(req, resp);
				break;
			}
			}
		} else {
			resp.sendRedirect("index");
		}
	}

	private void doPostAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		String title = req.getParameter("title");
		String href = req.getParameter("href");
		String decscription = req.getParameter("decscription");
		String poster = req.getParameter("poster");

		Video video = new Video();
		video.setTitle(title);
		video.setDescription(decscription);
		video.setHref(href);
		video.setPoster(poster);

		Video videoReturn = videoSevice.create(video);
		if (videoReturn != null) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}

	private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		String title = req.getParameter("title");
		String href = req.getParameter("href");
		String decscription = req.getParameter("description");
		String poster = req.getParameter("poster");
		String hrefOrigin =req.getParameter("hrefOrigin");
 
		Video video = videoSevice.findByHref(hrefOrigin);
		video.setTitle(title);
		video.setDescription(decscription);
		video.setHref(href);
		video.setPoster(poster);

		Video videoReturn = videoSevice.update(video);
		if (videoReturn != null) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}

}
