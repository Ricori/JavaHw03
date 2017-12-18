<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>Login Page</title>
  <link rel="stylesheet" href="./assets/css/amazeui.min.css"/>
</head>
<body>

	<header data-am-widget="header" class="am-header am-header-default">
		<h1 class="am-header-title">约车APP</h1>
	</header>

	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title ">请登陆您的账号</h2>
	</div>

    <form action="userLoginCheck" method="post" class="am-form" style="padding: 16px;">
      <label>手机号:</label>
      <input type="text" name="phone" id="phone" value="">
      <br>
      <label for="password">密码:</label>
      <input type="password" name="pwd" id="password" value="">
      <br>

      <br />
      <div class="am-cf">
        <input type="submit" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
        <!-- <input type="submit" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr"> -->
      </div>
    </form>


</body>
</html>