<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đề Tài TTCN</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>

<body>
<%
	String max = (String)session.getAttribute("max"); 
%>

    <jsp:include page="_header.jsp" />
    <div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
    <div class="col-md-8 mx-auto border">
	    <div class="bg-light p-3 mb-3"><h4>Thêm đề tài mới</h4></div>
	    
		    <form:form method="post" action="addsave" class="p-3">

			    <div class="mb-3">
				  <label for="tendt" class="form-label">Tên đề tài</label>
				  <form:input class="form-control" placeholder="Tên đề tài" path="tendt" />
				</div>
				<div class="mb-3">
				  <label for="mgv" class="form-label">Mã giảng viên</label>
				  <form:input readonly="true" class="form-control" value="<%=max%>" path="mgv" />
				</div>
<%-- 			    <div class="mb-3">
				  <label for="mgv" class="form-label">Giảng viên</label>
				  <form:select class="form-control"  path="mgv">
				  	<c:forEach items="${gv}" var="gv">
						<option value="${gv.mgv}">${gv.hoten}</option> 
					</c:forEach>
				  </form:select>
				</div> --%>
				<div class="mb-3">
				  <label for="idhk" class="form-label">Học kì</label>
				  <form:select class="form-control"  path="idhk">
					<c:forEach items="${hk}" var="hk">
						<form:option value="${hk.id}">${hk.tenhk}</form:option> 
					</c:forEach>
				  </form:select>
				</div>
				<button type="submit" class="btn btn-primary">Đăng kí</button>
				
			</form:form>
			
		</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>
</html>