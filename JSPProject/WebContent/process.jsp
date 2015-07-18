<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="user" class="edu.hsingwu.dto.User" scope="request">
		<jsp:setProperty property="*" name="user" /> 
		<!-- property :Bean property; param: login.jsp input name; pass value from login.jsp to process.jsp
		property will auto map with param if their values are the same so param can be neglected-->
	</jsp:useBean>
	
	Hello <jsp:getProperty property="userName" name="user"/> from jstl
	Address1: <jsp:getProperty property="address1" name="user"/>
	Address2: <jsp:getProperty property="address2" name="user"/>
	City: <jsp:getProperty property="city" name="user"/>
	State: <jsp:getProperty property="state" name="user"/>
</body>
</html>