package com.teamsankya.studentapp2.dto;

import com.teamsankya.studentapp2.dto.StudentAddressInfoBean;
import com.teamsankya.studentapp2.dto.StudentGuardianInfoBean;
import com.teamsankya.studentapp2.dto.Student_infoBean;

public  class MasterBean {
	
	
private Student_infoBean info ;
private StudentAddressInfoBean addr;
private StudentGuardianInfoBean gard ;
public Student_infoBean getInfo() {
	return info;
}
public void setInfo(Student_infoBean info) {
	this.info = info;
}
public StudentAddressInfoBean getAddr() {
	return addr;
}
public void setAddr(StudentAddressInfoBean addr) {
	this.addr = addr;
}
public StudentGuardianInfoBean getGard() {
	return gard;
}
public void setGard(StudentGuardianInfoBean gard) {
	this.gard = gard;
}
	/*static Student_infoBean info = new Student_infoBean();
	static StudentAddressInfoBean addr = new StudentAddressInfoBean();
	static StudentGuardianInfoBean gard = new StudentGuardianInfoBean();*/
}
