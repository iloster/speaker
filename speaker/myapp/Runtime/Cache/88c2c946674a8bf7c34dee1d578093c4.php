<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="modern.css" rel="stylesheet">
<title>后台---校园活动</title>
</head>
<script>
$("#collapseOne").collapse({toggle:false});
function open_collapse()
{
   $("#collapseOne").collapse("show");
}
</script>
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
		<li><a href="__URL__/index"><i class="icon-heart"></i>Home</a></li>
		<li ><a href="__URL__/speaker/string/Speaker"><i class="icon-cogs"></i>喇叭说</a></li>
		<li><a href="__URL__/speaker/string/Found"><i class="icon-th"></i>寻物招领</a>		</li>
        <li class="active"><a href="__URL__/speaker/string/Notice"><i class="icon-bullhorn"></i>校园活动</a></li>
		<li><a href="__URL__/contact"><i class="icon-envelope"></i>联系我们</a></li>
	</ul>
</div>
<div class="form-speaker">
  <div class="insert-btn">
        <a style="cursor:pointer;text-decoration:none" data-toggle="collapse"  data-target="#collapseOne" onClick="open_collapse()">
                                           添加
      </a>
      </div>
  <div class="form-class">
    <div id="collapseOne" class="collapse">
      <form action="__URL__/speaker_insert/string/Notice" class="form-horizontal" method="post">
      <div class="control-group">
           <label class="control-label">标题:</label>
              <div class="controls">
                 <input type="text" name="title_speaker" placeholder="格式:x月x日">
              </div>
          </div>
          <div class="control-group">
            <label class="control-label">内容:</label>
              <div class="controls">
                <textarea rows="3" cols="100" placeholder="今天想对大家说什么" name="content_speaker"></textarea>
              </div>
          </div>
         <div class="control-group">
           <label class="control-label">日期:</label>
              <div class="controls">
                 <input type="text" name="time_speaker" placeholder="格式:x月x日">
              </div>
          </div>
        <div class="control-group">
          <div class="controls">
            <button type="submit" class="btn">提交</button>
         </div>
         </div>
      </form>
      </div>
</div>
  </div>
  <div class="table-speaker">
      <table class="table table-hover table-bordered"  style="word-break:break-all; word-wrap:break-all;">

             <tr>
                  <td width="5%">序号</td>
                  <td style="word-break:break-all; word-wrap:break-all;width:15%">标题</td>
                 <td style="word-break:break-all; word-wrap:break-all;width:60%">内容</td>
                  <td width="10%">时间</td>
                 <td width="10%">操作</td>
            </tr>
           <?php if(is_array($data)): $i = 0; $__LIST__ = $data;if( count($__LIST__)==0 ) : echo "" ;else: foreach($__LIST__ as $key=>$vo): $mod = ($i % 2 );++$i;?><tr>
                <td><?php echo ($i); ?></td>
                <td><?php echo ($vo["title"]); ?></td>
               <td><?php echo ($vo["content"]); ?></td>
               <td><?php echo ($vo["time"]); ?></td>
               <td><a href="__URL__/speaker_del/string/Notice/id/<?php echo ($vo["id"]); ?>">删除</a></td>
             </tr><?php endforeach; endif; else: echo "" ;endif; ?>
      </table>
      <div  class="pagination pagination-large" style="text-align:center"><?php echo ($show); ?></div>
  </div>
</body>
</html>