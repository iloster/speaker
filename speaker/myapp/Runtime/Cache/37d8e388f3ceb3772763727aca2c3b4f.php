<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台</title>
</head>

<body>
   <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>speaker后台页面</title>
<link href="../Public/MainPublic/css/flexy-menu.css" rel="stylesheet">
<link href="../Public/MainPublic/css/font-awesome.css" rel="stylesheet">
<link href="../Public/MainPublic/css/home.css" rel="stylesheet">
<link href="../Public/MainPublic/css/modern.css" rel="stylesheet">
<link href="../Public/MainPublic/css/bootstrap.css" rel="stylesheet">

 <script src="http://code.jquery.com/jquery.js"></script>
 <script src="../Public/MainPublic/js/bootstrap.min.js"></script>
<link href="modern.css" rel="stylesheet">
<script type="text/javascript" src="../Public/MainPublic/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../Public/MainPublic/js/flexy-menu.js"></script>
<script type="text/javascript">$(document).ready(function(){$(".flexy-menu").flexymenu({speed: 400});});</script>
</head>
<!--
<div class="nav1">
	<ul class="flexy-menu orange">
		<li><a href="__URL__/index"><i class="icon-heart"></i>Home</a></li>
		<li><a href="__URL__/speaker"><i class="icon-cogs"></i>喇叭说</a></li>
		<li><a href="__URL__/found"><i class="icon-th"></i>寻物招领</a>		</li>
        <li><a href="__URL__/notice"><i class="icon-bullhorn"></i>校园活动</a></li>
		<li><a href="__URL__/contact"><i class="icon-envelope"></i>联系我们</a></li>
	</ul>
</div>
-->
</html>
 <div class="nav1">
	<ul class="flexy-menu orange">
		<li class="active"><a href="__URL__/index"><i class="icon-heart"></i>Home</a></li>
		<li><a href="__URL__/speaker/string/Speaker"><i class="icon-cogs"></i>喇叭说</a></li>
		<li><a href="__URL__/speaker/string/Found"><i class="icon-th"></i>寻物招领</a>		</li>
        <li><a href="__URL__/speaker/string/Notice"><i class="icon-bullhorn"></i>校园活动</a></li>
		<li><a href="__URL__/contact"><i class="icon-envelope"></i>联系我们</a></li>
	</ul>
</div>
 <div class="content">
                   欢迎的你的登录，<br>
                 用 户名:<?php echo ($username); ?><br/>
                 学校:<?php echo ($school); ?>
</div>
</body>

</html>