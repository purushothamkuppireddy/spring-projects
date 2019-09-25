
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<sf:form method="get" action="insert" modelAttribute="user">
Name:<input type="text" name="name"><sf:errors path="name"/><br>
Mobile:<input type="text" name="mobile"><sf:errors path="mobile"/><br>
Email:<input type="text" name="email"><sf:errors path="email"/><br>

<button (click)>SUBMIT</button>
</sf:form>
</body>
</html>
