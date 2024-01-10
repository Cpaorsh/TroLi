<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thực Tập Chuyên Ngành</title>

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
	    <div class="bg-light p-3 mb-3"><h4>Xét duyệt đơn đăng kí</h4></div>
	    
		    <form:form method="post" action="/NewsPageMVC/ttcn/duyetsave" class="p-3">
				
				<div class="mb-3">
				  <label for="msv" class="form-label">MSV</label>
				  <form:input readonly="true" class="form-control"  path="msv" />
				</div>
				<div class="mb-3">
				  <label for="duyet" class="form-label">Duyệt</label><br>
				  <form:radiobutton path="duyet" value="2" />Từ chối
				  <form:radiobutton path="duyet" value="1" />Duyệt
				</div>	
				<div class="mb-3">
				  <label for="lidotc" class="form-label">Lí do từ chối (nếu có)</label>
				  <form:textarea class="form-control"  path="lidotc" />
				</div>				
				<button type="submit" class="btn btn-primary">Cập nhật</button>
				
			</form:form>
			
		</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>

</html>