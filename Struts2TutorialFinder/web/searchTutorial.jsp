<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Search Tutorial</title>
</head>
<body>
<!-- 
	<form method="post" action="tutorials/getTutorial.action">
		<input id="language" name="language" />
		<input type="submit" />
	</form>
-->
<s:form action="tutorials/getTutorial.action">  
	<s:textfield label="Enter the Language" key="language" />
	<s:submit />
</s:form>

</body>
</html>