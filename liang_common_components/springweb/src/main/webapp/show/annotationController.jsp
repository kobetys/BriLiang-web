<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#addUser").click(function(){
			/*
			var username=encodeURI($("input[name=username]").val());
			var password=encodeURI($("input[name=password]").val());
			*/
			var username=$("input[name=username]").val();
			var password=$("input[name=password]").val();
			$.ajax({
				url:"json",
				/*乱码get请求*/
				type:"POST",
				data:{username:username,password:password},
				success:function(result){
					alert(result.userName+"~~"+result.password);
				},
				error:function(message){
					
				}
			});
			//$("#addUserForm").submit();
		});
		$("#responseBody").click(function(){
			$.ajax({
				url:"<%=basePath %>jsonBody/json",
				/*乱码get请求*/
				type:"POST",
				success:function(data){
					 $.each(data,function(idx,item){     
						   //输出
						   alert(idx);
						   alert(item);
					});
				},
				error:function(message){
					
				}
			});
			
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>这是一个注解controller</h1>
	<br />
	<div>${result}</div>
	<hr>
	<label>传递后台数据：</label>
	<form action="post?method=postMethod" method="post" id="addUserForm">
		<label>用户名：</label><input type="text" name="username"><br/>
		<label>密码：</label><input type="password" name="password"><br/>
		<input type="button" value="添加用户" id="addUser">
	</form>
	<hr>
	ResponseBody提交方式:
	<input type="button" value="添加用户" id="responseBody">
</body>
</html>