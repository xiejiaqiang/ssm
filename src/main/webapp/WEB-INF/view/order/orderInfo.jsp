<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>用户主页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>
	<link href="${path }/resources/css/plugins/fileinput/fileinput.css" media="all" rel="stylesheet" type="text/css" />
	<script src="${path }/resources/js/plugins/fileinput/fileinput.js" type="text/javascript"></script>
	<script src="${path }/resources/js/plugins/fileinput/zh.js" type="text/javascript"></script>
	<script src="${path }/resources/js/view/order/orderInfo.js"></script>
</head>
<body class="gray-bg">
	<div class="panel-body">
		<div id="toolbar" class="btn-group">
			<c:forEach items="${operationList}" var="oper">
				<privilege:operation operationId="${oper.operationid }" id="${oper.operationcode }" name="${oper.operationname }" clazz="${oper.iconcls }"  color="#093F4D"></privilege:operation>
			</c:forEach>
        </div>
		<div class="row">
		<form role="form" class="form-inline">
			<div class="col-sm-3">
			<div class="form-group">
				<label  class="control-label">订单编号</label>
				<input type="test" name="txt_orderNo"  placeholder="请输入订单编号" id="txt_orderNo" class="form-control">
			</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label  class="control-label">客户姓名</label>
					<input type="test" name="txt_custName"  placeholder="请输入客户姓名" id="txt_custName" class="form-control">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label  class="control-label">手机号</label>
					<input type="test" name="txt_numberNo"  placeholder="请输入手机号" id="txt_numberNo" class="form-control">
				</div>
			</div>
			<div class="col-sm-2">
			<div class="form-group">
				<label  class="control-label">订单状态</label>
				<select class="form-control" name="txt_search_orderStatus" id = "txt_search_orderStatus">
					<option value="">---全部---</option>
						<option value="0">待支付</option>
					<option value="1">已付款</option>
					<option value="2">已发货</option>
					<option value="3">已收货</option>
					<option value="4">退款中</option>
					<option value="5">已退款</option>
				</select>
			</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label  class="control-label">订单渠道</label>
					<select class="form-control" name="txt_search_orderChannel" id = "txt_search_orderChannel">
						<option value="">---全部---</option>
						<option value="0">天猫</option>
						<option value="1">京东</option>
						<option value="2">淘宝</option>
						<option value="3">拼多多</option>
					</select>
				</div>
			</div>
			<div class="form-horizontal m-t">
				<div class="form-group col-lg-7">
					<label class="col-sm-2 control-label">订单日期</label>
					<div class="col-sm-8">
						<input placeholder="开始时间" id="txt_search_start" name="start" class="laydate-icon form-control layer-date"/>
						<input placeholder="结束时间"id="txt_search_end" name="end" class="laydate-icon form-control layer-date"/>
					</div>
				</div>
			</div>
				<button class="btn btn-primary" id="btn_search" type="button">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
				</button>
			</button>
		</form>
		</div>
        <table id="table_orderInfo"></table>

	</div>

	<script type="text/javascript">

		Date.prototype.Format = function (fmt) {
			var o = {
				"M+": this.getMonth() + 1, //月份
				"d+": this.getDate(), //日
				"H+": this.getHours(), //小时
				"m+": this.getMinutes(), //分
				"s+": this.getSeconds(), //秒
				"S": this.getMilliseconds() //毫秒
			};
			if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
			for (var k in o)
				if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
			return fmt;
		};

		//外部js调用
		laydate({
			elem: '#txt_search_start', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus', //响应事件。如果没有传入event，则按照默认的click
			format: 'YYYY-MM-DD'// 日期格式
		});

		laydate({
			elem: '#txt_search_end',
			event: 'focus',
			format: 'YYYY-MM-DD'
		});
	</script>
	<!-- 上传 -->
	<form>
		<div class="modal fade" id="modal_btn_import" tabindex="-1" role="dialog" aria-hidden="true" aria-labelledby="modal_btn_import">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
						<h4 class="modal-title" id="myModalLabel">请选择Excel文件</h4>
					</div>
					<div class="modal-body">
						<a href="${path }/resources/xls/支付订单导入模板.xlsx" class="form-control" style="border:none;">下载导入模板</a>
						<input type="file" name="txt_file" id="txt_file" class="file-loading" /><!-- multiple表示允许同时上传多个文件 -->
					</div></div>
			</div>
		</div>
	</form>

</body>
</html>