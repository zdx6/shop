<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="zdx" uri="http://zdx.com/common/"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>卖家商品</title>
<link rel="icon" href="icon/Panda_48px_501578_easyicon.net.png" type="image/x-icon" />
<link rel="stylesheet" href="dist/css/bootstrap.min.css">
<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	padding-top: 60px;
}

.table tbody tr td, th {
	text-align: center;
	vertical-align: middle;
}
</style>
<script type="text/javascript">
	function createProduct() {
		var formData = new FormData($('#createProductForm')[0]);
		$.ajax({
			url : '${pageContext.request.contextPath }/createProduct.s',
			type : 'post',
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data) {
				if (data == "OK") {
					alert("创建商品成功！");
					window.location.reload();
				} else {
					alert("创建商品失败！");
					window.location.reload();
				}
			}
		});
	}
	function clearCreateProductForm() {
		$("#createProductForm")[0].reset();
	}
	function deleteProduct(id) {
		if (confirm('确实要删除该客户吗?')) {
			$.post("${pageContext.request.contextPath }/deleteProduct.s", 'id='
					+ id, function(data) {
				if (data == "OK") {
					alert("商品删除成功！");
					window.location.reload();
				} else {
					alert("商品删除失败！");
					window.location.reload();
				}
			});
		}
	}
	function editProduct(id) {
		$.ajax({
			type : "get",
			url : "${pageContext.request.contextPath }/getProductById.shop",
			data :'id='+id,		
			dataType:"json",
			contentType:"application/json;charset=UTF-8",
			success : function(data) {
				$("#edit_id").val(data.id);
				$("#edit_shopId").val(data.shopId)
 				$("#edit_productName").val(data.productName);
				$("#edit_type").val(data.type);
				$("#edit_detail").val(data.detail);
				$("#edit_price").val(data.price);
				$("#edit_stock").val(data.stock);
			},
			error: function() {
				alert("error");
			}
		});
	}
	function updateProduct(){
		if(confirm('确实要修改该商品吗?')){
			var formData = new FormData($('#updateProductForm')[0]);
			$.ajax({
				url : '${pageContext.request.contextPath }/updateProduct.shop',
				type : 'post',
				data : formData,
				async : false,
				cache : false,
				contentType : false,
				processData : false,
				success : function(data) {
					if (data == "OK") {
						alert("更新商品成功！");
						window.location.reload();
					} else {
						alert("更新商品失败！");
						window.location.reload();
					}
				}
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
						<img alt="Brand" src="icon/roadside_shop_32px_11353_easyicon.net.png">
					</a>
				</div>
				<p class="navbar-text">欢迎使用</p>
				<button class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addProduct" onclick="clearCreateProductForm()">
					<span class="glyphicon glyphicon-plus"></span>
					添加商品
				</button>
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
			<div class="col-md-12">
				<ul class="nav nav-tabs">
					<li>
						<a href="${pageContext.request.contextPath }/listOrders.s">订单</a>
					</li>
					<li class="active">
						<a href="#">商品</a>
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
							<th>操作</th>
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
									<button class="btn btn-primary" onclick="editProduct(${row.id })" data-toggle="modal" data-target="#updateProductModal">
										<span class="glyphicon glyphicon-pencil"></span>
										修改
									</button>
									<button class="btn btn-danger" onclick="deleteProduct(${row.id })">
										<span class="glyphicon glyphicon-trash"></span>
										删除
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="text-align: center;">
					<zdx:page url="${pageContext.request.contextPath }/listProduct.s"></zdx:page>
				</div>
			</div>
		</div>
		<!-- .row -->
	</div>
	<!-- .container-fluid -->
	<div class="modal fade" id="addProduct">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLable">添加商品</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="createProductForm" enctype="multipart/form-data">
						<div class="form-group">
							<label for="name" class="control-label col-md-3">商品名</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="productName">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">详情</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="detail">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">类别</label>
							<div class="col-md-9">
								<select class="form-control" name="type">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">图片1</label>
							<div class="col-md-9">
								<input type="file" name="image1" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">图片2</label>
							<div class="col-md-9">
								<input type="file" name="image2" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">图片3</label>
							<div class="col-md-9">
								<input type="file" name="image3" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">价格</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="price">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">库存</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="stock">
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
	<!-- #addProduct -->

	<div class="modal fade" id="updateProductModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">更新商品</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="updateProductForm" enctype="multipart/form-data">
						<input type="hidden" name="id" id="edit_id">
						<input type="hidden" name="shopId" id="edit_shopId">
						<div class="form-group">
							<label for="name" class="control-label col-md-3">商品名</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="productName" id="edit_productName">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">详情</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="detail" id="edit_detail">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">类别</label>
							<div class="col-md-9">
								<select class="form-control" name="type" id="edit_type">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">图片1</label>
							<div class="col-md-9">
								<input type="file" name="image1" class="form-control" id="edit_image1" />
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">图片2</label>
							<div class="col-md-9">
								<input type="file" name="image2" class="form-control" id="edit_image2" />
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">图片3</label>
							<div class="col-md-9">
								<input type="file" name="image3" class="form-control" id="edit_image3" />
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">价格</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="price" id="edit_price">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-md-3">库存</label>
							<div class="col-md-9">
								<input type="text" class="form-control" placeholder="" name="stock" id="edit_stock">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" onclick="updateProduct()" data-dismiss="modal">保存</button>
					<button class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<!-- #updateProductModal -->
</body>
</html>