<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>用户主页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>

<link
	href="${path }/resources/css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
<link href="${path }/resources/css/animate.css" rel="stylesheet">
<link href="${path }/resources/css/style.css?v=4.1.0" rel="stylesheet">
<script src="${path }/resources/js/view/order/payOrder.js"></script>
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
        <table id="table_payOrder"></table>

	</div>
	
	<!-- 新增和修改对话框 -->
	<div class="modal fade" id="modal_user_edit" role="dialog" aria-labelledby="modal_user_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form id="form_user" method="post" action="reserveUser.htm">
						<input type="hidden" name="userid" id="hidden_txt_userid" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td>用户名：</td>
								<td><input type="text" id="username" name="username"
									class="form-control" aria-required="true" required/></td>
								<td>&nbsp;&nbsp;</td>
								<td>密码：</td>
								<td><input type="password" id="password" name="password"
									class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>角色：</td>
								<td colspan="4">
									<select class="form-control" name="roleid" id = "roleid" aria-required="true" required>
										<option value="">---请选择---</option>
										<c:forEach items="${roleList }" var="r">
										 	<option value="${r.roleid }">${r.rolename }</option>
										</c:forEach>
				                	</select>
								</td>
							</tr>
							<tr>
								<td valign="middle">备注：</td>
								<td colspan="4"><textarea rows="7" cols="50"
										name="userdescription" id="userdescription"></textarea></td>
							</tr>
						</table>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  id="submit_form_user_btn">保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>

				</div>
				
			</div>

		</div>

	</div>
	

	<!-- Peity-->
	<script src="${path }/resources/js/plugins/peity/jquery.peity.min.js"></script>
	
	<!-- Bootstrap table-->
	<script src="${path }/resources/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script src="${path }/resources/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

	<!-- 自定义js-->
	<script src="${path }/resources/js/content.js?v=1.0.0"></script>
	
	 <!-- jQuery Validation plugin javascript-->
    <script src="${path }/resources/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${path }/resources/js/plugins/validate/messages_zh.min.js"></script>
   
   	<!-- jQuery form  -->
    <script src="${path }/resources/js/jquery.form.min.js"></script>


</body>
</html>