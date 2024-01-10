<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String max = (String)session.getAttribute("max"); 
	String role = (String)session.getAttribute("role");
	String lop = (String)session.getAttribute("lop");
%>
<div>

	<div class="wrap">
	<nav class="nav-scroller">
	  <ul class="primary">
	    <li >
			<a href="/NewsPageMVC">Trang chủ</a>
	    </li>
	    <%if(max!=null)  { %>
	    <li>
	    	<% if(role.equals("sv")) { %>
	    	<a  href="/NewsPageMVC/drl/edit/<%=max %>">Điểm Rèn Luyện</a>
	    	<% }else if(role.equals("gv") || (role.equals("loptruong")))  { %>	    
			<a  href="/NewsPageMVC/drl/list/lop=<%=lop %>">Điểm Rèn Luyện</a>
			<% }else { %>
	    	<a  href="/NewsPageMVC/drl/list/">Điểm Rèn Luyện</a>
	    	<% } %>	
	    </li>
	    <% } %>
	    <li >
			<a  href="/NewsPageMVC/ttcn/list">Thực Tập Chuyên Ngành</a>
	    	<ul class="sub">
	    		<li><a  href="/NewsPageMVC/dttt/list">Đề tài TTCN</a></li>
				<li><a  href="/NewsPageMVC/ttcn/listcd">Đăng kí chờ duyệt</a></li>
				<li><a  href="/NewsPageMVC/ttcn/listkd">Đăng kí không được duyệt</a></li>
	      	</ul>  
	    </li>
	    <li >
			<a  href="/NewsPageMVC/kltn/list">Khóa Luận Tốt Nghiệp</a>
	    	<ul class="sub">
	    		<li><a  href="/NewsPageMVC/dtkl/list">Đề tài KLTN</a></li>
				<li><a  href="/NewsPageMVC/kltn/listcd">Đăng kí chờ duyệt</a></li>
				<li><a  href="/NewsPageMVC/kltn/listkd">Đăng kí không được duyệt</a></li>
	      	</ul>  
	    </li>
	    <%if(role!=null && (role.equals("gv") || role.equals("tldt")))  { %>
	    <li >
			<a  href="/NewsPageMVC/importAcc">Nhập Sinh Viên</a>	
	    </li>
	    <% } %>
	    <%if(role!=null && (role.equals("tldt")))  { %>
	    <li >
			<a  href="/NewsPageMVC/manage">Số liệu</a>	
	    </li>
	    <% } %>
	    <li >
			<a href="/NewsPageMVC/doc/list">Tài liệu</a>
	    </li>
	  </ul>
	</nav>
	</div>
</div>
