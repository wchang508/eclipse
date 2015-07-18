<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5" import = "edu.hsingwu.dto.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Success</title>
</head>
<body>
	<h3>Login Successful!</h3>

<%
//User user= (User) request.getAttribute("userInfo");    //user pass from request
%>
	<jsp:useBean id="userInfo" class="edu.hsingwu.dto.User" scope="request">
		<jsp:setProperty property="userName" name="userInfo" value="NewUser" /> <!-- if userName is null, set as a NewUser -->
	
	</jsp:useBean> <!--Bean id is request attribute name in LoginServlet-->

Hello <%=userInfo.getUserName() %>	
<br>
Hello <jsp:getProperty property="userName" name="userInfo"/> from jstl
</body>
</html>