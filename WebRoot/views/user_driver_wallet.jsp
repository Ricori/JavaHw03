<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>打车-司机端</title>
  <link rel="stylesheet" href="./assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="./assets/css/driver.css"/>
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

	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title">账单明细</h2>
	</div>
	<div style="margin:8px">
	<table class="am-table am-table-bordered am-table-radius am-table-striped">
     <thead>
        <tr>
            <th>付款编号</th>
            <th>订单编号</th>
            <th>金额变动</th>
            <th>付款时间</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${payInfos}" var="payInfo">
        <tr>
        	<td class="am-primary">${payInfo.getId()}</td>
            <td>${payInfo.getOrderid()}</td>
            <td class="am-danger">+${payInfo.getPrice()}元</td>
            <td>${payInfo.getTime()}</td>
        </tr>
        </c:forEach>
    </tbody>
	</table>
	</div>

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