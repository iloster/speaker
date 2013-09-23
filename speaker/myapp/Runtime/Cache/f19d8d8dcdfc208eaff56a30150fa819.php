<?php if (!defined('THINK_PATH')) exit();?>﻿<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>校园小喇叭登录</title>
	<meta name="keywords" content="校园小喇叭">
	<link rel="shortcut icon" href="http://www.w3cplus.com/sites/all/themes/marvin/favicon.ico">
	<script type="text/javascript" charset="UTF-8" src="http://www.w3cplus.com/demo/css3/prefixfree.min.js"></script>
	<link rel="stylesheet" type="text/css" href="http://www.w3cplus.com/demo/css3/base.css" media="all" />
	<link href='http://fonts.googleapis.com/css?family=Denk+One' rel='stylesheet' type='text/css'>
<style type="text/css">
html{
  height: 100%;
  background-color: #252326;
  background:
  	url('../Public/img/dots.png') center center fixed,
  	url('../Public/img/bg.jpg') center center no-repeat fixed;
    background-size: auto, cover;
}
body {
	/*font-family: "HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial, "Lucida Grande", sans-serif;*/
        font-family:'Microsoft YaHei',微软雅黑, 'Microsoft JhengHei', 宋体; line-height:1.5; font-size:14px; margin:0;
	font-weight:300;
	text-align: left;
	text-decoration: none;
	overflow:hidden;
	background:none;
}
@font-face {
	font-family: 'broccolidry';
	src:url('../Public/fonts/broccolidry.eot');
	src:url('../Public/fonts/broccolidry.eot?#iefix') format('embedded-opentype'),
		url('../Public/fonts/broccolidry.svg#broccolidry') format('svg'),
		url('../Public/fonts/broccolidry.woff') format('woff'),
		url('../Public/fonts/broccolidry.ttf') format('truetype');
	font-weight: normal;
	font-style: normal;
}


/* Use the following CSS code if you want to have a class per icon */
[class^="icon-"]:before,
[class*=" icon-"]:before {
	font-family: 'broccolidry';
	font-style: normal;
	speak: none;
	font-weight: normal;
	line-height: 1;
	font-smoothing: antialiased;
	color: white;
  font-size: 20px;
  display: block;
  height: 50px;
  line-height: 47px;
  text-align: center;
}
.icon-pass:before {
	content: "\e000";
}
.icon-user:before {
	content: "\e001";
}


/*******************
LOGIN FORM
*******************/

.login-form {
	width: 300px;
	margin: 50px auto;
	position: relative;
	background: #f3f3f3;
	border: 1px solid #fff;
	border-radius: 5px;
	box-shadow: 0 1px 3px rgba(0,0,0,0.5);
}

/*******************
HEADER
*******************/

.login-form .header {
	padding: 40px 30px 30px 30px;
}

.login-form .header h1 {
	/*font:300 28px/34px 'Denk One', sans-serif;*/
	color: #414848;
	text-shadow: 1px 1px 0 rgba(256,256,256,1.0);
	margin-bottom: 10px;
}

.login-form .header span {
	font-size: 11px;
	line-height: 16px;
	color: #678889;
	text-shadow: 1px 1px 0 rgba(256,256,256,1.0);
}

/*******************
CONTENT
*******************/

.login-form .content {
	padding: 0 30px 25px 30px;
}


.login-form .content .input {
	width: 188px;
	padding: 15px 25px;
	font:400 14px "HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial, "Lucida Grande", sans-serif;
	color: #9d9e9e;
	text-shadow: 1px 1px 0 rgba(256,256,256,1.0);
	background: #fff;
	border: 1px solid #fff;
	border-radius: 5px;
	box-shadow: inset 0 1px 3px rgba(0,0,0,0.50);
}

.login-form .content .password,
.login-form .content .icon-pass {
	margin-top: 25px;
}

.login-form .content .input:hover {
	background: #dfe9ec;
	color: #414848;
}

.login-form .content .input:focus {
	background: #dfe9ec;
	color: #414848;
	box-shadow: inset 0 1px 2px rgba(0,0,0,0.25);
}

[class^="icon-"] {
	width: 46px;
	height: 47px;
	display: block;
	position: absolute;
	left: 2000px;
	padding-right: 2px;
	z-index: 3;
	border-radius: 5px 0 0 5px;
	background:rgba(65, 72, 72, 0.75);
}

.icon-user {
	/*top:147px;*/
 	top:110px;
}

.icon-pass {
	top:170px;
}

.input,
[class^="icon-"],
.button,
.register {
	transition: all 0.5s;

}
input[type="text"]:focus ~ #user-icon,
input[type="password"]:focus ~ #user-pass {
  left:-49px;
}
/*******************
FOOTER
*******************/

.login-form .footer {
	padding: 25px 30px 40px 30px;
	overflow: auto;
	background: #d4dedf;
	border-top: 1px solid #fff;
	box-shadow: inset 0 1px 0 rgba(0,0,0,0.15);
}

/* Login button */
.login-form .footer .button {
	float:right;
	padding: 11px 25px;
	font:300 18px 'Denk One', sans-serif;
	color: #fff;
	text-shadow: 0px 1px 0 rgba(0,0,0,0.25);
	background: #56c2e1;
	border: 1px solid #46b3d3;
	border-radius: 5px;
	cursor: pointer;
	box-shadow: inset 0 0 2px rgba(256,256,256,0.75);
}

.login-form .footer .button:hover {
	background: #3f9db8;
	border: 1px solid rgba(256,256,256,0.75);
	box-shadow: inset 0 1px 3px rgba(0,0,0,0.5);
}

.login-form .footer .button:focus {
	position: relative;
	bottom: -1px;
	background: #56c2e1;
	box-shadow: inset 0 1px 6px rgba(256,256,256,0.75);
}

/* Register button */
.login-form .footer .register {
	display: block;
	float: right;
	padding: 10px;
	margin-right: 20px;
	background: none;
	border: none;
	cursor: pointer;
	font:300 18px 'Denk One', sans-serif;
	color: #414848;
	text-shadow: 0px 1px 0 rgba(256,256,256,0.5);
}

.login-form .footer .register:hover {
	color: #3f9db8;
}

.login-form .footer .register:focus {
	position: relative;
	bottom: -1px;
}
.ft
{
text-align:center;position:absolute;bottom: 10px;width:100%;color: rgba(255, 255, 255, 0.6);

}
</style>
</head>
<body>
<div class="page">
	<section class="demo">
			<form name="login-form" class="login-form" action="__URL__/CheckLogin" method="post">
				<div class="header">
					<h1>登录</h1>
					<span></span>
				</div>
				<div class="content">
					<input name="username" type="text" class="input username" placeholder="Username" />
					<div class="icon-user" id="user-icon"></div>
					<input name="password" type="password" class="input password" placeholder="Password" />
					<div class="icon-pass" id="user-pass"></div>
				</div>
				<div class="footer">
					<input type="submit" name="submit" value="登录" class="button" />
					<!--<input type="submit" name="submit" value="Register" class="register" />-->
				</div>
			</form>

	</section>
</div>
<div class="ft">
<div id="ft">
	<!--{__RUNTIME__}-->
	CopyRight &copy; 2012 by Pluto</a><br />
	Supported By loster--ilovelhx@gmail.com
</div>
</div>
</body>
</html>