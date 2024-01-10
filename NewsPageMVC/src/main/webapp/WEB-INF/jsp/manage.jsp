<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lí Hệ Thống</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script>
    function sureToDelete(e){
        if(confirm('Xác nhận sang học kì mới?')){
            return true;
        }else{
            e.preventDefault();
        }
    }
</script>
</head>
<body>

	<jsp:include page="_header.jsp" />
	<div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
   <div class="col-md-12 mx-auto">
   
   <div class="bg-light d-flex justify-content-between float-end">
   <a onclick="sureToDelete(event)" class="btn btn-primary" href="hocki/new">Học kì mới</a>
   </div>
   <br>
   <br>
   <h4 class="p-3">Danh sách đăng kí các học phần TTCN & KLTN</h4>
   		<table class="table table-striped border">
		  <thead>
		    <tr>
		      <th  class="col-3"scope="col">Học phần</th>
		      <th  scope="col">Tổng ĐK</th>
		      <th  scope="col">ĐK chưa duyệt</th>
		      <th  scope="col">ĐK bị từ chối</th>
		      <th  scope="col">ĐK được duyệt</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr >
		      <th  class="tdot">Thực tập chuyên ngành</th>
		      <td class="tdot">${ttcn.ttt}</td>
		      <td class="tdot">${ttcn.ttcd}</td>
		      <td class="tdot">${ttcn.ttkd}</td>
		      <td class="tdot">${ttcn.ttdd}</td>
		    </tr>
		    <tr >
		      <th  class="tdot">Khóa luận tốt nghiệp</th>
		      <td class="tdot">${kltn.tkl}</td>
		      <td class="tdot">${kltn.klcd}</td>
		      <td class="tdot">${kltn.klkd}</td>
		      <td class="tdot">${kltn.kldd}</td>
		    </tr>
		  </tbody>
		</table>
		
	<br>	
   	<h4 class="p-3">Danh sách tình hình đánh giá DRL theo lớp</h4>
   		<table class="table table-striped border">
		  <thead>
		    <tr>
		      <th class="col-2" scope="col">Lớp</th>
		      <th  scope="col">Tổng số SV</th>
		      <th  scope="col">Chưa đánh giá</th>
		      <th  scope="col">Đang chờ LT đánh giá</th>
		      <th  scope="col">Đang chờ GV đánh giá</th>
		      <th  scope="col">Đã hoàn thành đánh giá</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="lop" items="${list}"> 
		    <tr>
		      <th class="tdot">${lop.ten}</th>
		      <td class="tdot">${lop.tong}</td>
		      <td class="tdot">${lop.chuadg}</td>
		      <td class="tdot">${lop.tudg}</td>
		      <td class="tdot">${lop.ltdg}</td>
		      <td class="tdot">${lop.gvdg}</td>
		    </tr>
		  </c:forEach>
		  </tbody>
		</table>
	   
		</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>
</html>