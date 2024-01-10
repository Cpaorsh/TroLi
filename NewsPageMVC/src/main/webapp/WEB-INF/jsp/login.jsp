<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body class="loginpage">

	<div class="login">
		<div class="login-logo" style="text-align: center;">
	        <img style="height: 84px;" src="/NewsPageMVC/resources/img/vnua.png" >
	    </div>

		<form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
			<p>
				<label for="user_login">Tài khoản </label>
				<form:input path="username" type="text" name="log" id="user_login" class="input" placeholder="Mã sinh/giảng viên,  VD: 643000" size="20" autocapitalize="off"/>
			</p>
			<div class="user-pass-wrap">
				<label for="user_pass">Mật khẩu</label>
				<div class="wp-pwd">
					<form:input path="password" type="password" name="pwd" id="user_pass" class="input password-input" placeholder="Ngày sinh (định dạng: dd/mm/yy) VD: 21/03/01" size="20"/>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Đăng nhập</button>			
		</form:form>
		<br>
		<p id="backtoblog"><a class="text-dark" href="/NewsPageMVC">&larr; Trở lại trang chủ</a></p>
		<p style="font-style:italic; font-size:1.3vw; color:red;">${message}</p>
	</div>
	
</body>
</html>
