<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<!-- 导入bootstrap样式 -->
<link rel="stylesheet" type="text/css" href="/ssmProfile_1/css/bootstrap.min.css" />
<!-- 导入jquery.js文件 -->
<script type="text/javascript" src="/ssmProfile_1/js/jquery-1.11.3.min.js"></script>
<!--导入bootstap.js文件  -->
<script type="text/javascript" src="/ssmProfile_1/js/bootstrap.min.js"></script>

<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="/ssmProfile_1/jquery/jquery-1.4.2.js"></script>
		<link rel="stylesheet" href="/ssmProfile_1/jquery/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="/ssmProfile_1/jquery/jquery.datepick.js"></script>
		<script type="text/javascript" src="/ssmProfile_1/jquery/jquery.datepick-zh-CN.js"></script>

		<script type="text/javascript">
				$(function(){
					//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
					$('#createtime').datepick({dateFormat: 'yy-mm-dd'}); 
				});
					
		</script>

</head>
<body>


<div class="container col-sm-10">
<form role="form" action="/ssmProfile_1/cust/api/v_1/editprofInfoById" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <%-- <input type="hidden" name="id" value="${cust.id}"> --%>
    
    <label for="exampleInputEmail1">编号</label>
    <input type="text" class="form-control" name="id" id="exampleInputEmail1"  value="${cust.id }">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">姓名</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="name" placeholder="Enter name" value="${cust.name }">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">生日</label>
  <input type="text" class="form-control" id="createtime" name=birthday readonly="birthday" placeholder="Enter birthday" value='<fmt:formatDate value="${cust.birthday }" pattern="yyyy-MM-dd"/>'>
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">性别</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="gender"  placeholder="Enter gender" value="${cust.gender }">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">职业</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="career"  placeholder="Enter career" value="${cust.career }">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">住所</label>
      <input type="text" class="form-control" id="exampleInputEmail1" name="address"  placeholder="Enter address" value="${cust.address }">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">电话</label>
     <input type="text" class="form-control" id="exampleInputEmail1" name="mobile"  placeholder="Enter mobile" value="${cust.mobile }">
  </div>

				
  <div class="form-group">
	<label for="exampleInputFile">图像：</label>
  	<c:if test="${cust.picimage != null}">
  	         <img  src="/pic/${cust.picimage }" width=100 height=100>
  	</c:if>
    <input type="file" id="exampleInputFile" name="picFile">
  </div>
 
  <button type="submit" class="btn btn-default">提交</button>
</form>

</div>
	
</body>
</html>