<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>
    ${competition.name}
  </title>
  <script type="text/javascript" src="/ueditor/ueditor.config.js"></script>
  <link rel="stylesheet" type="text/css" href="/css/link.css" >
  <link rel="stylesheet" type="text/css" href="/css/topbar.css" >
</head>
<body>
<div class="topbar-outter">
  <div class="topbar">
    <div class="topbar-grid topbar-wrap">
      <p class="toplink">
        <a href="#" target="_blank">食科联首页</a></p>
      <ul class="topmenu">
        <li id="topmenu-item-first-a" class="topmenu-item topmenu-item-first">
          <a href="#" target="_blank" title="登录" seed="topmenuItem-link">登录</a><b class="split">-</b><a href="#" target="_blank" title="注册">注册</a></li><li class="topmenu-item topmenu-item-last topmenu-jingkao-help"><a href="#" target="_blank" title="帮助中心">帮助中心</a></li></ul></div></div></div>
<div id="container">
      <div class="header-wrap" style="height: 90px;!important;">
        <header>
            <img src="/images/logo_min.png" />
        </header>
        <p>
          欢迎各位莘莘学子参与我们的比赛！
        </p>
      </div>

  <div id="last-p"></div>
  <div id="content">

    <section id="intro">
      <h1>竞赛入口</h1>
      <div class="reg-box top-right">

        <span class="reg-desc"><a id="delayDetail">离报名结束还有<span class="num">35</span>天</a></span>
        <a href="/compet/attend?id=${competition.id}" class="page-nav prize-btn " target="_blank">点我去报名</a>
      </div>


    </section>
    <section id="main">
      <h1>竞赛内容</h1>
      <div >
      ${competition.information}
      </div>
      </section>


  </div>
  <footer> ©华南农业大学食品科技联合会 </footer>
</div>

</body>
</html>
