<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="zdx" uri="http://zdx.com/common/"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>商品</title>
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
function getAddress(productId) {
	$("#chooseAddressForm").empty();
	$("#buyButton").attr("onclick","buyProduct('"+productId+"')")
	$.get("${pageContext.request.contextPath}/listUserAddress.u",function(data){
		$.each(data,function(i,item){
			$("#chooseAddressForm").append("<div class='radio'>"+
					"<label><input type='radio' name='addressId' value='"+item.id+"'>"+
					item.receiverName+"  "+item.phone+"  "+item.address+"</label>"+
					"</div>");
		});
	});
}
function buyProduct(productId) {
	if(confirm("确定购买该商品吗？")){
		addressId=$('input:radio[name="addressId"]:checked').val();
		$.post("${pageContext.request.contextPath}/buyProduct.u",{"productId":productId,"addressId":addressId},function(data){
			alert(data.stateInfo);
			location.reload();
		});
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
					<li class="active">
						<a href="#">商品</a>
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
							<th>商品号</th>
							<th>商品名</th>
							<th>详情</th>
							<th>价格</th>
							<th>库存</th>
							<th>类别</th>
							<th>图片1</th>
							<th>图片2</th>
							<th>图片3</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.rows }" var="row">
							<tr>
								<td>${row.id }</td>
								<td>${row.productName }</td>
								<td>${row.detail}</td>
								<td>${row.price }</td>
								<td>${row.stock }</td>
								<td>${row.type }</td>
								<td>
									<img src="${row.img1 }" width="100" height="100" />
								</td>
								<td>
									<img src="${row.img2 }" width="100" height="100" />
								</td>
								<td>
									<img src="${row.img3 }" width="100" height="100" />
								</td>
								<td>
									<button class="btn btn-primary" onclick="getAddress(${row.id })" data-toggle="modal" data-target="#chooseAddressModal">购买</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="text-align: center;">
					<zdx:page url="${pageContext.request.contextPath }/listProduct.u"></zdx:page>
				</div>
			</div>
		</div>
		<!-- .row -->
	</div>
	<!-- .container -->

	<div class="modal fade" id="chooseAddressModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">地址选择</h4>
				</div>
				<div class="modal-body">
					<form action="" id="chooseAddressForm" class="form-horizontal"></form>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" onclick="" data-dismiss="modal" id="buyButton">确定</button>
					<button class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>