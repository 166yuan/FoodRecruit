<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/11/26
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<head>
    <meta charset="UTF-8">
    <!-- 强制国内垃圾浏览器开启高速模式-->
    <meta name="renderer" content="webkit">
    <title>个人中心</title>
<link rel="stylesheet" type="text/css" href="/css/backMain.css">
</head>
<html>
<body class="no-skin">
<!-- 主体部分-->
<c:import url="/View/common/main.jsp"/>
<div class="main">
   <div class="mainContent">
       <div class="project">
       <!-- 标题 -->
       <p class="title bigTitle">&nbsp;实验项目</p>

       <div class="collegeProject">
           <a href="#" class="more">更多&gt;&gt;</a>
           <p class="title smallTitle">&nbsp;学院项目</p>

           <marquee behavior="scroll" scrollamount="3" direction="up" onmouseover="this.stop()" onmouseout="this.start()">
               <ul>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
               </ul>
           </marquee>
       </div>

       <div class="studentProject">
           <a href="#" class="more">更多&gt;&gt;</a>
           <p class="title smallTitle">&nbsp;实验员项目</p>
           <marquee behavior="scroll" scrollamount="3" direction="up" onmouseover="this.stop()" onmouseout="this.start()">
               <ul>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
                   <li>
                       <a href="">关于乳酸菌的培养与华农酸奶的制作的实验(钟伟钊)</a>
                   </li>
               </ul>
           </marquee>
       </div>
   </div>
       <div class="assistant">
           <!-- 标题 -->
           <p class="title bigTitle">&nbsp;实验助手<a href="#" class="more">更多&gt;&gt;</a></p>

           <!-- 助手表格 -->
           <table>
               <tbody><tr class="th">
                   <td>姓名</td>
                   <td>性别</td>
                   <td>年级</td>
                   <td>专业班级</td>
                   <td>联系电话</td>
                   <td>宿舍住址</td>
               </tr>
               </tbody><tbody>
           <c:forEach items="${assistList}" var="assist">
           <tr class="">
               <td>${assist.user.name}</td>
               <c:choose>
                   <c:when test="${assist.user.gender==true}">
                       <td>男</td>
                   </c:when>
                   <c:when test="${assist.user.gender==false}">
                       <td>女</td>
                   </c:when>
                   <c:otherwise>
                       <td>未知</td>
                   </c:otherwise>
               </c:choose>
               <td>${assist.user.major.year}</td>
               <td>${assist.user.major.year}</td>
               <td>${assist.user.phone}</td>
               <td>${assist.user.address}</td>
           </tr>
           </c:forEach>
           </tbody>
           </table>
       </div>
   </div>

</div>
<!-- 主体结束-->
</body>
</html>


