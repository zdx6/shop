<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="zdx" uri="http://zdx.com/common/"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>地址</title>
<link rel="icon" href="icon/Panda_48px_501578_easyicon.net.png" type="image/x-icon" />
<link rel="stylesheet" href="dist/css/bootstrap.min.css">
<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	padding-top: 60px;
}

td, th {
	text-align: center;
}
</style>
<script type="text/javascript">
function editUpdateAddressForm(id) {
	$.ajax({
		type : "get",
		url : "${pageContext.request.contextPath }/getAddressById.u",
		data :'id='+id,		
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success : function(data) {
 		 	$("#edit_id").val(data.id);
 		 	$("#edit_userId").val(data.userId);
			$("#edit_receiverName").val(data.receiverName);
			$("#edit_phone").val(data.phone);
			$("#edit_address").val(data.address);
		},
		error: function() {
			alert("error");
		}
	});
}
function updateAddress() {
	if(confirm("确定修改该地址？")){
		$.post("${pageContext.request.contextPath }/updateAddress.u",$("#updateAddressForm").serialize(),function(data){
			if(data=="OK")
				alert("修改地址成功！");
			else
				alert("修改地址失败！");
			window.location.reload();
		})
	}
}
function createProduct() {
	$.post("${pageContext.request.contextPath }/createAddress.u",$("#createAddressForm").serialize(),function(data){
		if(data=="OK")
			alert("添加地址成功！");
		else
			alert("添加地址失败！");
		window.location.reload();
	})
}
function deleteAddress(id) {
	if(confirm("确认删除该地址？")){
		$.post("${pageContext.request.contextPath }/deleteAddress.u",'id='+id,function(data){
			if(data=="OK")
				alert("删除地址成功！");
			else
				alert("删除地址失败！");
			window.location.reload();
		})
	}
}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">
						<img alt="Brand" src="icon/Shopping_31.93754066363px_1180760_easyicon.net.png">
					</a>
				</div>
				<form class="navbar-form navbar-left" action="${pageContext.request.contextPath }/listProduct.u">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="输入商品名" name="pname">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
				<p class="navbar-text">欢迎使用</p>
				<a href="${pageContext.request.contextPath }/logout" class="btn btn-default navbar-btn">
					<span class="glyphicon glyphicon-off"></span>
					退出
				</a>
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<span class="glyphicon glyphicon-cog"></span>
							设置
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="#">修改密码</a>
							</li>
							<li>
								<a href="#">个人信息</a>
							</li>
							<li>
								<a href="#">地址管理</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#">意见反馈</a>
							</li>
						</ul>
					</li>
				</ul>
				<p class="navbar-text navbar-right" style="margin-right: 20px;">当前用户：（${USER_SESSION.loginName }）${USER_SESSION.nickName }</p>
			</nav>
		</div>
		<!-- .row -->
		<div class="row">
			<div class="col-sm-12">
				<ul class="nav nav-tabs">
					<li>
						<a href="${pageContext.request.contextPath }/listOrders.u">订单</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath }/listProduct.u">商品</a>
					</li>
					<li class="active">
						<a href="#">地址</a>
					</li>
					<li>
						<a href="#">消息</a>
					</li>
				</ul>
				<table class="table table-hover table-striped table-bordered">
					<thead>
						<tr class="info">
							<th>收货人名</th>
							<th>联系电话</th>
							<th>地址详情</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${addresses }" var="address">
							<tr>
								<td>${address.receiverName }</td>
								<td>${address.phone }</td>
								<td>${address.address }</td>
								<td>
									<button class="btn btn-primary" data-toggle="modal" data-target="#updateAddressModal"
										onclick="editUpdateAddressForm(${address.id })">
										<span class="glyphicon glyphicon-pencil"></span>
										修改
									</button>
									<button class="btn btn-danger" onclick="deleteAddress(${address.id })">
										<span class="glyphicon glyphicon-trash"></span>
										删除
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="text-align: center;">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createAddressModal">
						<span class="glyphicon glyphicon-plus"></span>
						添加地址
					</button>
				</div>
			</div>
		</div>
		<!-- .row -->
	</div>
	<!-- .container -->

	<div class="modal fade" id="createAddressModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">添加地址</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="createAddressForm">
						<div class="form-group">
							<label for="name" class="control-label col-md-3">收货人名</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="receiverName">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">联系电话</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="phone">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">地址详情</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="address">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" onclick="createProduct()" data-dismiss="modal">添加</button>
					<button class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="updateAddressModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">修改地址</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="updateAddressForm">
						<input type="hidden" name="id" id="edit_id">
						<input type="hidden" name="userId" id="edit_userId">
						<div class="form-group">
							<label for="name" class="control-label col-md-3">收货人名</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="receiverName" id="edit_receiverName">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">联系电话</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="phone" id="edit_phone">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">地址详情</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="address" id="edit_address">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" onclick="updateAddress()" data-dismiss="modal">保存</button>
					<button class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
</body>