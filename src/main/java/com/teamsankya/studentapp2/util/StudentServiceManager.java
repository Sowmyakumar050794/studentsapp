package com.teamsankya.studentapp2.util;

import java.io.FileReader;
import java.util.Properties;

import com.teamsankya.studentapp2.dao.StudentDAO;


public class StudentServiceManager {
	private StudentServiceManager() {}
	
	private static final StudentServiceManager STUDENT_SERVICE_MANAGER = new StudentServiceManager();
	public static StudentServiceManager getInstence() {
		return STUDENT_SERVICE_MANAGER;
	}
	public StudentDAO daoGenarater() {
		Properties properties = new Properties();
		String path = getClass().getResource("/student-config.properties").getPath();
		
		try {
			FileReader fileReader = new FileReader(path);
			properties.load(fileReader);
		} catch (Exception e1) { 
			e1.printStackTrace();
		}
		StudentDAO dao = null;
		
		try {
			dao = (StudentDAO)Class
					.forName(properties.getProperty("dao_class"))
					.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
	

}
