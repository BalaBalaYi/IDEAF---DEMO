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
		.mainIntroTable td {
			margin-right: 10px;
			font-size: medium;
			font-style: italic;
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
			<h2>Integration of Distributed Enterprise Application Frame - DEMO</h2>
				<br/>
				<p>这是一个以Spring,Mybatis框架为基础，整合</p>
				<table class="mainIntroTable" style="width: 100%">
					<tr>
						<td>1.分库分表中间件：Sharding-JDBC</td><td>2.分布式配置系统：Disconf</td><td>3.分布式服务框架：Dubbox</td>
					</tr>
					<tr>
						<td>4.分布式弹性作业框架：Elastic-Job（暂未实现）</td><td>5.数据同步系统：Otter</td><td>6.离线数据整合+大数据处理基础构建：DataX+Hbase（暂未实现）</td>
					</tr>
				</table>
				<p><br>的综合demo示例.</p>
			<p><a class="btn btn-primary btn-lg" href="<%=prefix%>/toQuery.do" role="button">进入DEMO »</a></p>
		</div>
	</div>
	
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Sharding-JDBC</h2>
				<p>当当的基于jdbc协议的数据库分库分表解决方案，完美衔接spring+mybaits的ORM层实现。<br/><br/>在本项目中用于实现CRUD的分库分表及读写分离。</p>
				<p><a class="btn btn-default" href="https://github.com/dangdangdotcom/sharding-jdbc" role="button">View details »</a></p>
			</div>
			<div class="col-md-4">
				<h2>Disconf</h2>
				<p>百度的分布式文件配置解决方案。<br/><br/>在本项目中用于实现灵活，高效，并且完美热部署的文件配置及修改等功能。</p>
				<p><a class="btn btn-default" href="https://github.com/knightliao/disconf" role="button">View details »</a></p>
			</div>
			<div class="col-md-4">
				<h2>Dubbox</h2>
				<p>原为阿里的分布式服务框架，当当在此基础上进行了增强（建议使用dubbox，dubbo已经长时间没有得到维护）。<br/><br/>本项目通过dubbo-provider.xml简单模拟了通过dubbo实现的远程调用。</p>
				<p><a class="btn btn-default" href="https://github.com/dangdangdotcom/dubbox" role="button">View details »</a></p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<h2>Elastic-Job</h2>
				<p>当当的分布式弹性作业框架，与sharding-jdbc实现共同异步化操作。<br/><br/>暂未实现。</p>
				<p><a class="btn btn-default" href="https://github.com/dangdangdotcom/elastic-job" role="button">View details »</a></p>
			</div>
			<div class="col-md-4">
				<h2>Otter</h2>
				<p>阿里的数据同步解决方案。<br/><br/>在本项目中用于实现基于sharding-jdbc读写分离的主从库之间的数据同步。</p>
				<p><a class="btn btn-default" href="https://github.com/alibaba/otter" role="button">View details »</a></p>
			</div>
			<div class="col-md-4">
				<h2>DataX+Hbase</h2>
				<p>阿里开源的异构数据源离线同步工具。<br/><br/>在本项目中，计划用于结合elastic-job和Hbase，以实现离线的历史数据查询及大数据处理的基础构建。暂未实现。</p>
				<p><a class="btn btn-default" href="https://github.com/alibaba/DataX" role="button">View details »</a></p>
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