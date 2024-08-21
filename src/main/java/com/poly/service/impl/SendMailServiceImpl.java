package com.poly.service.impl;

import javax.servlet.ServletContext;

import com.poly.entity.User;
import com.poly.service.SendMailService;
import com.poly.util.SendmailUtil;

public class SendMailServiceImpl implements SendMailService {
	private static final String EMAIL_WELCOME_SUBJECT = "Welcome to Online Entertaiment";
	private static final String EMAIL_FORGOT_PASSWORD = "Online Entertaiment - New Password";

	@Override
	public void sendEmail(ServletContext context, User recipient, String type) {
		String host = context.getInitParameter("host");
		String port = context.getInitParameter("port");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");
		try {
			String content = null;
			String subject = null;
			switch (type) {
			case "welcome":
				subject = EMAIL_WELCOME_SUBJECT;
				content = "Dear " + recipient.getUsername() + " Welcome";
				break;
			case "forgotPass":
				subject = EMAIL_FORGOT_PASSWORD;
				content = "Dear" + recipient.getUsername() + ", your new password here"+recipient.getPassword();
				default: 
				subject = "Online Entertiment";
				content = "Loi roi";
			}
			SendmailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
