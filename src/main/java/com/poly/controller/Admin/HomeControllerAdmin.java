package com.poly.controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.contain.sessionAttr;
import com.poly.dto.Userdto;
import com.poly.dto.VideoLikedInfor;
import com.poly.entity.User;
import com.poly.service.StartsService;
import com.poly.service.UserService;
import com.poly.service.impl.StartsServiceImpl;
import com.poly.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/admin", "/admin/favorites"},  name="HomeControlerOfAdmin")
public class HomeControllerAdmin extends HttpServlet{
	
	private StartsService startService = new StartsServiceImpl();
	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession   session = req.getSession();
		User currentUser = (User) session.getAttribute(sessionAttr.CURRENT_USER);
		if (currentUser != null && currentUser.getIsAdmin() == Boolean.TRUE) {
			String path = req.getServletPath();
			switch (path) {
			case "/admin":
				doGetHome(req, resp);
				break;
			case "/admin/favorites":
				doGetFavorites(req, resp);
				break;
			}
//			req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("index");
		}
	}
	private void doGetHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VideoLikedInfor> videos = startService.findVideoLikedInfor();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
	}
	
	private void doGetFavorites(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String videoHref = req.getParameter("href");
	    List<Userdto> users = userService.findUsersLikedVideoByVideoHref(videoHref);

	    resp.setCharacterEncoding("utf-8");
	    resp.setContentType("application/json");

	    if (users.isEmpty()) {
	        resp.setStatus(400);
	    } else {
	        ObjectMapper mapper = new ObjectMapper();
	        String dataResponse = mapper.writeValueAsString(users);
	        resp.setStatus(200);
	        PrintWriter out = resp.getWriter();
	        out.print(dataResponse);
	        out.flush();
	        return; // return to avoid further processing
	    }

	    req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
	}


}
