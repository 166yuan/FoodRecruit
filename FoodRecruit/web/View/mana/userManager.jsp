<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <meta charset="UTF-8">
  <!-- 强制国内垃圾浏览器开启高速模式-->
  <meta name="renderer" content="webkit">
  <title>用户管理</title>
  <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" >

  <link rel="stylesheet" type="text/css" href="/css/ace.min.css" >
  <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css" >
  <link rel="stylesheet" type="text/css" href="/css/manager.css" >
  <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/js/ace.min.js"></script>
</head>
<html>
<body class="no-skin">

<c:import url="header.jsp"/>
  <div class="col-xs-12">
    <h3 class="header smaller lighter blue">已注册用户</h3>
    <div class="table-header">
      查询结果按时间先后顺便排列
    </div>

    <!-- <div class="table-responsive"> -->

    <!-- <div class="dataTables_borderWrap"> -->
    <div>
      <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid"><div class="row"><div class="col-xs-6"><div id="sample-table-2_length" class="dataTables_length"><label>显示 <select size="1" name="sample-table-2_length" aria-controls="sample-table-2"><option value="10" selected="selected">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select>条记录</label></div></div><div class="col-xs-6"><div class="dataTables_filter" id="sample-table-2_filter"><label>搜索: <input type="text" aria-controls="sample-table-2"></label></div></div></div><table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
        <thead>
        <tr role="row"><th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="




													">
          <label class="position-relative">
            <input type="checkbox" class="ace">
            <span class="lbl"></span>
          </label>
        </th>
          <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">账号</th>
          <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Update: activate to sort column ascending">
            <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
            注册时间
          </th>
          <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending">姓名</th>
          <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending">性别</th>
          <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending">专业</th>
          <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending">班级</th>
          <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending">账号类型</th>
          <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending">账号状态</th>
          <th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending">操作</th>
        </tr></thead>


        <tbody role="alert" aria-live="polite" aria-relevant="all">
        <c:forEach items="${list}" var="user" varStatus="number">
          <tr class="odd">
            <td class="center  sorting_1">
              <label class="position-relative">
                <input type="checkbox" class="ace">
                <span class="lbl"></span>
              </label>
            </td>

            <td class=" ">
              <a href="/mana/showuserbyid?id=${user.id}">${user.account}</a>
            </td>
            <td class=" ">${user.createTime}</td>
            <td class=" ">${user.name}</td>
            <c:choose>
              <c:when test="${user.gender==1}">
            <td class="">男</td>
              </c:when>
              <c:otherwise>
                <td class="">女</td>
               </c:otherwise>
            </c:choose>
            <td class=" ">${user.major}</td>
            <td class=" ">${user.classes}</td>

            <td class=" ">
                <c:choose>
                  <c:when test="${user.type==1}">
                    <span class="lbl">学生</span>
                  </c:when>
                  <c:when test="${user.type==2}">
                    <span class="lbl">管理员</span>
                  </c:when>
                  <c:when test="${user.type==3}">
                  <span class="lbl">超级管理员</span>
                </c:when>
                </c:choose>

            </td>

            <td class=" ">
              <label>
                <c:choose>
                <c:when test="${user.status==-1}">
              <input name="status${number.count}" type="radio" checked="true" class="ace"/>
                </c:when>
                  <c:otherwise>
                    <input name="status${number.count}" type="radio"  class="ace">
                  </c:otherwise>
                </c:choose>
                <span class="lbl">未激活</span>
            </label>

              <label>
                <c:choose>
                  <c:when test="${user.status==1}">
                    <input name="status${number.count}" type="radio" checked="true" class="ace" />
                  </c:when>
                  <c:otherwise>
                    <input name="status${number.count}" type="radio"  class="ace">
                  </c:otherwise>
                </c:choose>
                <span class="lbl">激活</span>
              </label>

              <label>
                <c:choose>
                  <c:when test="${user.status==-2}">
                    <input name="status${number.count}" type="radio" checked="true" class="ace" />
                  </c:when>
                  <c:otherwise>
                    <input name="status${number.count}" type="radio"  class="ace">
                  </c:otherwise>
                </c:choose>
                <span class="lbl">冻结</span>
              </label>

            </td>
            <td class=" ">
              <div class="hidden-sm hidden-xs action-buttons">
                <a class="green" href="#">
                  <i class="ace-icon fa fa-pencil bigger-130"></i>
                </a>

                <a class="red" href="#">
                  <i class="ace-icon fa fa-trash-o bigger-130"></i>
                </a>
              </div>
            </td>
          </tr>
        </c:forEach>

        </tbody>

      </table>
        <div class="row">

          <div class="col-xs-12">
            <div class="dataTables_paginate paging_bootstrap">
              <ul class="pagination">
                <li class="prev disabled"><a href="#">
                  <i class="fa fa-angle-double-left"></i>
                </a></li>
                <li class="prev disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li><li class="active"><a href="#">1</a></li><li><a href="#">2</a></li><li><a href="#">3</a></li><li class="next"><a href="#"><i class="fa fa-angle-right"></i></a></li><li class="next"><a href="#"><i class="fa fa-angle-double-right"></i></a></li></ul></div></div></div></div>
    </div>
  </div>
</div>
<!-- 主体结束-->
</body>
</html>
</html>


