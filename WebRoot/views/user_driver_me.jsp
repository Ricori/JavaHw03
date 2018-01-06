<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>打车-司机端</title>
  <link rel="stylesheet" href="./assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="./assets/css/me.css"/>
</head>

<body>
	<header data-am-widget="header" class="am-header am-header-default">
		<div class="am-header-left am-header-nav">
			<a href="./user_driver"><i class="am-header-icon am-icon-home"></i></a>
		</div>
		<h1 class="am-header-title">杭州市</h1>
		<div class="am-header-right am-header-nav">
			<a href="./user_driver_me"><i class="am-header-icon am-icon-user"></i></a>
		</div>
	</header>

	<div class="banner">
		<div class="bg"></div>
		<img src="assets/images/me-aw.jpg" class="avatar">
		<div class="phone">${user.getPhone()}</div>
	</div>

	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title">个性签名</h2>
	</div>
	<div class="main">
		<textarea class="signature" rows="4" id="doc-ta-1">${user.getSignature()}</textarea>
		<a href="#" class="am-btn am-btn-default am-btn-sm">更新</a>
	</div>

	<a href="user_loginout" class="am-btn am-btn-danger" style="margin-left:8px">退出账号</a>
	
  <div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default">
      <ul class="am-navbar-nav am-cf am-avg-sm-4">
          <li><a href="user_driver" class="">
                <span class="am-icon-taxi"></span>
                <span class="am-navbar-label">乘客行程列表</span>
          </a></li>
          <li><a href="user_driver_wallet" class="">
                <span class="am-icon-money"></span>
                <span class="am-navbar-label">我的钱包</span>
          </a></li>
          <li><a href="user_driver_me" class="">
                <span class="am-icon-user"></span>
                <span class="am-navbar-label">个人信息</span>
           </a></li>
      </ul>
  </div>

<script src="./assets/js/jquery.min.js"></script>
<script src="./assets/js/amazeui.min.js"></script>
</body>

</html>