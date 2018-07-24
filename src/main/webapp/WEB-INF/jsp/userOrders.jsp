<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="zdx" uri="http://zdx.com/common/"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>用户订单</title>
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
</head>
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-sm-12">
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
			<!-- .col-sm-12 -->
		</div>
		<!-- .row -->
		<div class="row">
			<div class="col-sm-12">
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#">订单</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath }/listProduct.u">商品</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath }/listAddress.u">地址</a>
					</li>
					<li>
						<a href="#">消息</a>
					</li>
				</ul>
				<table class="table table-hover table-striped table-bordered">
					<thead>
						<tr class="info">
							<th>下单时间</th>
							<th>订单号</th>
							<th>商品号</th>
							<th>商品名</th>
							<th>价格</th>
							<th>店铺账号</th>
							<th>店铺名</th>
							<th>支付金额</th>
							<th>收货人</th>
							<th>电话</th>
							<th>地址</th>
							<th>状态</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.rows }" var="row">
							<tr>
								<td>${row.orderCreateTime }</td>
								<td>${row.id }</td>
								<td>${row.productId }</td>
								<td>${row.product.productName }</td>
								<td>${row.product.price }</td>
								<td>${row.shop.loginName }</td>
								<td>${row.shop.shopName }</td>
								<td>${row.payment }</td>
								<td>${row.address.receiverName }</td>
								<td>${row.address.phone }</td>
								<td>${row.address.address }</td>
								<td>${row.state }</td>
								<td>
									<button class="btn btn-primary">确认收货</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="text-align: center;">
					<zdx:page url="${pageContext.request.contextPath }/listOrders.u"></zdx:page>
				</div>
			</div>
		</div>
		<!-- .row -->
	</div>
	<!-- .container -->
</body>
</html>