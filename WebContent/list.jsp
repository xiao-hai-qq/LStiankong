<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="profile-Type" content="text/html; charset=utf-8">

<!-- 支持移动上网设备优先 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>

<!-- 导入bootstrap样式 -->
<link rel="stylesheet" type="text/css" href="/ssmProfile_1/css/bootstrap.min.css" />
<!-- 导入jquery.js文件 -->
<script type="text/javascript" src="/ssmProfile_1/js/jquery-1.11.3.min.js"></script>
<!--导入bootstap.js文件  -->
<script type="text/javascript" src="/ssmProfile_1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/ssmProfile_1/js/loadprofile.js"></script>


<style type="text/css">
	td{
		text-align:center; 
		vertical-align: middle;
	}
</style>


</head>
<body bgcolor="#dce3e7">

	<form method="post" action="">
	
	<table border="1px" width="80%">
	
	<tr>
		<td><input type="text" name="career" placeholder="请输入人员职业" ></td>
		<td><input type="text" name="address" placeholder="请输入人员住所"></td>
		<td><input type="button" onclick="loadprofileByPage(1)" value="搜索"></td>
	</tr> 
	<tr>
		<td>人员编号</td>
		<td>姓名</td>
		<td>生日</td>
		<td>性别</td>
		<td>职业</td>
		<td>住所</td>
		<td>图像</td>
		<td>手机号</td>
		<td>操作</td>
	</tr>
	
	<tbody id="myprofile"></tbody>
	
	</table>
	
	<div id="myPage"></div>
	
  </form>

</body>
</html>