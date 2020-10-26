<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>菜单按钮页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>

</head>
<body class="gray-bg">
	<div class="panel-body">
		<table id="table_attachment"></table>
	</div>
	<script type="text/javascript">

	
	$(function() {
		var log_table = new LogTableInit();
		log_table.Init();
	});		

	var LogTableInit = function () {
	    var oLogTableInit = new Object();
	    //初始化Table
	    oLogTableInit.Init = function () {
	        $('#table_attachment').bootstrapTable({
	            url: 'attachmentList.htm',         //请求后台的URL（*）
	            method: 'post',                      //请求方式（*）
	            contentType : "application/x-www-form-urlencoded",
	            striped: true,                      //是否显示行间隔色
	            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	            pagination: true,                   //是否显示分页（*）
	            sortable: true,                     //是否启用排序
	            sortName: "attachmentid",
	            sortOrder: "desc",                   //排序方式
	            queryParams: oLogTableInit.queryParams,//传递参数（*）
	            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
	            pageNumber:1,                       //初始化加载第一页，默认第一页
	            pageSize: 10,                       //每页的记录行数（*）
	            pageList: [10, 25, 50, 75, 100],    //可供选择的每页的行数（*）
	            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	            strictSearch: true,
	            showColumns: true,                  //是否显示所有的列
	            showRefresh: false,                  //是否显示刷新按钮
	            minimumCountColumns: 2,             //最少允许的列数
	            clickToSelect: true,                //是否启用点击选中行
	           // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	            uniqueId: "attachmentid",                     //每一行的唯一标识，一般为主键列
	            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
	            cardView: false,                    //是否显示详细视图
	            detailView: false,                   //是否显示父子表
	            columns: [{
	                checkbox: true
	            },
	            {
	                field: 'attachmentid',
	                title: '备份日志id',
	                hidden: true
	            },
	            {
	                field: 'attachmentname',
	                title: '文件名称',
	                sortable:true
	            }, {
	                field: 'attachmentpath',
	                title: '文件路径',
	                sortable:true
	            }, {
	                field: 'attachmenttime',
	                title: '备份时间',
	                formatter:function(value,row,index){
	                	return new Date(value).Format('yyyy-MM-dd HH:mm:ss');
	                }
	            }]
	        });
	    };
	
	    //得到查询的参数
	    oLogTableInit.queryParams = function (params) {
	    	var temp = {
	            limit: params.limit,
	            offset: params.offset
	        };
	        return temp;
	    };
	    return oLogTableInit;
	};

	</script>
</body>
</html>