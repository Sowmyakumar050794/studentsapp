package com.teamsankya.studentapp2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.studentapp2.dao.StudentDAO;
import com.teamsankya.studentapp2.util.StudentServiceManager;

public class UpdateName extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("regno");
		String name = req.getParameter("fname");
		
		StudentDAO dao = StudentServiceManager
				.getInstence()
				.daoGenarater();
		dao.updateData(Integer.parseInt(id), name);
		
		
	}

}
