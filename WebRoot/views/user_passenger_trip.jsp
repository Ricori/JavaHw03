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

	<c:if test="${tripingOrders.size() != 0}">
	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-color:#f37a4c;">
		<h2 class="am-titlebar-title tripingtitle">进行中的行程</h2>
	</div>
	<div class="tripinglists">
		<c:forEach items="${tripingOrders}" var="tripingOrder">
			<div class="am-panel am-panel-warning">
				<div class="am-panel-hd">订单编号:${tripingOrder.getId()} 
				<c:if test="${tripingOrder.getDstartstate() == 0}">(等待司机到达)</c:if>
				<c:if test="${tripingOrder.getDstartstate() == 1 && tripingOrder.getPstartstate() == 0}">
					<b>(司机已经到达约定地点，请尽快确认出发)</b>
				</c:if>
				<c:if test="${tripingOrder.getDstartstate() == 1 && tripingOrder.getPstartstate() == 1
					&& tripingOrder.getDendstate() == 0}"><b>(行程中...)</b>
				</c:if>
				<c:if test="${tripingOrder.getDendstate() == 1}"><b>(司机已经到达目的地，请尽快确认到达)</b></c:if>
				</div>
				<div class="am-panel-bd">
				<ul>
				<li>
				<c:if test="${tripingOrder.getDstartstate() == 0}">订单状态：等待司机到达</c:if>
				<c:if test="${tripingOrder.getDstartstate() == 1 && tripingOrder.getPstartstate() == 0}">
					订单状态：司机已经到约定地点
				</c:if>
				<c:if test="${tripingOrder.getDstartstate() == 1 && tripingOrder.getPstartstate() == 1
					&& tripingOrder.getDendstate() == 0}">
					订单状态：行程中
				</c:if>
				<c:if test="${tripingOrder.getDendstate() == 1}">订单状态：司机已确认到达目的地</c:if>
				</li>
			    <li>接单司机id：${tripingOrder.getDriver()}</li>
			    <li>接单司机手机号：${tripingOrder.getDriverphone()}</li>
			    <li>出发地点：${tripingOrder.getStartplace()}</li>
			    <li>目的地点：${tripingOrder.getEndplace()}</li>
			    <li>行程人数：${tripingOrder.getPeoplenum()}</li>
			    <li>期望价格：${tripingOrder.getPrice()}</li>
			  	</ul>
			  	
			  	<c:if test="${tripingOrder.getDstartstate() == 1 && tripingOrder.getPstartstate() == 0}">
					<a href="user_passenger_confirmstart?id=${tripingOrder.getId()}" 
						class="am-btn am-btn-warning am-btn-sm">我已上车，确认出发</a>
				</c:if>
				<c:if test="${tripingOrder.getDendstate() == 1}">
					<a href="user_passenger_confirmend?id=${tripingOrder.getId()}" 
						class="am-btn am-btn-warning am-btn-sm">确认到达目的地，支付${tripingOrder.getPrice()}元</a>
				</c:if>
				</div>
			</div>
		</c:forEach>
	</div>
	</c:if>
	
	<c:if test="${allPublishTrips.size() != 0}">
	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-color:#5db95d;">
		<h2 class="am-titlebar-title publishtriptitle">发布中的行程</h2>
	</div>
	<div class="publishtriplists">
		<c:forEach items="${allPublishTrips}" var="publishTrip">
			<div class="am-panel am-panel-success">
				<div class="am-panel-hd">订单编号:${publishTrip.getId()} 
				<c:if test="${publishTrip.getOrder() == 0}">(等待司机接单)</c:if>
				<c:if test="${publishTrip.getOrder() == 1}"><b>(司机已接单)</b></c:if>
				</div>
				<div class="am-panel-bd">
				<ul>
				<li>
				<c:if test="${publishTrip.getOrder() == 0}">状态：等待司机接单...</c:if>
				<c:if test="${publishTrip.getOrder() == 1}">状态：司机已接单,请尽快到达约定地点上车</c:if>
				</li>
			    <li>出发地点：${publishTrip.getStartplace()}</li>
			    <li>目的地点：${publishTrip.getEndplace()}</li>
			    <li>出发时间：${publishTrip.getStarttime()}</li>
			    <li>行程人数：${publishTrip.getPeoplenum()}</li>
			    <li>期望价格：${publishTrip.getPrice()}</li>
			  	</ul>
				</div>
			</div>	
		</c:forEach>
	</div>
	</c:if>
	
	<c:if test="${endTripOrders.size() != 0}">
	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title">已结束的行程</h2>
	</div>
	<div class="endtriplists">
		<c:forEach items="${endTripOrders}" var="endTripOrder">
			<div class="am-panel am-panel-secondary">
				<div class="am-panel-hd">订单编号:${endTripOrder.getId()} </div>
				<div class="am-panel-bd">
				<ul>
				<li>状态：已完成</li>
			    <li>接单司机id：${endTripOrder.getDriver()}</li>
			    <li>接单司机手机号：${endTripOrder.getDriverphone()}</li>
			    <li>出发地点：${endTripOrder.getStartplace()}</li>
			    <li>目的地点：${endTripOrder.getEndplace()}</li>
			    <li>行程人数：${endTripOrder.getPeoplenum()}</li>
			    <li>价格：${endTripOrder.getPrice()}</li>
			    <li>支付订单号：${endTripOrder.getPayid()}</li>
			  	</ul>
				</div>
			</div>	
		</c:forEach>		
	</div>
	</c:if>
	
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