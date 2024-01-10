<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
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
	String role = (String)session.getAttribute("role");
%>
	<jsp:include page="_header.jsp" />
	<div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
   <div class="col-md-12 mx-auto">
   
   <div class="bg-light d-flex justify-content-between align-items-center">
   <h4 class="p-3">Thực tập chuyên ngành</h4>
   <% if( role!=null && role.equals("gv"))  { %>
   	<a class="btn btn-primary" href="/NewsPageMVC/dttt/add">Thêm đề tài mới</a>
   <% } %>
	
   </div>
   <br>
   <br>
	   <table class="table table-striped border">
		  <thead>
		    <tr>
		      <th scope="col">STT</th>
		      <th scope="col">Tên đề tài</th>
		      <th scope="col">Giảng viên hướng dẫn</th>
		      <th scope="col">Bộ môn</th>
		      <th scope="col">Chức năng</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="dttt" items="${list}" varStatus="count"> 
		    <tr>
		      <th scope="row">${count.count}</th>
		      <td class="tdot">${dttt.tendt}</td>
		      <td>${dttt.giangvien.hoten}</td>
		      <td>${dttt.giangvien.bomon}</td>
			   <td>
			   <a class="btn btn-sm btn-outline-primary" href="/NewsPageMVC/dttt/edit/${dttt.mdt}">Sửa</a>
			   <a class="btn btn-sm btn-outline-danger" href="/NewsPageMVC/dttt/delete/${dttt.mdt}">Xóa</a>
			   </td> 
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>
</html>