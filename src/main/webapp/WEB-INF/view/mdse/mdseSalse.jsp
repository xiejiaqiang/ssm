<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>商品销售渠道</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>
	<link href="${path }/resources/css/plugins/fileinput/fileinput.css" media="all" rel="stylesheet" type="text/css" />
	<script src="${path }/resources/js/plugins/fileinput/fileinput.js" type="text/javascript"></script>
	<script src="${path }/resources/js/plugins/fileinput/zh.js" type="text/javascript"></script>
	<script src="${path }/resources/js/view/mdse/mdseSalse.js"></script>
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
				<label  class="control-label">商品编号</label>
				<input type="test" name="txt_mdseNo"  placeholder="多个商品编号用&分割" id="txt_mdseNo" class="form-control">
			</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label  class="control-label">销售平台ID</label>
					<input type="test" name="txt_search_platformId"  id="txt_search_platformId" class="form-control">
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label  class="control-label">销售渠道</label>
					<select class="form-control" name="txt_search_salesChannel" id = "txt_search_salesChannel">
						<option value="">---全部---</option>
						<option value="1">天猫</option>
						<option value="2">京东</option>
						<option value="3">淘宝</option>
						<option value="4">拼多多</option>
					</select>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label  class="control-label">销售状态</label>
					<select class="form-control" name="txt_search_salesStatus" id = "txt_search_salesStatus">
						<option value="">---全部---</option>
						<option value="0">待上架</option>
						<option value="1">已上架</option>
						<option value="2">已售罄</option>
						<option value="3">已下架</option>
					</select>
				</div>
			</div>
				<button class="btn btn-primary" id="btn_search" type="button">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
				</button>
		</form>
		</div>
        <table id="table_mdseSalse"></table>

	</div>

	<!-- 新增和修改对话框 -->
	<div class="modal fade" id="modal_mdseSalse_edit" role="dialog" aria-labelledby="modal_mdseSalse_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form id="form_mdseSalse" method="post" action="">
						<input type="text" hidden name="id" id="id" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td>商品编号：</td>
								<td><input type="text" id="mdseNo" name="mdseNo"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>销售平台ID：</td>
								<td><input type="text" id="platformId" name="platformId"
										   class="form-control" /></td>
							</tr>
							<tr>
								<td>销售渠道：</td>
								<td colspan="4">
									<select class="form-control" name="salesChannel" id = "salesChannel"  aria-required="true" required>
										<option value="">---请选择---</option>
										<option value="1">天猫</option>
										<option value="2">京东</option>
										<option value="3">淘宝</option>
										<option value="4">拼多多</option>
									</select>
								</td>
							</tr>

							<tr>
								<td>日常售价：</td>
								<td><input type="number" id="dailyPrice" max="999999999" name="dailyPrice"
										   class="form-control"/></td>
							</tr>

							<tr>
								<td>活动价：</td>
								<td><input type="number" id="activityPrice" max="999999999" name="activityPrice"
										   class="form-control"/></td>
							</tr>

							<tr>
								<td>大销价：</td>
								<td><input type="number" id="promotionPrice" max="999999999" name="promotionPrice"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td>优惠方式：</td>
								<td colspan="4">
									<select class="form-control" name="preferentialType" id = "preferentialType">
										<option value="">---全部---</option>
										<option value="0">优惠券</option>
										<option value="1">满减</option>
										<option value="2">预售立减</option>
										<option value="3">限时秒杀</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>配额：</td>
								<td><input type="number" id="salesSku" max="999999999" name="salesSku"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td>销售状态：</td>
								<td colspan="4">
									<select class="form-control" name="salesStatus" id = "salesStatus" aria-required="true" required>
										<option value="">---全部---</option>
										<option value="0">待上架</option>
										<option value="1">已上架</option>
										<option value="2">已售罄</option>
										<option value="3">已下架</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>商品链接：</td>
								<td><input type="text" id="mdseUrl"   name="mdseUrl" class="form-control"/></td>
							</tr>
						</table>

						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  id="submit_form_mdse_salse_btn">保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>

				</div>

			</div>

		</div>

	</div>


</body>
</html>