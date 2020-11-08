<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>上海佳一全国销售图</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/common.jsp"%>
    <link rel="stylesheet" type="text/css" href="${path }/resources/css/plugins/multistage-pull-down.css" />
    <link rel="stylesheet" type="text/css" href="${path }/resources/css/plugins/ionRangeSlider/ion.rangeSlider.css" >
    <link type="text/css" href="${path }/resources/css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css" rel="stylesheet">
    <link type="text/css" href="${path }/resources/css/plugins/ionRangeSlider/normalize.min.css" rel="stylesheet">

    <script src="${path }/resources/js/view/mdse/echarts-mdse.js"></script>
    <!-- ECharts -->
    <script src="${path }/resources/js/plugins/echarts/echarts-all.js"></script>
    <!-- ECharts demo data -->
    <script src="${path }/resources/js/demo/echarts-demo.js"></script>
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

    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>上海佳一全国销售图</h5>
            <div class="ibox-tools">
                <a class="dropdown-toggle"  style="color:red" data-toggle="dropdown">
                    <strong>点击选择商品分类</strong>   <i class="fa fa-wrench"></i>
                </a>
                        <input type="test" name="view_mdseCat" id="view_mdseCat" value='${mdseCatList}' class="form-control hide">
                        <input type="test" name="txt_mdseCat" id="txt_mdseCat" class="form-control hide">
                        <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
                            <li><a tabindex="-1" href='javascript:setMdseCat("-1|全部");'>全部</a></li>
                            <c:forEach items="${mdseCatTree}" var="mdseCat">
                            <c:choose>
                            <c:when test="${fn:length(mdseCat.children) gt 0 }">
                            <li class="dropdown-submenu pull-left">
                                <a tabindex="-1" href='javascript:setMdseCat("${mdseCat.id}"+"|"+"${mdseCat.text}");'>${mdseCat.text}</a>
                                <ul class="dropdown-menu">
                                    <li><a tabindex="-1" href='javascript:setMdseCat("${mdseCat.id}"+"|"+"${mdseCat.text}");'>全部</a></li>
                                    <c:forEach items="${mdseCat.children}" var="mdseCat1">
                                    <c:choose>
                                    <c:when test="${fn:length(mdseCat1.children) gt 0 }">
                                    <li class="dropdown-submenu pull-left">
                                        <a tabindex="-1" href='javascript:setMdseCat("${mdseCat1.id}"+"|"+"${mdseCat1.text}");'>${mdseCat1.text}</a>
                                        <ul class="dropdown-menu">
                                            <li><a tabindex="-1" href='javascript:setMdseCat("${mdseCat1.id}"+"|"+"${mdseCat1.text}");'>全部</a></li>
                                            <c:forEach items="${mdseCat1.children }" var="mdseCat2">
                                            <c:choose>
                                            <c:when test="${fn:length(mdseCat2.children) gt 0 }">
                                            <li class="dropdown-submenu pull-left">
                                                <a tabindex="-1" href='javascript:setMdseCat("${mdseCat2.id}"+"|"+"${mdseCat2.text}");'>${mdseCat2.text}</a>
                                                <ul class="dropdown-menu">
                                                    <li><a tabindex="-1" href='javascript:setMdseCat("${mdseCat2.id}"+"|"+"${mdseCat2.text}");'>全部</a></li>
                                                    <c:forEach items="${mdseCat2.children }" var="mdseCat3">
                                                    <c:choose>
                                                    <c:when test="${fn:length(mdseCat3.children) gt 0 }">
                                                    <li class="dropdown-submenu pull-left"> </li>
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
        <div class="ibox-content">
            <div style="height:600px" id="echarts-map-chart"></div>
        </div>
    </div>
</div>
</body>
</html>