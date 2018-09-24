package com.teamsankya.studentapp2.dao;

import com.teamsankya.studentapp2.dto.MasterBean;

public interface StudentDAO {
	public void createStudent(MasterBean mbean);
	public MasterBean getStudent(int id);
	public void updateData(int id, String name);
	public void deleteBean(int id);

}		
