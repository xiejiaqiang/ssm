<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>商品信息页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>
	<link rel="stylesheet" type="text/css" href="${path }/resources/css/plugins/multistage-pull-down.css" />
	<link rel="stylesheet" type="text/css" href="${path }/resources/css/plugins/ionRangeSlider/ion.rangeSlider.css" >
	<link type="text/css" href="${path }/resources/css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css" rel="stylesheet">
	<link type="text/css" href="${path }/resources/css/plugins/ionRangeSlider/normalize.min.css" rel="stylesheet">
	<script src="${path }/resources/js/view/mdse/mdseInfo.js"></script>
	<!-- IonRangeSlider -->
	<script src="${path }/resources/js/plugins/ionRangeSlider/ion.rangeSlider.js"></script>
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
				<label  class="control-label">商品名称</label>
				<input type="test" name="txt_mdseName"  placeholder="请输入商品名称" id="txt_mdseName" class="form-control">
			</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label  class="control-label">型号</label>
					<input type="test" name="txt_model"  placeholder="请输入型号" id="txt_model" class="form-control">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label  class="control-label">颜色</label>
					<input type="test" name="txt_colour"  placeholder="请输入颜色" id="txt_colour" class="form-control">
				</div>
			</div>
			<div class="col-sm-3">
			<div class="form-group">
				<label  class="control-label">商品状态</label>
				<select class="form-control" name="txt_mdseStatus" id = "txt_mdseStatus">
					<option value="">---全部---</option>
						<option value="0">待上市</option>
					<option value="1">已上市</option>
					<option value="2">已下市</option>
				</select>
			</div>
			</div>
			<div class="form-horizontal m-t">
				<div class="form-group col-lg-7">
					<label class="col-lg-1 control-label">零售指导价</label>
					<div class="col-lg-6">
						<div id="costRange">
						<input type="test" name="start" id="start" class="form-control hide">
						<input type="test" name="end" id="end" class="form-control hide">
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript">


			</script>

			<div class="col-sm-3">
				<div class="form-group">
					<div class="dropdown">
						<label  class="control-label">商品分类</label>
						<input type="test" name="view_mdseCat" id="view_mdseCat" value='${mdseCatList}' class="form-control hide">
						<input type="test" name="txt_mdseCat" id="txt_mdseCat" class="form-control hide">
						<a id="dLabel" role="button" data-toggle="dropdown" class="btn btn-success" data-target="#"
						   href="javascript:;">
							点击选择商品分类 <span class="caret"></span>
						</a>
						<ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
							<li><a tabindex="-1" href='javascript:setMdseCat("-1|全部");'>全部</a></li>
							<c:forEach items="${mdseCatTree}" var="mdseCat">
								<c:choose>
									<c:when test="${fn:length(mdseCat.children) gt 0 }">
										<li class="dropdown-submenu">
											<a tabindex="-1" href='javascript:setMdseCat("${mdseCat.id}"+"|"+"${mdseCat.text}");'>${mdseCat.text}</a>
								<ul class="dropdown-menu">
									<li><a tabindex="-1" href='javascript:setMdseCat("${mdseCat.id}"+"|"+"${mdseCat.text}");'>全部</a></li>
								<c:forEach items="${mdseCat.children}" var="mdseCat1">
									<c:choose>
									<c:when test="${fn:length(mdseCat1.children) gt 0 }">
								<li class="dropdown-submenu">
									<a tabindex="-1" href='javascript:setMdseCat("${mdseCat1.id}"+"|"+"${mdseCat1.text}");'>${mdseCat1.text}</a>
									<ul class="dropdown-menu">
										<li><a tabindex="-1" href='javascript:setMdseCat("${mdseCat1.id}"+"|"+"${mdseCat1.text}");'>全部</a></li>
									<c:forEach items="${mdseCat1.children }" var="mdseCat2">
									  <c:choose>
									    <c:when test="${fn:length(mdseCat2.children) gt 0 }">
								<li class="dropdown-submenu">
								<a tabindex="-1" href='javascript:setMdseCat("${mdseCat2.id}"+"|"+"${mdseCat2.text}");'>${mdseCat2.text}</a>
									<ul class="dropdown-menu">
										<li><a tabindex="-1" href='javascript:setMdseCat("${mdseCat2.id}"+"|"+"${mdseCat2.text}");'>全部</a></li>
								<c:forEach items="${mdseCat2.children }" var="mdseCat3">
								<c:choose>
								<c:when test="${fn:length(mdseCat3.children) gt 0 }">
								<li class="dropdown-submenu"> </li>
								<a tabindex="-1" href='javascript:setMdseCat("${mdseCat3.id}"+"|"+"${mdseCat3.text}");'>${mdseCat3.text}</a>
									<ul class="dropdown-menu">
										<li><a tabindex="-1" href='javascript:setMdseCat("${mdseCat3.id}"+"|"+"${mdseCat3.text}");'>全部</a></li>
								<c:forEach items="${mdseCat3.children }" var="mdseCat4">
								<ul class="dropdown-menu">
									<li><a tabindex="-1" href='javascript:setMdseCat("${mdseCat4.id}"+"|"+"${mdseCat4.text}");'>${mdseCat4.text}</a></li>
									</c:forEach>
									</c:when>
									<c:otherwise>
									<li><a tabindex="-1" href='javascript:setMdseCat("${mdseCat3.id}"+"|"+"${mdseCat3.text}");'>${mdseCat3.text}</a></li>
									</c:otherwise>
									</c:choose>
								</c:forEach>
								</ul>
									</li>
									</c:when>
									    <c:otherwise>
										<li><a tabindex="-1" href='javascript:setMdseCat("${mdseCat2.id}"+"|"+"${mdseCat2.text}");'>${mdseCat2.text}</a></li>
										</c:otherwise>
									  </c:choose>
									</c:forEach>
									</ul>
										</li>
										</c:when>
										<c:otherwise>
											<li><a href='javascript:setMdseCat("${mdseCat1.id}"+"|"+"${mdseCat1.text}");'>${mdseCat1.text}</a></li>
										</c:otherwise>
										</c:choose>
								</c:forEach>
								</ul>
										</li>
									</c:when>
									<c:otherwise>
										<li><a href='javascript:setMdseCat("${mdseCat.id}"+"|"+"${mdseCat.text}");'>${mdseCat.text}</a></li>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</ul>
					</div>
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
        <table id="table_mdseInfo"></table>

	</div>

	<!-- 新增和修改对话框 -->
	<div class="modal fade"  id="modal_mdseInfo_edit" role="dialog" aria-labelledby="modal_mdseInfo_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form id="form_mdseInfo" method="post" action="">
						<input type="text" hidden name="id" id="id" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr class="hide">
								<td>商品编号：</td>
								<td><input type="text" id="mdseNo" name="mdseNo"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>商品名称：</td>
								<td><input type="text" id="mdseName" name="mdseName"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>标题：</td>
								<td><input type="text" id="title" name="title"  class="form-control" /></td>
							</tr>
							<tr>
								<td>颜色：</td>
								<td><input type="text" id="colour" name="colour"
										   class="form-control" /></td>
							</tr>
							<tr>
								<td>型号：</td>
								<td><input type="text" id="model" name="model"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>商品分类：</td>
								<td><input type="text" hidden id="mdseCat"  name="mdseCat"
										   class="form-control" aria-required="true" required/>
									<div class="dropdown ">
										<a id="dLabel_edit" role="button" data-toggle="dropdown" class="btn btn-success" data-target="#"
										   href="javascript:;">
											点击选择商品分类 <span class="caret"></span>
										</a>
										<ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
											<c:forEach items="${mdseCatTree}" var="mdseCat">
											<c:choose>
											<c:when test="${fn:length(mdseCat.children) gt 0 }">
											<li class="dropdown-submenu">
												<a tabindex="-1" href="javascript:void(parent.layer.msg('请选择具体商品分类！'))">${mdseCat.text}</a>
												<ul class="dropdown-menu">
													<c:forEach items="${mdseCat.children}" var="mdseCat1">
													<c:choose>
													<c:when test="${fn:length(mdseCat1.children) gt 0 }">
													<li class="dropdown-submenu">
														<a tabindex="-1" href="javascript:void(parent.layer.msg('请选择具体商品分类！'))">${mdseCat1.text}</a>
														<ul class="dropdown-menu">
															<c:forEach items="${mdseCat1.children }" var="mdseCat2">
															<c:choose>
															<c:when test="${fn:length(mdseCat2.children) gt 0 }">
															<li class="dropdown-submenu">
																<a tabindex="-1" href="javascript:void(parent.layer.msg('请选择具体商品分类！'))">${mdseCat2.text}</a>
																<ul class="dropdown-menu">
																	<c:forEach items="${mdseCat2.children }" var="mdseCat3">
																	<c:choose>
																	<c:when test="${fn:length(mdseCat3.children) gt 0 }">
																	<li class="dropdown-submenu"> </li>
																	<a tabindex="-1" href="javascript:void(parent.layer.msg('请选择具体商品分类！'))">${mdseCat3.text}</a>
																	<ul class="dropdown-menu">
																		<c:forEach items="${mdseCat3.children }" var="mdseCat4">
																		<ul class="dropdown-menu">
																			<li><a tabindex="-1" href='javascript:setMdseeditCat("${mdseCat4.id}"+"|"+"${mdseCat4.text}");'>${mdseCat4.text}</a></li>
																			</c:forEach>
																			</c:when>
																			<c:otherwise>
																				<li><a tabindex="-1" href='javascript:setMdseeditCat("${mdseCat3.id}"+"|"+"${mdseCat3.text}");'>${mdseCat3.text}</a></li>
																			</c:otherwise>
																			</c:choose>
																			</c:forEach>
																		</ul>
																		</li>
																		</c:when>
																		<c:otherwise>
																			<li><a tabindex="-1" href='javascript:setMdseeditCat("${mdseCat2.id}"+"|"+"${mdseCat2.text}");'>${mdseCat2.text}</a></li>
																		</c:otherwise>
																		</c:choose>
																		</c:forEach>
																	</ul>
																	</li>
																	</c:when>
																	<c:otherwise>
																		<li><a href='javascript:setMdseeditCat("${mdseCat1.id}"+"|"+"${mdseCat1.text}");'>${mdseCat1.text}</a></li>
																	</c:otherwise>
																	</c:choose>
																	</c:forEach>
																</ul>
															</li>
															</c:when>
															<c:otherwise>
																<li><a href='javascript:setMdseeditCat("${mdseCat.id}"+"|"+"${mdseCat.text}");'>${mdseCat.text}</a></li>
															</c:otherwise>
															</c:choose>

															</c:forEach>
														</ul>
									</div>
							</tr>
							<tr>
								<td>商品库存：</td>
								<td><input type="number" id="mdseSku" max="999999999" name="mdseSku"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td>商品状态：</td>
								<td colspan="4">
									<select class="form-control" name="mdseStatus" id = "mdseStatus" ria-required="true" required>
										<option value="">---请选择---</option>
										<option value="0">待上市</option>
										<option value="1">已上市</option>
										<option value="2">已下市</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>品牌：</td>
								<td><input type="text" id="brand" name="brand"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td>系列：</td>
								<td><input type="text" id="series" name="series"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td valign="middle">卖点：</td>
								<td colspan="4"><textarea rows="7" cols="50"
														  name="sellingPoint" id="sellingPoint"></textarea></td>
							</tr>
							<tr>
								<td>参数1：</td>
								<td><input type="text" id="parameter1" name="parameter1"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td>参数2：</td>
								<td><input type="text" id="parameter2" name="parameter2"
										   class="form-control"/></td>
							</tr>
							<tr  class="hide">
								<td>创建时间：</td>
								<td><input type="text" id="txt_Date_Time" name="txt_Date_Time"
										   class="form-control"/></td>
							</tr>
							<tr  class="hide">
								<td>商品价格：</td>
								<td><input type="text" id="priceId" name="priceId"  class="form-control"/></td>
								<td><input type="text" id="buyingPrice" name="buyingPrice"  class="form-control"/></td>
								<td><input type="text" id="retailPrice" name="retailPrice"  class="form-control"/></td>
								<td><input type="text" id="floorPrice" name="floorPrice"  class="form-control"/></td>
								<td><input type="text" id="tradePrice" name="tradePrice"  class="form-control"/></td>
								<td><input type="text" id="profit" name="profit"  class="form-control"/></td>
								<td><input type="text" id="profitMargin" name="profitMargin"  class="form-control"/></td>
							</tr>
						</table>

						<div class="modal-footer">
                            <button type="button" class="btn btn-primary"  id="form_mdse_price_btn">价格录入</button>
							<button type="button" class="btn btn-primary"  id="submit_form_mdse_info_btn">保存</button>
							<button type="button" class="btn btn-default" id="mdse_price_btn_modal" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>

			</div>

		</div>

	</div>
	<!-- 价格 -->
	<div class="modal fade"  id="modal_price_edit" role="dialog" aria-labelledby="modal_price_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form id="form_mdsePrice" method="post" action="">
						<input type="text" hidden name="id" id="id" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr class="hide">
								<td>商品编号：</td>
								<td><input type="text" hidden id="mdseNo" name="mdseNo"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>进货价：</td>
								<td><input type="number" min="0.99" max="99999999" id="buyingPrice" name="buyingPrice"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>零售指导价：</td>
								<td><input type="number" min="0.99" max="99999999" id="retailPrice" name="retailPrice"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>底价：</td>
								<td><input type="number" min="0.99" max="99999999" id="floorPrice" name="floorPrice"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>活动价：</td>
								<td><input type="number" min="0.99" max="99999999" id="tradePrice" name="tradePrice"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td>利润：</td>
								<td><input type="number" min="0.99" max="99999999" id="profit" name="profit"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td>利润率%：</td>
								<td><input type="number" min="0.99" max="99999999" id="profitMargin" name="profitMargin"
										   class="form-control"/></td>
							</tr>
						</table>

						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  id="submit_form_mdse_price_btn">确定</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>

			</div>

		</div>

	</div>

	<!-- 图片 -->

		<div class="modal fade" id="modal_btn_mdse_Img" tabindex="-1" role="dialog" aria-hidden="true" aria-labelledby="modal_btn_mdse_Img">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>商品图片</h5>
								<div class="ibox-tools">
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
								</div>
							</div>
							<div class="ibox-content ">
								<div class="carousel slide" id="carousel2">
									<ol class="carousel-indicators">
										<li data-slide-to="0" data-target="#carousel2" class="active"></li>
										<li data-slide-to="1" data-target="#carousel2"></li>
										<li data-slide-to="2" data-target="#carousel2" class=""></li>
									</ol>
									<div class="carousel-inner">
										<div class="item ">
											<img alt="image" class="img-responsive" src="${path }/resources/img/p_big1.jpg">
											<div class="carousel-caption">
												<p>This is simple caption 1</p>
											</div>
										</div>
										<div class="item active">
											<img alt="image" class="img-responsive" src="${path }/resources/img/p_big3.jpg">
											<div class="carousel-caption">
												<p>This is simple caption 2</p>
											</div>
										</div>
										<div class="item">
											<img alt="image" class="img-responsive" src="${path }/resources/img/p_big2.jpg">
											<div class="carousel-caption">
												<p>This is simple caption 3</p>
											</div>
										</div>
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
	<!-- 价格管理 -->
	<div class="modal fade" id="modal_mdse_price_edit" role="dialog" aria-labelledby="modal_mdse_price_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form id="form_price" method="post" action="">
						<input type="text" hidden name="id" id="id" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td>商品编号：</td>
								<td><input type="text" id="mdseNo" name="mdseNo"
										   class="form-control" aria-required="true" Readonly /></td>
							</tr>
							<tr>
								<td>进货价：</td>
								<td><input type="number" id="buyingPrice" name="buyingPrice"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>零售指导价：</td>
								<td><input type="number" id="retailPrice" name="retailPrice"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>底价：</td>
								<td><input type="number" id="floorPrice" name="floorPrice"
										   class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>活动价：</td>
								<td><input type="number" id="tradePrice" name="tradePrice"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td>利润：</td>
								<td><input type="number" id="profit" max="999999999" name="profit"
										   class="form-control"/></td>
							</tr>
							<tr>
								<td>利润率%：</td>
								<td><input type="number" id="profitMargin"  max="999999999" name="profitMargin"
										   class="form-control"/></td>
							</tr>

						</table>

						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  id="submit_form_price_btn">保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>

				</div>

			</div>

		</div>

	</div>

	<div class="modal fade" id="modal_mdse_price_view" role="dialog" aria-labelledby="modal_mdse_price_view" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<div class="ibox-content">
						<div>
							<div>
								<span>进货价</span>
								<small class="pull-right" id="buyingPrice">20 GB</small>
							</div>
							<div class="progress progress-small">
								<div style="width: 50%;" id="buyingPrice-bar" class="progress-bar progress-bar-danger"></div>
					</div>
							<div>
								<span>零售指导价</span>
								<small class="pull-right" id="retailPrice">20 GB</small>
							</div>
							<div class="progress progress-small">
								<div style="width: 50%;" id="retailPrice-bar"  class="progress-bar"></div>
							</div>
							<div>
								<span>底价</span>
								<small class="pull-right" id ="floorPrice">10/200 GB</small>
							</div>
							<div class="progress progress-small">
								<div style="width: 60%;" id="floorPrice-bar" class="progress-bar progress-bar-warning"></div>
							</div>

							<div>
								<span>活动价</span>
								<small class="pull-right" id="tradePrice">20 GB</small>
							</div>
							<div class="progress progress-small">
								<div style="width: 50%;" id ="tradePrice-bar" class="progress-bar progress-bar-striped"></div>
							</div>

							<div>
								<span>利润</span>
								<small class="pull-right" id="profit">73%</small>
							</div>
							<div class="progress progress-small">
								<div style="width: 40%;"  id ="profit-bar"  class="progress-bar progress-bar-success" id="profit"></div>
							</div>

							<div>
								<span>利润率</span>
								<small class="pull-right progress-bar-info" id="profitMargin"></small>
							</div>
							<div class="progress progress-small">
								<div style="width: 20%;"  id ="profitMargin-bar"  class="progress-bar progress-bar-info"></div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>

			</div>

		</div>

	</div>
</body>
</html>