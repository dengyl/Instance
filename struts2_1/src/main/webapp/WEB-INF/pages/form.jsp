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
	<s:form namespace="/" action="form" method="post">
		<s:token></s:token>
		<s:textfield name="name" label="姓名"></s:textfield>
		<s:textfield name="age" label="年龄"></s:textfield>
		<s:checkbox name="married" label="已婚" value="1"></s:checkbox>
		<s:checkboxlist name="hobby" list="#{'cf':'吃饭','sj':'睡觉','xdm':'写代码'}" label="爱好"></s:checkboxlist>
		<s:select name="city" list="#{'gz':'广州','bj':'北京'}" label="城市" headerKey="" headerValue="--请选择--"></s:select>
		<s:textarea name="remark" rows="3" cols="15" label="备注"></s:textarea>
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>