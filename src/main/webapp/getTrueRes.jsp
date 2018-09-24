<%@page import="com.teamsankya.studentapp2.dto.MasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	MasterBean mbean = (MasterBean)request.getAttribute("mbean");
%>
<h3>student data inserted</h3>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
			<tr bgcolor=\"green\">
				<td>Regno</td>
				<td>First Name</td>
				<td>Middle Name</td>
				<td>Last Name</td>
				<td>Guardian First name</td>
				<td>Guardian Middle name</td>
				<td>Guardian Last name</td>
				<td>Address Type</td>
				<td>Address1</td>
				<td>Address2</td>
				<td>city</td>
				<td>pincode</td>
				
			</tr>
			<tr>
				<td><%=mbean.getInfo().getRegno() %></td>
				<td><%=mbean.getInfo().getFname()%></td>
				<td><%=mbean.getInfo().getMname() %></td>
				<td><%=mbean.getInfo().getLname() %></td>
				<td><%=mbean.getGard().getGfname() %></td>
				<td><%=mbean.getGard().getGmname() %></td>
				<td><%=mbean.getGard().getGlname() %></td>
				<td><%=mbean.getAddr().getAddr_type() %></td>
				<td><%=mbean.getAddr().getAddr1() %></td>
				<td><%=mbean.getAddr().getAddr2() %></td>
				<td><%=mbean.getAddr().getCity() %></td>
				<td><%=mbean.getAddr().getPincode() %></td>
				
			</tr>
		</table>

</body>
</html>