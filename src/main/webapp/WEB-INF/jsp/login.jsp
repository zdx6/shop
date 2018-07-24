<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>登录</title>
<link rel="icon" href="icon/Panda_48px_501578_easyicon.net.png" type="image/x-icon" />
<link rel="stylesheet" href="dist/css/bootstrap.min.css">
<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
<style type="text/css">
.login {
	top: 100px;
}
</style>
<script type="text/javascript">
	function check() {
		name = $("#name").val();
		psw = $("#psw").val();
		if (name == "" || psw == "") {
			$("#msg").text("账号或密码不能为空！");
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
login {
	text-align: center;
}
</style>
</head>
<body>
		<div class="login col-sm-4 col-sm-offset-4">
			<div class="panel panel-info" style="text-align: center;">
				<form action="${pageContext.request.contextPath }/login" method="post" class="form-horizontal" onsubmit="return check()">
					<div class="panel-heading">
						<div class="form-group has-warning">
							<div class="col-md-offset-3 col-md-6" style="margin-bottom: -10px;">
								<select class="form-control " name="type">
									<option value="0">用户登录</option>
									<option value="1">卖家登录</option>
								</select>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="name" class="control-label glyphicon glyphicon-user col-sm-2"></label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name" placeholder="输入账号" name="name" id="name">
							</div>
						</div>
						<div class="form-group">
							<label for="psw" class="control-label glyphicon glyphicon-lock col-sm-2"></label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="psw" placeholder="输入密码" name="psw" id="psw">
							</div>
						</div>
						<br>
						<span style="color: red;" id="msg">${msg }</span>
						<button class="btn btn-primary" type="submit" style="width: 80px;">登录</button>
						<a href="#">免费注册</a>
					</div>
				</form>
				<div class="panel-foot"></div>
			</div>
		</div>
</body>
</html>