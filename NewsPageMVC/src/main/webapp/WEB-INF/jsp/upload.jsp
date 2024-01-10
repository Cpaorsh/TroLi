<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách SV</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>

<body>
    <jsp:include page="_header.jsp" />
    <div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
 
	<h1>Tải lên danh sách sinh viên</h1>
	<br>
 
	<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
		<input type="file" name="file" /> 
		<input type="submit" value="Submit" />
	</form>
  
  	<br>
	<h2>Tình trạng: ${message}</h2>

	</div>
	<jsp:include page="_footer.jsp" />
</body>
</html>