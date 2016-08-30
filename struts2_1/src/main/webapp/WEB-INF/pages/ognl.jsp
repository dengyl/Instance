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
	<%-- ognl表达式 --%>
	<s:property value="OGNL-Expression"/><br/>
	<s:property value="'OGNL-Expression'"/><br/>
	<s:property value="'OGNL-Expression'.length()"/><br/>
	<%-- ognl表达式访问静态类中的静态属性和静态方法 --%>
	<s:property value="@java.lang.Integer@MAX_VALUE"/><br/>
	<s:property value="@java.lang.Math@random()"/><br/>
	<%-- ognl表达式操作list和map --%>
	<s:radio name="sex" list="{'男','女'}"></s:radio><br/>
	<s:radio name="gender" list="#{'1':'男','0':'女'}"></s:radio><br/>
</body>
</html>