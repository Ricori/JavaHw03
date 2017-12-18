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


	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default"">
		<h2 class="am-titlebar-title ">填写行程信息</h2>
	</div>
	
	<div class="am-panel am-panel-default addtrippanel">
	<div class="am-panel-bd">
      <form action="publishTrip" method="post" class="am-form" style="padding: 5px;">
      <label>出发地点</label>
      <input type="text" name="splace" value="杭州电子科技大学信息工程学院青山湖校区" required/>
      <br>
      <label for="password">你要去哪儿</label>
      <input type="text" name="eplace" value="临安东站" required/>
      <br>

      <div class="am-form-group am-form-icon">
	    <i class="am-icon-calendar"></i>
	    <input type="text" name="stimed" class="am-form-field" placeholder="出发日期" 
	    data-am-datepicker readonly required/>
	  </div>
	  <div class="am-form-group am-form-icon">
	    <i class="am-icon-clock-o"></i>
	    <input type="text" name="stimehm" class="am-form-field" placeholder="出发时间" required/>
	  </div>

      <label for="password">乘车人数&nbsp;</label>
		<div class="am-btn-group doc-js-btn-1" data-am-button>
		  <label class="am-btn am-btn-primary">
		    <input type="radio" name="people" value="1" checked>1
		  </label>
		  <label class="am-btn am-btn-primary">
		    <input type="radio" name="people" value="2" >2
		  </label>
		  <label class="am-btn am-btn-primary">
		    <input type="radio" name="people" value="3" >3
		  </label>
		  <label class="am-btn am-btn-primary">
		    <input type="radio" name="people" value="4" >4
		  </label>
		</div>

	  <br>
	  <label for="password">期望价格(元)</label>
      <input type="text" name="price" value="30" required/>
      <br><br>
      <button type="submit" class="am-btn am-btn-primary am-btn-block">发布行程</button>

      </form>
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