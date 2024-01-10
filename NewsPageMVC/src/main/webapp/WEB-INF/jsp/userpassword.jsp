<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tài liệu</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>

<body>
    <jsp:include page="_header.jsp" />
    <div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
    <div class="col-md-8 mx-auto border">
	    <div class="bg-light p-3 mb-3"><h4>Chỉnh sửa tài liệu</h4></div>
	    
		    <form:form method="post" action="edit" class="p-3" enctype="multipart/form-data">
				
				<p>
					<label for="user_login">Tài khoản </label>
					<form:input path="username" type="text" name="log" id="user_login" class="input" size="20" autocapitalize="off"/>
				</p>
				
			<div class="user-pass-wrap">
				<label for="user_pass">Mật khẩu mới</label>
				<div class="wp-pwd">
					<form:input path="password" type="password" name="pwd" id="user_pass" class="input password-input" size="20"/>
				</div>
				
				<label for="user_pass">Nhập lại Mật khẩu mới</label>
				<div class="wp-pwd">
					<form:input  type="password" name="pwd" id="user_pass" class="input password-input" size="20"/>
				</div>
			</div>
				
				<button type="submit" class="btn btn-primary">Cập nhật</button>
				
			</form:form>
			
		</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>

</html> --%>