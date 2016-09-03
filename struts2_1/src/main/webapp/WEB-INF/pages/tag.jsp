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
	<table width="300" border="1">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<s:iterator value="studentList" var="student" status="st">
			<tr>
				<td><s:property value="#st.index"/></td>
				<td><s:property value="#student.name"/></td>
				<td><s:property value="#student.age"/></td>
			</tr>
		</s:iterator>
	</table>
	
	<table width="300" border="1">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<s:iterator value="studentList" status="st">
			<tr>
				<td><s:property value="#st.count"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="age"/></td>
			</tr>
		</s:iterator>
	</table>
	
	<table width="300" border="1">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<s:iterator value="studentList.{?#this.age > 13}" status="st">
			<tr>
				<td><s:property value="#st.count"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="age"/></td>
			</tr>
		</s:iterator>
	</table>
	
	<br/>--------set-------<br/>
	<s:set value="'张三'" var="uname"></s:set>
	
	<br/>--------action-------<br/>
	<s:action name="context" namespace="/" executeResult="true"></s:action>
	
	<br/>--------if elseif else-------<br/>
	<s:set value="'b'" var="grade"></s:set>
	<s:if test="#grade == 'D'">差</s:if>
	<s:elseif test="#grade == 'A'">好</s:elseif>
	<s:else>其它</s:else>
	
	<br/>--------url-------<br/>
	<s:url value="validateCode" var="url"></s:url>
	<a href="<s:property value='#url'/>">验证码</a><br/>
	<s:url value="stack" var="purl">
		<s:param name="age" value="'13'"></s:param>
	</s:url>
	<a href="<s:property value='#purl'/>">点我</a>
	
	<s:debug/>
</body>
</html>