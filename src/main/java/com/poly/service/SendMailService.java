package com.poly.service;

import javax.servlet.ServletContext;

import com.poly.entity.User;

public interface SendMailService {
	void sendEmail(ServletContext context, User recipient, String type);
}
