<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<!--  
<s:form action="login3.action">  
	<s:textfield label="Login ID" key="userId" />
	<s:password label="Password" key="password" />
	<s:submit />
</s:form>
-->
<s:form action="login4.action">  
	<s:textfield label="Login ID" key="user.userId" /> <!-- Without ModelDriven, we should use user.userId to pass parameter to the user object directly -->
	<s:password label="Password" key="password" /><!-- With ModelDriven, we can only use password to pass parameter to the member variable of user -->
	<s:submit />
</s:form>

</body>
</html>