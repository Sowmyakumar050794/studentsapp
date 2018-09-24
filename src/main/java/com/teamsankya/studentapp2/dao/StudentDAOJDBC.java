package com.teamsankya.studentapp2.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.teamsankya.studentapp2.dto.MasterBean;
import com.teamsankya.studentapp2.dto.StudentAddressInfoBean;
import com.teamsankya.studentapp2.dto.StudentGuardianInfoBean;
import com.teamsankya.studentapp2.dto.Student_infoBean;

public class StudentDAOJDBC implements StudentDAO {

	
	public void createStudent(MasterBean mbean) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/studentapp?user=root&password=root");
					PreparedStatement pstmt1 = con.prepareStatement("insert into student_info  values(?,?,?,?)");
					PreparedStatement pstmt2 = con.prepareStatement("insert into guardian_info  values(?,?,?,?)");
					PreparedStatement pstmt3 = con.prepareStatement("insert into student_addressinfo  values(?,?,?,?,?,?)");) {

				pstmt1.setInt(1, mbean.getInfo().getRegno());
				pstmt1.setString(2, mbean.getInfo().getFname());
				pstmt1.setString(3, mbean.getInfo().getMname());
				pstmt1.setString(4, mbean.getInfo().getLname());

				pstmt2.setInt(1, mbean.getGard().getRegno());
				pstmt2.setString(2, mbean.getGard().getGfname());
				pstmt2.setString(4, mbean.getGard().getGlname());
				pstmt2.setString(3, mbean.getGard().getGmname());

				pstmt3.setInt(1, mbean.getAddr().getRegno());
				pstmt3.setString(2, mbean.getAddr().getAddr_type());
				pstmt3.setString(3, mbean.getAddr().getAddr1());
				pstmt3.setString(4, mbean.getAddr().getAddr2());
				pstmt3.setString(5, mbean.getAddr().getCity());
				pstmt3.setInt(6, mbean.getAddr().getPincode());
				boolean p1=pstmt1.execute();
				boolean p2=pstmt2.execute();
				boolean p3=pstmt3.execute();
				System.out.println(p1+" "+p2+" "+p3);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public MasterBean getStudent(int id) {
		MasterBean bean = new MasterBean();
		Student_infoBean info = new Student_infoBean();
		StudentAddressInfoBean addr = new StudentAddressInfoBean();
		StudentGuardianInfoBean gard = new StudentGuardianInfoBean();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/studentapp?user=root&password=root")) {
				con.setAutoCommit(false);
				try (PreparedStatement pstmt = con.prepareStatement("select * from student_info where regno=?");
						PreparedStatement pstmt2 = con.prepareStatement("select * from guardian_info where regno=?");
						PreparedStatement pstmt3 = con.prepareStatement("select * from student_addressinfo where regno=?"))

				{
					pstmt.setInt(1, id);

					try (ResultSet rs = pstmt.executeQuery()) {
						if (rs.next()) {
							System.out.println("student found");
							info.setRegno(rs.getInt("regno"));

							info.setFname(rs.getString("fname"));
							info.setMname(rs.getString("mname"));
							info.setLname(rs.getString("fname"));

						}

					}

					pstmt2.setInt(1, id);
					try (ResultSet rs1 = pstmt2.executeQuery()) {
						if (rs1.next()) {
							gard.setRegno(rs1.getInt("regno"));
							gard.setGfname(rs1.getString("gfname"));
							gard.setGmname(rs1.getString("gmname"));
							gard.setGlname(rs1.getString("glname"));

						}

					}

					pstmt3.setInt(1, id);
					try (ResultSet rs2 = pstmt3.executeQuery()) {
						if (rs2.next()) {
							System.out.println("Address found");
							addr.setRegno(rs2.getInt("regno"));
							addr.setPincode(rs2.getInt("pincode"));
							addr.setAddr1(rs2.getString("addr1"));
							addr.setAddr2(rs2.getString("addr2"));
							addr.setAddr_type(rs2.getString("addr_type"));
							addr.setCity(rs2.getString("city"));

						}
					}
					bean.setAddr(addr);
					bean.setGard(gard);
					bean.setInfo(info);

					con.commit();

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;

	}

	
	public void updateData(int id, String name) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/studentapp?user=root&password=root")) {
				con.setAutoCommit(false);
				try (PreparedStatement pstmt = con.prepareStatement("update student_info set fname=? where regno=?")) {
					pstmt.setString(1, name);
					pstmt.setInt(2, id);
					int c = pstmt.executeUpdate();
					System.out.println(c);
					con.commit();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteBean(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/studentapp?user=root&password=root")) {
				con.setAutoCommit(false);
				/*
				 * try(PreparedStatement pstmt = con.
				 * prepareStatement("delete from student_info si, guardian_info gi, student_addressinfo ai"
				 * + " where si.regno=gi.regno and ai.regno=si.regno and si.regno =?");)
				 */
				try (PreparedStatement pstmt1 = con.prepareStatement("delete from student_info where regno=?  ");
						PreparedStatement pstmt2 = con.prepareStatement("delete from guardian_info where regno=? ");
						PreparedStatement pstmt3 = con
								.prepareStatement("delete from student_addressinfo where regno=? ");) {

					pstmt1.setInt(1, id);
					pstmt2.setInt(1, id);
					pstmt3.setInt(1, id);
					int c = pstmt1.executeUpdate();
					int c2 = pstmt2.executeUpdate();
					int c3 = pstmt3.executeUpdate();
					System.out.println(c);
					System.out.println(c2);
					System.out.println(c3);
					con.commit();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	

}
