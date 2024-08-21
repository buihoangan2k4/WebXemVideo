package com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.contain.sessionAttr;
import com.poly.entity.User;
import com.poly.service.SendMailService;
import com.poly.service.UserService;
import com.poly.service.impl.SendMailServiceImpl;
import com.poly.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/login", "/logout", "/register", "/forgotPass", "/changePass"})
public class UserController extends HttpServlet {
	private SendMailService sendmail = new SendMailServiceImpl();
	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(req, resp);
			break;
		case "/register":
			doGetRegister(req, resp);
			break;
		case "/logout":
			doGetLogout(session, req, resp);
			break;
		case "/forgotPass":
			doGetForgotPass(req, resp);
			break;
		}
	}
	protected void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
	}
	protected void doGetRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
	}
	protected void doGetLogout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session.removeAttribute(sessionAttr.CURRENT_USER);
		resp.sendRedirect("index");
	}
	protected void doGetForgotPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/fogotpass.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(session, req, resp);
			break;
		case "/register":
			doPostRegister(session, req, resp);
			break;
		case "/forgotPass":
			doPostForgotPass(req, resp);
			break;
		case "/changePass":
			doPostChangePass(session, req, resp);
			break;
		}
	}

	protected void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userService.login(username, password);
		
		if (user != null) {
			session.setAttribute(sessionAttr.CURRENT_USER, user);
			resp.sendRedirect("index");
		}else {
			resp.sendRedirect("login");
		}
	}
	protected void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		User user = userService.create(username, password, email);
		
		if (user != null) {
			sendmail.sendEmail(getServletContext(), user, "welcome");
			session.setAttribute(sessionAttr.CURRENT_USER, user);
			resp.sendRedirect("index");
		}else {
			resp.sendRedirect("register");
		}
	}
	protected void doPostForgotPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		String email = req.getParameter("email");
		User userWithNewpass = userService.resetPassword(email);
		if(userWithNewpass != null) {
			sendmail.sendEmail(getServletContext(), userWithNewpass, "fogot");
			resp.setStatus(204);
		}else {
			resp.setStatus(400);
		}
	}
	protected void doPostChangePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		String currentPass = req.getParameter("currentPass");
		String newPass = req.getParameter("newPass");
		
		User currentUser = (User) session.getAttribute(sessionAttr.CURRENT_USER);
		
		if(currentUser.getPassword().equals(currentPass)) {
			currentUser.setPassword(newPass);
			User updateUser = userService.update(currentUser);
			if(updateUser != null) {
				session.setAttribute(sessionAttr.CURRENT_USER, updateUser);
				resp.setStatus(204);
			}else {
				resp.setStatus(400);
			}
		}else {
			resp.setStatus(400);
		}
		
	}
	
}
