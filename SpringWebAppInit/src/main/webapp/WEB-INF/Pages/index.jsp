
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
WelComeDemo
<body>
<sf:form action="insert"  method="get" modelAttribute="user">
Name:<input type="text" name="name"><sf:errors path="name"/><br>
Mobile:<input type="text" name="mobile"><sf:errors path="mobile"/><br>
Password:<input type="password" name="password"><sf:errors path="password"/><br>
<button (click)>Register</button>
</sf:form>
</body>
</html>