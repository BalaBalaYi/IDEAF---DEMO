<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String prefix = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DEMO主页</title>
	<link href="<%=prefix%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=prefix%>/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
	<style type="text/css">
		body {
			padding-top: 50px;
		}
		.starter-template {
			padding: 40px 15px;
			text-align: center;
		}
	</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=prefix%>/toIndex.do">DEMO</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="<%=prefix%>/toIndex.do">Home</a>
						</li>
						<li>
						<a href="#about">About</a>
						</li>
						<li>
						<a href="#contact">Contact</a>
						</li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h1>CTY's DEMO</h1>
			<p>这是一个以Spring,Mybatis框架为基础，整合<br/>&nbsp;&nbsp;&nbsp;1.分库分表中间件：Sharding-JDBC;&nbsp;&nbsp;&nbsp;2.分布式配置系统：Disconf;&nbsp;&nbsp;&nbsp;3.mybatis分页插件：PageHelper;<br/>的综合demo示例.</p>
			<p><a class="btn btn-primary btn-lg" href="<%=prefix%>/toQuery.do" role="button">Learn more »</a></p>
		</div>
	</div>
	
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Sharding-JDBC</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
				<p><a class="btn btn-default" href="#" role="button">View details »</a></p>
			</div>
			<div class="col-md-4">
				<h2>Disconf</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
				<p><a class="btn btn-default" href="#" role="button">View details »</a></p>
			</div>
			<div class="col-md-4">
				<h2>PageHelper</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
				<p><a class="btn btn-default" href="#" role="button">View details »</a></p>
			</div>
		</div>
	
	<hr>
	
	<footer>
		<p>&copy; Company 2016</p>
	</footer>
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<%=prefix%>/js/jquery-2.2.4.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=prefix%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>