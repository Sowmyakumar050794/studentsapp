package com.teamsankya.studentapp2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.studentapp2.dao.StudentDAO;
import com.teamsankya.studentapp2.dto.MasterBean;
import com.teamsankya.studentapp2.dto.StudentAddressInfoBean;
import com.teamsankya.studentapp2.dto.StudentGuardianInfoBean;
import com.teamsankya.studentapp2.dto.Student_infoBean;
import com.teamsankya.studentapp2.util.StudentServiceManager;


public class CreateStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student_infoBean info = new Student_infoBean();
		info.setFname(req.getParameter("fname"));
		info.setLname(req.getParameter("lname"));
		info.setMname(req.getParameter("mname"));
		info.setRegno(Integer.parseInt(req.getParameter("regno")));


		StudentAddressInfoBean addr = new StudentAddressInfoBean();
		addr.setRegno(Integer.parseInt(req.getParameter("regno")));
		addr.setAddr1(req.getParameter("address1"));
		addr.setAddr2(req.getParameter("address2"));
		addr.setAddr_type(req.getParameter("type"));
		addr.setAddr_type(req.getParameter("city"));
		addr.setPincode(Integer.parseInt(req.getParameter("pincode")));


		StudentGuardianInfoBean gard = new StudentGuardianInfoBean();
		gard.setRegno(Integer.parseInt(req.getParameter("regno")));
		gard.setGfname(req.getParameter("guardian first name"));
		gard.setGmname(req.getParameter("guardian middle name"));
		gard.setGlname(req.getParameter("guardian last name"));


		MasterBean bean = new MasterBean();
		bean.setInfo(info);
		bean.setAddr(addr);
		bean.setGard(gard);
		
		StudentDAO dao = StudentServiceManager
				.getInstence()
				.daoGenarater();
		dao.createStudent(bean);
		req.getRequestDispatcher("createResponse.jsp")
		.forward(req, resp);

}
}

