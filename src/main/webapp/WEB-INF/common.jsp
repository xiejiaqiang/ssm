<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="/privilege"  prefix="privilege" %>

<%
	/**-====================================================================
	 *                               基本常量的设定
	 *=====================================================================**/
	//设定context path
	String path = request.getContextPath();
	if("/".equals(path.trim())) path = "";
	pageContext.setAttribute("path",path);
%>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="${path }/resources/css/bootstrap.min.css?v=3.3.6" />
<link rel="stylesheet" type="text/css" href="${path }/resources/css/plugins/bootstrap-table/bootstrap-table.min.css">
<link rel="stylesheet" type="text/css" href="${path }/resources/css/font-awesome.css?v=4.4.0" />
<link rel="stylesheet" type="text/css" href="${path }/resources/css/plugins/iCheck/custom.css">
<link rel="stylesheet" type="text/css" href="${path }/resources/css/plugins/steps/jquery.steps.css">
<link rel="stylesheet" type="text/css" href="${path }/resources/css/animate.css" />
<link rel="stylesheet" type="text/css" href="${path }/resources/css/style.css?v=4.1.0">
<link rel="stylesheet" type="text/css" href="${path }/resources/css/plugins/sweetalert/sweetalert.css">
<link rel="stylesheet" type="text/css" href="${path }/resources/js/plugins/layer/laydate/skins/default/laydate.css">

<!--[if lt IE 9]>
<meta http-equiv="refresh" content="0;ie.html" />
<![endif]-->
<!-- JAVASCRIPT -->
<script src="${path }/resources/js/jquery.min.js?v=2.1.4"></script>
<script src="${path }/resources/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${path }/resources/js/plugins/layer/layer.min.js"></script>
<!-- 项目公共js文件 -->
<script  type="text/javascript" src="${path }/resources/js/common.js"></script>
<!-- 自定义js-->
<script src="${path }/resources/js/content.js?v=1.0.0"></script>
<!-- sweetalert弹框-->
<script src="${path }/resources/js/plugins/sweetalert/sweetalert.min.js"></script>
<!-- Peity-->
<script src="${path }/resources/js/plugins/peity/jquery.peity.min.js"></script>

<script src="${path }/resources/js/plugins/layer/laydate/laydate.js"></script>
<!-- Peity-->
<script src="${path }/resources/js/plugins/peity/jquery.peity.min.js"></script>
<!-- Bootstrap table-->
<script src="${path }/resources/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${path }/resources/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<!-- jQuery Validation plugin javascript-->
<script src="${path }/resources/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${path }/resources/js/plugins/validate/messages_zh.min.js"></script>

<!-- jQuery form  -->
<script src="${path }/resources/js/jquery.form.min.js"></script>


<script src="${path }/resources/js/plugins/staps/jquery.steps.min.js"></script>