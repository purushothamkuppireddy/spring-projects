<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String n=null;
String m=null;
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","capg","oracle123");

	PreparedStatement ps=con.prepareStatement("select * from userDetails where email=?");
	
	ps.setString(1,request.getParameter("email"));
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		
		n=rs.getString(1);
		 m=rs.getString(2);
		
	}
	
}
catch(Exception e)
{
	e.printStackTrace();
}

%>
<form method="get" action="update.jsp">
<input type="text" name="name" value="<%=n%>"/><br>
<input type="text" name="mobile" value="<%=m%>"/>
<input type="hidden" name="email" value="<%=request.getParameter("email")%>"/>
<button (click)>SUBMIT</button>
</form>
</body>
</html>