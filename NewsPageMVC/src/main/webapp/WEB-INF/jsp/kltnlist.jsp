<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Khóa Luận Tốt Nghiệp</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<script>
function sureToDelete(e){
    if(confirm('Xác nhận đăng kí KLTN?')){
        return true;
    }else{
        e.preventDefault();
    }
}

$(function() {
  $('#abc').click(function() {
    var url = 'data:application/vnd.ms-excel,' + encodeURIComponent($('#tableWrap').html())
    location.href = url
    return false
  })
});

</script>
</head>
<body>
<%
	String max = (String)session.getAttribute("max"); 
	String role = (String)session.getAttribute("role");
	String duyetkl = (String)session.getAttribute("duyetkl");
%>
	<jsp:include page="_header.jsp" />
	<div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
   <div class="col-md-12 mx-auto">
   
   <div class="bg-light d-flex justify-content-between align-items-center">
   <h4 class="p-3">Danh sách sinh viên đã đăng kí Khóa luân tốt nghiệp</h4>
	   <% if( role!=null && role.equals("gv"))  { %>
   		<a class="btn btn-primary" href="/NewsPageMVC/kltn/list/gv=<%=max%>">SV đăng kí đề tài của bạn</a>
   	   <% } %>
   <% if (role!=null && ( role.equals("sv") || role.equals("loptruong"))) {
    	if (duyetkl!=null && duyetkl.equals("1")) { %>
   			<a class="btn btn-primary" href="edit/<%=max%>">Đơn đăng kí </a>
   		<% }else if(duyetkl==null){ %>
   			<a onclick="sureToDelete(e)" class="btn btn-primary" href="add/<%=max%>">Đăng kí </a>
   		<% }
   } %>
   </div>
      <button class="btn btn-primary float-end"  id="abc">Xuất ra Excel</button>
   <br>
   <br>
   	<div id="tableWrap">
	   <table class="table table-striped border">
		  <thead>
		    <tr>
		      <th scope="col">STT</th>
		      <th scope="col">Họ tên</th>
		      <th scope="col">Mã SV</th>
		      <th scope="col">Lớp</th>
		      <th scope="col">Tên đề tài</th>
		      <th scope="col">Giảng viên hướng dẫn</th>
		      <th scope="col">Cơ sở thực tập</th>
		      <th scope="col">Bộ môn quản lí</th>
		      <% if(role!=null && role.equals("tldt"))  { %>
		      <th scope="col">Chức năng</th>
		      <% } %>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="kltn" items="${list}" varStatus="count"> 
		    <tr>
		      <th scope="row">${count.count}</th>
		      <td >${kltn.sinhvien.hoten}</td>
		      <td class="tdot">${kltn.sinhvien.msv}</td>
		      <td>${kltn.sinhvien.lop}</td>
		      <td >${kltn.dtkl.tendt}</td>
		      <td>${kltn.dtkl.giangvien.hoten}</td>
		      <td>${kltn.cstt}</td>
		      <td>${kltn.dtkl.giangvien.bomon}</td>
			  <% if(role!=null && role.equals("tldt"))  { %>
			  <td>			  
			   <a class="btn btn-sm btn-outline-primary" href="duyet/${kltn.msv}">Xét duyệt</a>			   
			  </td> 
			  <% } %>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
	</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>
</html>