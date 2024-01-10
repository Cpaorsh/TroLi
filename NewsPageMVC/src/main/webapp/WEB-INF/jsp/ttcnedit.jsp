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
<%
	String max = (String)session.getAttribute("max"); 
%>
    <jsp:include page="_header.jsp" />
    <div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
    <div class="col-md-8 mx-auto border">
	    <div class="bg-light p-3 mb-3"><h4>Chỉnh sửa, bổ sung đơn đăng kí</h4></div>
	    
		    <form:form method="post" action="/NewsPageMVC/ttcn/editsave" class="p-3">
				
				<div class="mb-3">
				  <label for="msv" class="form-label">MSV</label>
				  <form:input readonly="true" class="form-control"  path="msv" />
				</div>

			    <div class="mb-3">
				  <label for="mdt" class="form-label">Đề tài</label>
				  <form:select class="form-control"  path="mdt">
				  	<c:forEach items="${dt}" var="dt">
						<form:option value="${dt.mdt}">${dt.tendt}</form:option> 
					</c:forEach>
				  </form:select>
				</div>	
				<div class="mb-3">
				  <label for="cstt" class="form-label">Cơ sở thực tập</label>
				  <form:textarea class="form-control"  path="cstt" />
				</div>				
				<button type="submit" class="btn btn-primary">Cập nhật</button>
				
			</form:form>
			 <a class="btn btn-primary" href="/NewsPageMVC/ttcn/delete/<%=max%>">Hủy đăng kí </a>
		</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>

</html>