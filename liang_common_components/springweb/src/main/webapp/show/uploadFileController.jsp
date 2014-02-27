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
		var message="${message}";
		if(message.length!=0){
			alert(message);
		}
		$("#gdfd").click(function(){
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
	<h1>这是文件上传controller</h1>
	<hr>
	<form action="uploadFileNew" name="fileUpLoadForm" enctype="multipart/form-data" method="post">
		文件路径：<input type="file" name="file">
		<input type="submit" value="上传" id="uploadFile">
	</form>
</body>
</html>