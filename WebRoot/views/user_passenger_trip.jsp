<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>打车-乘客端</title>
  <link rel="stylesheet" href="./assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="./assets/css/passenger.css"/>
</head>

<body>
	<header data-am-widget="header" class="am-header am-header-default">
		<div class="am-header-left am-header-nav">
			<a href="./user_passenger"><i class="am-header-icon am-icon-home"></i></a>
		</div>
		<h1 class="am-header-title">杭州市</h1>
		<div class="am-header-right am-header-nav">
			<a href="./user_passenger_me"><i class="am-header-icon am-icon-user"></i></a>
		</div>
	</header>

	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-color:#f37a4c;">
		<h2 class="am-titlebar-title tripingtitle">进行中的行程</h2>
	</div>
	<div class="tripinglists">
		<div class="am-panel am-panel-warning">
			<div class="am-panel-hd">面板标题</div>
			<div class="am-panel-bd">面板内容</div>
		</div>		
	</div>
	
	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-color:#5db95d;">
		<h2 class="am-titlebar-title publishtriptitle">发布中的行程</h2>
	</div>
	<div class="publishtriplists">
		<div class="am-panel am-panel-success">
			<div class="am-panel-hd">面板标题</div>
			<div class="am-panel-bd">面板内容</div>
		</div>	
	</div>
	
	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title">已结束的行程</h2>
	</div>
	<div class="endtriplists">
		<div class="am-panel am-panel-secondary">
			<div class="am-panel-hd">面板标题</div>
			<div class="am-panel-bd">面板内容</div>
		</div>
		<div class="am-panel am-panel-secondary">
			<div class="am-panel-hd">面板标题</div>
			<div class="am-panel-bd">面板内容</div>
		</div>		
	</div>
	
	<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default">
      <ul class="am-navbar-nav am-cf am-avg-sm-4">
          <li><a href="user_passenger" class="">
                <span class="am-icon-taxi"></span>
                <span class="am-navbar-label">发布行程</span>
          </a></li>
          <li><a href="user_passenger_tripinfo" class="">
                <span class="am-icon-send"></span>
                <span class="am-navbar-label">我的行程</span>
          </a></li>
          <li><a href="user_passenger_wallet" class="">
                <span class="am-icon-money"></span>
                <span class="am-navbar-label">我的钱包</span>
          </a></li>
          <li><a href="user_passenger_me" class="">
                <span class="am-icon-user"></span>
                <span class="am-navbar-label">个人信息</span>
           </a></li>
      </ul>
  </div>

<script src="./assets/js/jquery.min.js"></script>
<script src="./assets/js/amazeui.min.js"></script>
</body>

</html>