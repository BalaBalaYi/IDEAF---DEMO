<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String prefix = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DEMO示例</title>

<link href="<%=prefix%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=prefix%>/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
<link href="<%=prefix%>/dataTables/media/css/jquery.dataTables.css" rel="stylesheet" type="text/css">
<link href="<%=prefix%>/js/sweetalert/sweetalert2.min.css" rel="stylesheet" type="text/css"/>

<style type="text/css">
	body {
		padding-top: 50px;
	}
	.demoMain {
		padding: 15px;
		text-align: center;
	}
	.contentMain {
		text-align: center;
		padding: 5px 15px;
	}
	th {
		text-align:center;
	}
</style>

<script type="text/javascript" src="<%=prefix%>/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="<%=prefix%>/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=prefix%>/dataTables/media/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="<%=prefix%>/js/dateUtils.js"></script>
<script type="text/javascript" src="<%=prefix%>/js/sweetalert/sweetalert2.min.js"></script>

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
						<a id="contactId" href="#contact" data-toggle="popover" title="">Contact</a>
						</li>
				</ul>
			</div>
		</div>
	</nav>

	<div id="main" class="demoMain">
		<div id="title">
			<h1>IDEAF-DEMO</h1>
			<h3>————书籍管理</h3>
		</div>
		<div id="content" class="demoMain">
			<form action="<%=prefix%>/toAdd.do" method="post">
				<table class="contentMain">
					<tr>
<!-- 						<td colspan="2"> -->
<!-- 							<div class="input-group"> -->
<!-- 								<input type="text" id="bookId" class="form-control" width="100px"/> -->
<!-- 								<span class="input-group-btn"> -->
<!-- 									<button class="btn btn-default" type="button" id="query">查询</button> -->
<!-- 								</span> -->
<!-- 							</div> -->
<!-- 						</td> -->
						<td >
							<div class="input-group">
								<span class="input-group-btn">
									<button class="btn btn-default" type="submit" id="add">新增</button>
								</span>
							</div>
						</td>
					</tr>
				</table>
				<br/>
			</form>
			<table id="table_id_query" class="display">
				<thead>
					<tr>
						<th>编号</th>
						<th>书名</th>
						<th>作者</th>
						<th>出版社</th>
						<th>出版时间</th>
						<th>价格</th>
						<th>ISBN</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			
		</div>
	</div>
	<div style=" clear:both;"> </div>
	<div style=" clear:both;"> </div>
	<div style="height:10px; line-height:10px;">&nbsp;</div>
	
	
	<script type="text/javascript">
	$(document).ready(function(){

		//启动DataTables
		var dataTable = $('#table_id_query').DataTable({
			"processing": false,
			"serverSide": false,
<%-- 			"sAjaxSource": "<%=prefix%>/query.do",
			"fnServerData": function() {
				$.ajax({
					"url": "<%=prefix%>/query.do",
					"type": "POST",
					"data":{"pageNum":this.page(), "pageSize":dataTable.page.len()}
					"dataSrc": "bookList"
				});
			},
			"sAjaxDataProp": "bookList", --%>
			"ajax": {
				"url": "<%=prefix%>/query.do",
				"type": "POST",
				"dataSrc": "bookList"
			},
			"columns": [
				{ "data": "id", "render": function(data, type, full, meta){
					var content = "";
					if(data % 2 == 0){
						content += "database:dbtbl_0 ";
					} else {
						content += "database:dbtbl_1 ";
					}
					return '<a class="boodIdClass" href="#" data-toggle="popover" data-container="body" data-placement="top" title="数据来源" data-content="' + content + '">' + data + '</a>';
				} },
				{ "data": "name" },
				{ "data": "author" },
				{ "data": "publisher" },
				{ "data": "publicationTime", "render": function(data, type, full, meta){
					return new Date(data).Format("yyyy-MM-dd");
				} },
				{ "data": "price" },
				{ "data": "isbn" },
				{ "data": "id", "render": function(data, type, full, meta){
					return '<a href="<%=prefix%>/toUpdate.do?bookId=' + data + '">修改</a> | <a class="deleteLink" ref="' + data +'" href="#" onclick="doDelete(this)">删除</a>';
				} }
			]
		});
		
		//当表格重绘完成后的绑定事件
		$('#table_id_query').on('draw.dt',function() {
			/*
			 * 启动popover的鼠标悬浮提示框
			 */
			var options = {
				title:"数据源",
				trigger:"hover"
			}
			$('.boodIdClass').popover(options); 
			
			/*
			 * 对编号部位提示框内容信息的补充
			 */

		});
		
// 		console.log("分页长度："+dataTable.page.len());
// 		console.log("当前页："+dataTable.page());
		
	});
	
	//删除的异步操作
	function doDelete(item){
		var bookId = $(item).attr('ref');
		swal({
			title: "删除确认？",
			text: "即将删除的书籍编号：" + bookId,
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "确认",
			cancelButtonText:"取消"
		}).then(function(isConfirm){
			if (isConfirm === true) {
				$.get('<%=prefix%>/delete.do', {"bookId":bookId}, function(data){
					swal({
						title: data.deleteResult,
						text: "确认后将返回查询页面",
						type: data.deleteResult == "删除成功！" ? "success" : "error",
						showCancelButton: false,
						confirmButtonColor: "#DD6B55",
						confirmButtonText: "确认"
					}).then(function(isConfirm){
						location.href='<%=prefix%>/toQuery.do';
					});
				}, 'json');
			} else {
				
			}
			
		});
		
	}
	
	</script>

</body>
</html>