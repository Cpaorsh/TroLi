<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	    <div class="bg-light p-3 mb-3"><h4>Thêm tài liệu mới</h4></div>
	    
		    <form:form method="post" action="addsave" class="p-3" enctype="multipart/form-data">
			    <div class="mb-3">
				  <label for="title" class="form-label">Tên tài liệu</label>
				  <form:input class="form-control" placeholder="Page Title" path="title" />
				</div>
				<div class="mb-3">
				  <label for="filed" class="form-label">Upload file</label>
				  <form:input type="file"  path="filed" />
				</div>
				<button type="submit" class="btn btn-primary">Thêm</button>		
			</form:form>
			
		</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>
</html>