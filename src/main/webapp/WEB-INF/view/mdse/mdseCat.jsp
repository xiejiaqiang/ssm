<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>商品分类管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>
<!-- jqgrid-->
<link href="${path }/resources/css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">
<script src="${path }/resources/js/view/mdse/mdseCat.js"></script>

</head>
<body class="gray-bg">
	<c:forEach items="${operationInfo }" var="oper">
		<input type="hidden" id="${oper.key }" value="${oper.value }"/>
	</c:forEach>
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox ">
					<div class="ibox-content">
						<div class="jqGrid_wrapper">
							<table id="table_mdse_cat"></table>
							<div id="pager_mdse_cat"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="ui-jqdialog modal-content" id="alertmod_table_mdse_cat_mod"
		dir="ltr" tabindex="-1" role="dialog"
		aria-labelledby="alerthd_table_mdse_cat" aria-hidden="true"
		style="width: 200px; height: auto; z-index: 950; overflow: hidden; top: 274px; left: 534px; display: none;">
		<div class="ui-jqdialog-titlebar modal-header" id="alerthd_table_mdse_cat"
			style="cursor: move;">
			<span class="ui-jqdialog-title" style="float: left;">注意</span> <a id ="alertmod_table_mdse_cat_mod_a"
				class="ui-jqdialog-titlebar-close" style="right: 0.3em;"> <span
				class="glyphicon glyphicon-remove-circle"></span></a>
		</div>
		<div class="ui-jqdialog-content modal-body" id="alertcnt_table_mdse_cat">
			<div>请选择记录</div>
			<span tabindex="0"> <span tabindex="-1" id="jqg_alrt"></span></span>
		</div>
		<div
			class="jqResize ui-resizable-handle ui-resizable-se glyphicon glyphicon-import"></div>
	</div>

	<!-- jqGrid -->
	<script src="${path }/resources/js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
	<script src="${path }/resources/js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>

</body>
</html>

