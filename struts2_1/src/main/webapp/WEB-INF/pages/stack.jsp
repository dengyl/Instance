<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
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
	<s:property value="name"/>,<s:property value="age"/><br/>
	<s:property value="[1].name"/>,<s:property value="[1].age"/><br/>
	<s:property value="s1.name"/>,<s:property value="s1.age"/><br/>
	<s:property value="s2.name"/>,<s:property value="s2.age"/><br/>
	<s:property/><br/>
	<s:property value="[0].name"/><br/>
	<s:property value="[1].name"/><br/>
	<s:property value="[2].name"/><br/>
	<s:property value="[3].name"/><br/>
	
	EL表达式<br/>
	${name}<br/>
	------------------------------<br/>
	<%
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		out.print(stack.findValue("name"));
	%>
	
	<br/>-------------------<br/>
	<%--
		OGNL表达式若带#号直接从ActionContext中取值；
		若不带#号先从ValueStack中取值，若没有再从ActionContext中取值。
	 --%>
	 <s:property value="name"/><br/>
	 <s:property value="username"/><br/>
	 <s:property value="#username"/><br/>

	<s:debug/>
</body>
</html>