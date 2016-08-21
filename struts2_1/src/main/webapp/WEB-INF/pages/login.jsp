<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/l_login.action" method="post">
		<s:text name="jsp.login.username"></s:text>：<input type="text" name="username"/><br/>
		<input type="submit" value="<s:text name="jsp.login.submit"></s:text>"/>
	</form>
</body>
</html>