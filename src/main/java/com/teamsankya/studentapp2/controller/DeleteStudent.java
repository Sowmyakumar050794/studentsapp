package com.teamsankya.studentapp2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.studentapp2.dao.StudentDAO;
import com.teamsankya.studentapp2.util.StudentServiceManager;

public class DeleteStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("regno"));
		
		
		StudentDAO dao = StudentServiceManager
				.getInstence()
				.daoGenarater();
		dao.deleteBean(id);
		
	}

}
