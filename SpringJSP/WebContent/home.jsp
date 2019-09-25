<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="2">
	<tr>
	<th>Name</th>
	<th>Mobile</th>
	<th>Email</th>
	<th>Deletion</th>
	<th>Updation</th>
	</tr>
	<tr>
	
<%

try{
Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","capg","oracle123");
	PreparedStatement ps=con.prepareStatement("select * from userDetails");
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{
	%>
		<td><%=rs.getString(1)%></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs.getString(3)%></td>
		<td><a href="delete.jsp?email=<%=rs.getString(3)%>">DELETE</a></td>
		<td><a href="update1.jsp?email=<%=rs.getString(3)%>">EDIT</a> </td>
		
	</tr>
		
		
	<%}%>
	</table>
<%}catch(Exception e)
{
	e.printStackTrace();
}

%>
</body>
</html>