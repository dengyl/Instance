<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="s_add.action" namespace="/student" method="post">
	<s:textfield label="姓名" name="name"></s:textfield>
	<s:textfield label="年龄" name="age"></s:textfield>
	<s:textfield label="生日" name="birthday"></s:textfield>
	<s:submit value="提交"></s:submit>
</s:form>
</body>
</html>