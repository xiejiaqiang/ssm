<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>支付订单页</title>
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
		<form role="form" class="form-inline" id = "searchFrom">
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
						<option value="1">天猫</option>
						<option value="2">京东</option>
						<option value="3">淘宝</option>
						<option value="4">拼多多</option>
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
	<!-- 新增和修改对话框 -->
	<div class="modal fade" id="modal_orderInfo_edit" role="dialog" aria-labelledby="modal_order_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form id="form_orderInfo" method="post" action="">
						<input type="text" hidden name="id" id="id" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td>订单编号：</td>
								<td><input type="text" id="orderNo" name="orderNo"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>商品编号：</td>
								<td><input type="text" id="mdseNo" name="mdseNo"
										   class="form-control" aria-required="true" required//></td>
							</tr>
							<tr>
								<td>客户姓名：</td>
								<td><input type="text" id="custName" name="custName"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>手机号：</td>
								<td><input type="text" id="numberNo" name="numberNo"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>收货地址：</td>
								<td><input type="text" id="address" name="address"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>订单金额：</td>
								<td><input type="number" id="orderAmount" max="999999999" name="orderAmount"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>实付金额：</td>
								<td><input type="number" id="actPayAmount" max="999999999" name="actPayAmount"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>优惠分类：</td>
								<td colspan="4">
									<select class="form-control" name="discountType" id = "discountType">
										<option value="">---请选择---</option>
											<option value="1">店铺券</option>
										<option value="2">平台券</option>
										<option value="3">满减</option>
										<option value="4">客服优惠</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>订单状态：</td>
								<td colspan="4">
									<select class="form-control" name="orderStatus" id = "orderStatus" aria-required="true" required>
										<option value="">---请选择---</option>
										<option value="0">待支付</option>
										<option value="1">已付款</option>
										<option value="2">已发货</option>
										<option value="3">已收货</option>
										<option value="4">退款中</option>
										<option value="5">已退款</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>物流单号：</td>
								<td><input type="text" id="logisticsNo" name="logisticsNo"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td>开票说明：</td>
								<td colspan="4">
									<select class="form-control" name="invoiceFlg" id = "invoiceFlg" aria-required="true" required>
										<option value="">---请选择---</option>
										<option value="1">已开票</option>
										<option value="2">未开票</option>
										<option value="3">开票中</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>开票类型：</td>
								<td colspan="4">
									<select class="form-control" name="invoiceType" id = "invoiceType">
										<option value="">---请选择---</option>
										<option value="1">普票</option>
										<option value="2">专票</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>订单日期：</td>
								<td>
									<input placeholder="点击选择时间" aria-required="true" required id="editOrderDate" name="editOrderDate" class="laydate-icon form-control layer-date"/>
								</td>
							</tr>
							<tr>
								<td>订单数量：</td>
								<td><input type="number" id="orderQuantity" min="1" max="999999" name="orderQuantity"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>进货价格：</td>
								<td><input type="number" id="purchasePrice" min="0" max="999999" name="purchasePrice"
										   class="form-control"/></td>
							</tr>
                            <tr>
                                <td>进货来源：</td>
                                <td><input type="text" id="purchaseSource" name="purchaseSource" class="form-control"/></td>
                            </tr>
							<tr>
								<td>订单渠道：</td>
								<td colspan="4">
									<select class="form-control" name="orderChannel" id = "orderChannel">
										<option value="">---请选择---</option>
										<option value="1">天猫</option>
										<option value="2">京东</option>
										<option value="3">淘宝</option>
										<option value="4">拼多多</option>
									</select>
								</td>
							</tr>
							<tr>
								<td valign="middle">备注：</td>
								<td colspan="4"><textarea rows="7" cols="50"
														  name="remarks" id="remarks"></textarea></td>
							</tr>
						</table>

						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  id="submit_form_order_info_btn">保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>

				</div>

			</div>

		</div>

	</div>
	<script type="text/javascript">

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
		//外部js调用
		laydate({
			elem: '#editOrderDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus', //响应事件。如果没有传入event，则按照默认的click
			format: 'YYYY-MM-DD'// 日期格式
		});
	</script>

</body>
</html>