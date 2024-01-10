<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Trang Hướng Nghiệp</title>

	<!-- Bootstrap core CSS -->
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	
	<!-- 
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	-->
	
</head>

<body>
<jsp:include page="_header.jsp" />
<div class="container">
	<jsp:include page="_menu.jsp" />
	
	<h5>result</h5>
	<hr>
	<div class="row mb-2 py-5">
		<c:forEach var="doc" items="${liss}"> 
		<div class="col-12">
			<div class="card flex-md-row mb-4 box-shadow h-md-250">
				<div class="card-body d-flex flex-column align-items-start">
					<a class="text-dark" href="doc/docdetail/${doc.id}"><strong class="d-inline-block mb-2 text-success">
						<h2>${doc.title}</h2>
					</strong></a>
					<p class="noidung card-text mb-auto">${doc.content}</p>
					<p class="ngay mb-auto">${doc.datec}</p>
				</div>
			</div>
		</div>
	</c:forEach>
	</div>
</div>
<jsp:include page="_footer.jsp" />
</body>
</html> --%>