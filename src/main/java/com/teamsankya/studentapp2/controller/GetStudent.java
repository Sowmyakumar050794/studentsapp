package com.teamsankya.studentapp2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.studentapp2.dao.StudentDAO;
import com.teamsankya.studentapp2.dto.MasterBean;
import com.teamsankya.studentapp2.util.StudentServiceManager;

public class GetStudent extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("regno"));
		
		
		StudentDAO dao = StudentServiceManager
				.getInstence()
				.daoGenarater();
		MasterBean bean = dao.getStudent(id);
		PrintWriter out = resp.getWriter();
		out.println("Regno : " + bean.getInfo().getRegno());
		out.println("First Nname:   " + bean.getInfo().getFname());
		out.println("Middle Name  : " + bean.getInfo().getMname());
		out.println("Last Name : " + bean.getInfo().getLname());
		out.println("Parent First name : "+bean.getGard().getGfname());
		out.println("Parent middle name : "+bean.getGard().getGmname());
		out.println("Parent Last name : "+bean.getGard().getGlname());
		out.println(" Adress Type :"+bean.getAddr().getAddr_type());
		out.println("Adress Line 1 :"+ bean.getAddr().getAddr1());
		out.println("Adress Line 2 :"+ bean.getAddr().getAddr2());
		out.println("City :"+ bean.getAddr().getCity());
		out.println("Pincode :"+ bean.getAddr().getPincode());
		
		
		
	}

}
