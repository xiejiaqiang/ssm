<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>礼品信息页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>
	<link rel="stylesheet" type="text/css" href="${path }/resources/css/plugins/multistage-pull-down.css" />
	<link rel="stylesheet" type="text/css" href="${path }/resources/css/plugins/ionRangeSlider/ion.rangeSlider.css" >
	<link type="text/css" href="${path }/resources/css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css" rel="stylesheet">
	<link type="text/css" href="${path }/resources/css/plugins/ionRangeSlider/normalize.min.css" rel="stylesheet">
	<link href="${path }/resources/css/plugins/fileinput/fileinput.css" media="all" rel="stylesheet" type="text/css" />
	<script src="${path }/resources/js/view/sales/giftInfo.js"></script>
	<!-- IonRangeSlider -->
	<script src="${path }/resources/js/plugins/ionRangeSlider/ion.rangeSlider.js"></script>
	<script src="${path }/resources/js/plugins/fileinput/fileinput.js" type="text/javascript"></script>
	<script src="${path }/resources/js/plugins/fileinput/zh.js" type="text/javascript"></script>
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
				<label  class="control-label">礼品名称</label>
				<input type="test" name="txt_giftName"  placeholder="请输入礼品名称" id="txt_giftName" class="form-control">
			</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label  class="control-label">礼品编号</label>
					<input type="test" name="txt_giftNo"  placeholder="请输入礼品编号" id="txt_giftNo" class="form-control">
				</div>
			</div>
			<div class="row">
			<button class="btn btn-primary" id="btn_search" type="button">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
				</button>
			</button>
			</div>
		</form>
		</div>
        <table id="table_giftInfo"></table>

	</div>

	<!-- 新增和修改对话框 -->
	<div class="modal fade"  id="modal_giftInfo_edit" role="dialog" aria-labelledby="modal_giftInfo_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form id="form_giftInfo" method="post" action="">
						<input type="text" hidden name="id" id="id" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td>礼品编号：</td>
								<td><input type="text" id="giftNo" name="giftNo"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>礼品名称：</td>
								<td><input type="text" id="giftName" name="giftName"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td valign="middle">礼品链接：</td>
								<td colspan="4"><textarea rows="7" cols="50"
														  name="giftLink" id="giftLink"></textarea></td>
							</tr>
							<tr>
								<td>礼品金额：</td>
								<td><input type="number" id="giftAmount" name="giftAmount"  max="999999999" name="orderAmount"  class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>进货渠道：</td>
								<td><input type="text" id="channel" name="channel"  class="form-control" /></td>
							</tr>

							<tr class="hide">
								<td>礼品图片：</td>
								<td><input type="text" id="giftImg" name="giftImg"
										   class="form-control"/></td>
							</tr>

						</table>

						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  id="submit_form_gift_info_btn">保存</button>
							<button type="button" class="btn btn-default" id="gift_info_btn_modal" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>

			</div>

		</div>

	</div>
	<div class="modal fade" id="modal_spinner_wave">
					<div class="spiner-example">
						<div class="sk-spinner sk-spinner-wave">
							<div class="sk-rect1"></div>
							<div class="sk-rect2"></div>
							<div class="sk-rect3"></div>
							<div class="sk-rect4"></div>
							<div class="sk-rect5"></div>
						</div>
					</div>
		<div class="modal-footer hide">
			<button type="button" class="btn btn-default" id = 'spinner_wave_close' data-dismiss="modal">关闭</button>
		</div>
	</div>
	<!-- 上传 -->
	<form>
		<div class="modal fade" id="modal_btn_Upload" tabindex="-1" role="dialog" aria-hidden="true" aria-labelledby="modal_btn_Upload">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
						<h4 class="modal-title" id="myModalLabel">请选择图片</h4>
					</div>
					<div class="modal-body">
						<input type="text" hidden name="upload_id" id="upload_id" value="" class="file-loading" />
						<input type="file" name="txt_file" id="txt_file" class="file-loading" multiple /><!-- multiple表示允许同时上传多个文件 -->
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- 图片 -->
	<div class="modal fade"  id="modal_btn_gift_Img" tabindex="-1" role="dialog" aria-hidden="true" aria-labelledby="modal_btn_gift_Img">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>商品图片</h5>
						<%--<div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="carousel.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="#">轮播图</a>
                                </li>
                                <li><a href="#">详情页</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>--%>
					</div>
					<div class="ibox-content ">
						<div class="carousel slide" id="carousel2">
							<%--<ol class="carousel-indicators">
                                <li data-slide-to="0" data-target="#carousel2" class="active"></li>
                                <li data-slide-to="1" data-target="#carousel2"></li>
                                <li data-slide-to="2" data-target="#carousel2" class=""></li>
                            </ol>--%>
							<div class="carousel-inner"id='imgInfo'>
							</div>
							<a data-slide="prev" href="carousel.html#carousel2" class="left carousel-control">
								<span class="icon-prev"></span>
							</a>
							<a data-slide="next" href="carousel.html#carousel2" class="right carousel-control">
								<span class="icon-next"></span>
							</a>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

     </body>
</html>