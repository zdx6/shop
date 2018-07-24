<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="zdx" uri="http://zdx.com/common/"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>卖家订单</title>
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
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">
						<img alt="Brand" src="icon/roadside_shop_32px_11353_easyicon.net.png">
					</a>
				</div>
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
								<a href="#">店铺信息</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#">意见反馈</a>
							</li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
		<!-- .row -->
		<div class="row">
			<div class="col-sm-12">
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#">订单</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath }/listProduct.s">商品</a>
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
							<th>用户账号</th>
							<th>用户名</th>
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
								<td>${row.user.loginName }</td>
								<td>${row.user.nickName }</td>
								<td>${row.payment }</td>
								<td>${row.address.receiverName }</td>
								<td>${row.address.phone }</td>
								<td>${row.address.address }</td>
								<td>${row.state }</td>
								<td>
									<button class="btn btn-primary">发货</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="text-align: center;">
					<zdx:page url="${pageContext.request.contextPath }/listOrders.s"></zdx:page>
				</div>
			</div>
		</div>
		<!-- .row -->
	</div>
	<!-- .container -->
</body>
</html>