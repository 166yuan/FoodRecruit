<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/11/26
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<head>
    <meta charset="UTF-8">
    <!-- 强制国内垃圾浏览器开启高速模式-->
    <meta name="renderer" content="webkit">
    <title>我的竞赛</title>

</head>
<html>
<body class="no-skin">
<!--导航栏-->

<!--导航栏结束-->
<!-- 主体部分-->
<c:import url="/View/common/header.jsp"/>
<!-- 面包屑-->
<div class="breadcrumbs" id="breadcrumbs">
    <script type="text/javascript">
        try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
    </script>

    <ul class="breadcrumb">
        <li>
            <i class="ace-icon fa fa-home home-icon"></i>
            <a href="/View/user/myspace.jsp">主页</a>
        </li>
        <li class="active">
            我的竞赛
        </li>
    </ul><!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->
<br>
<div class="col-sm-2">
    <div class="list-group">
        <a href="/compet/mycompet?page=1" class="list-group-item">我参与的竞赛</a>
        <a href="#" class="list-group-item active">我现在进行的竞赛</a>
        <a href="/compet/passCompet?page=1" class="list-group-item">过去的竞赛</a>
    </div>
</div>
<div class="col-sm-10" id="all">
    <div class="widget-box widget-color-blue2" style="opacity: 1; z-index: 0;">
        <!-- #section:custom/widget-box.options -->
        <div class="widget-header">
            <h5 class="widget-title bigger lighter">
                <i class="ace-icon fa fa-table"></i>
                我的竞赛足迹
            </h5>

        </div>

        <div class="widget-body">
            <div class="widget-main no-padding">
                <table class="table table-striped table-bordered table-hover">
                    <thead class="thin-border-bottom">
                    <tr>
                        <th>
                            </i>
                            名称
                        </th>

                        <th>
                            <i class="ace-icon fa fa-calendar"></i>
                            时间
                        </th>


                        <th>
                            <i class="ace-icon fa fa-leaf"></i>状态</th>
                        </th>

                        <th >
                            <i class="ace-icon fa fa-leaf"></i>我的队伍</th>
                        </th>

                        <th>
                            <i class="ace-icon fa fa-leaf"></i>查看竞赛</th>
                        </th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${list}" var="competiotion">
                        <tr>

                            <td class="">${  competiotion.competName}</td>

                            <td>
                                <fmt:formatDate value="${competiotion.beginTime}"></fmt:formatDate> -
                                <fmt:formatDate value="${competiotion.endTime}"></fmt:formatDate>

                            </td>

                            <td class="hidden-480">
                                    <span class="label label-success">进行中</span>
                            </td>

                            <td>
                                <a href="/mana/showNotiById?id=21&amp;name=admin">
                                    <span class="btn btn-info btn-sm popover-info" data-rel="popover" data-placement="bottom" title="" data-content="Heads up! This alert needs your attention, but it's not super important." data-original-title="Some Info">查看</span>
                                </a>
                            </td>

                            <td>
                                <a href="/mana/showNotiById?id=21&amp;name=admin">
                                    <span class="btn btn-info btn-sm popover-info" data-rel="popover" data-placement="bottom" title="" data-content="Heads up! This alert needs your attention, but it's not super important." data-original-title="Some Info">查看</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>

<!-- 主体结束-->
</body>
</html>
</html>


