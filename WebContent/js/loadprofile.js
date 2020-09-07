//毫秒转日期
function turnTime(ms){
	var oDate = new Date(ms),
	oYear = oDate.getFullYear(),
	oMonth = oDate.getMonth()+1,
	oDay = oDate.getDate(),
	oHour = oDate.getHours(),
	oMin = oDate.getMinutes(),
	oSen = oDate.getSeconds(),
	oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间
	return oTime;
}
//给时间补上零
function getzf(num){
	if(parseInt(num) < 10){
		num = '0'+num;
	}
	return num;
}

$(function(){  //从第一页显示
	loadprofileByPage(1);
});

function editprofInfoById(id){
	if(confirm("你确定要修改吗")){
		location.href="/ssmProfile_1/cust/api/v_1/findProfInfoById/"+id;
	}
}


function loadprofileByPage(indexpage){
	//获取输入框的值
	var career = $("[name='career']").val();
	var address = $("[name='address']").val();
	

	var url = "/ssmProfile_1/cust/api/v_1/findProfileByPage";
	var params = {"indexpage":indexpage,"career":career,"address":address};
	//获取标签内容的目的地
	var $Content = $("#myprofile");
	$.post(
			url,
			params,
			function(apiBean){
				//alert("55");
				//把dom对象转换为Jquery	对象
				var $data = $(apiBean.dataList);
			
				var sumContext = "";
				$Content.empty();//控制分页
				$data.each(function(index,dom){
						$Content.append("<tr><td>"+(index+1)+"</td><td>"
								+dom.name+"</td><td>"
								+turnTime(dom.birthday)+"</td><td>"
								+dom.gender+"</td><td>"
								+dom.career+"</td><td>"
								+dom.address+"</td><td>"
								+dom.picImage+"</td><td>"
								+dom.mobile+"</td><td>"
								+"<a class='btn btn-info btn-sm active' onclick='editprofInfoById("+dom.id+")'>修改</a></td></tr>");
				});
				
				
          //使用js封装分页数据	
				var pagehtml ="";
				pagehtml += "<a onclick='loadprofileByPage(1)' >[首页]</a>&nbsp;";
				if(apiBean.indexpage > 1){
					
					pagehtml += "<a onclick='loadprofileByPage("+(apiBean.indexpage - 1)+")' > 上一页 </a>&nbsp;";
				}else{
					pagehtml +="上一页";
					
				}
				
				
				if(apiBean.totalPage < 4){
					for (var i = 1; i <= apiBean.totalPage; i++) {
						pagehtml +="<a style='text-decoration: none' class='myClass' onclick='loadprofileByPage("+i+")'>&nbsp;<input type='button' value='"+i+"'/>&nbsp;</a>";
					}
					
				}else if(apiBean.indexpage + 4 <= apiBean.totalPage){
					
					for ( var i = apiBean.indexpage; i < apiBean.indexpage + 4; i++) {
						pagehtml += "<a style='text-decoration: none' class='myClass' onclick='loadprofileByPage("+i+")' >&nbsp;<input type='button' value='"+i+"'/>&nbsp;</a>&nbsp;";
					}
				}else{
					for ( var i = apiBean.totalPage - 3; i <= apiBean.totalPage; i++) {
						pagehtml += "<a style='text-decoration: none' class='myClass'  onclick='loadprofileByPage("+i+")' >&nbsp;<input type='button' value='"+i+"'/>&nbsp;</a>&nbsp;";
					}
				}
				
				
				
				if(apiBean.indexpage < apiBean.totalPage){
					
					pagehtml += "<a onclick='loadprofileByPage("+(apiBean.indexpage + 1)+")' > 下一页 </a>&nbsp;";
				}else{
					pagehtml +=" 下一页&nbsp;&nbsp;&nbsp;";
				}
				
				
				pagehtml += "<a onclick='loadprofileByPage("+(apiBean.totalPage)+")' >[尾页]</a>&nbsp;";
				pagehtml += "当前第&nbsp;"+apiBean.indexpage+"&nbsp;页/共&nbsp;"+apiBean.totalPage+"&nbsp;页";
				pagehtml +="</ul>";
				$("#myPage").html(pagehtml);
			},
			
			"json"
	
	);
}