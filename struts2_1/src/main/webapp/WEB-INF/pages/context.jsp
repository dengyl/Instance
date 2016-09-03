<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 使用OGNL表达式取值 --%>
	<s:property value="#contextMap"/><br/>
	<s:property value="#request.requestMap"/><br/>
	<s:property value="#request.request"/><br/>
	
	EL表达式<br/>
	<%--
		Struts2对EL表达式的改变，取值顺序：
		pageContext scope --> request scope --> ValueStack --> ActionConetxt
		--> session scope --> application scope
	 --%>
	 ${contextMap}<br/>
	 ${requestMap}<br/>
	 ${request}<br/>
	
	<s:debug/>
</body>
</html>