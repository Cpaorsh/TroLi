<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String max = (String)session.getAttribute("max"); 
	String role = (String)session.getAttribute("role");
	String lop = (String)session.getAttribute("lop");
%>

<header class="blog-header py-3">
	<div class="row flex-nowrap justify-content-between align-items-center">
		<!-- <div class="col-4 pt-1">
		<a class="text-muted" href="/NewsPageMVC/subscribe">Subscribe</a>
		</div> -->
		
		<div class="col-10 text-start d-none d-md-flex">
			<img class="col-3" src="/NewsPageMVC/resources/img/vnua.png" alt="hahah" style="width:7vw; height:7vw;">
			<div class="col-5 text-center">
				<a class="blog-header-logo text-white" href="/NewsPageMVC"><b>KHOA CÔNG NGHỆ THÔNG TIN</b></a>
				<p class="text-success">Trang hỗ trợ đào tạo</p>
			</div>
			<img class="col-3" src="/NewsPageMVC/resources/img/fita.png" alt="hahah" style="width:7vw">
			
		</div>
		
		<div class="col-8 text-start d-md-none">
			<label  for="toggle">&#9776;</label>
		    <input type="checkbox" id="toggle"/>
		
			<div class="wrapp">
			<nav class="nav-scroller">
			  <ul class="primary">
			  	<li>
			  		<label class="d-md-none text-primary" for="toggle">&#9747;</label>
			    	<input type="checkbox" id="toggle"/>
			  	</li>
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

		<div class="col-2 d-flex justify-content-end align-items-center">	   
			<%String username = (String)session.getAttribute("username"); if(username==null) {%>            
				<a class="btn btn-sm btn-outline-secondary me-2" href="/NewsPageMVC/login">Login</a>
			<%}else {%>
		    	<div class="dropdown">
				  <span class="text-white"> Welcome <%= session.getAttribute("name") %> </span>
				  <div class="dropdown-content">
				  	<!-- <a class="btn btn-sm btn-outline-secondary me-2" href="#">Password</a> -->
				  	<a class="btn btn-sm btn-outline-secondary me-2" href="/NewsPageMVC/login">Logout</a>
				  </div>
				</div>
		    <% } %>
    		<%-- <a class="text-muted" href="#">
			<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
			stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3">
			<circle cx="10.5" cy="10.5" r="7.5"></circle>
			<line x1="21" y1="21" x2="15.8" y2="15.8"></line>
			</svg>
			</a> --%>
		</div> 
	</div>
	
	<span class="lineleft"></span>
    <span class="lineright"></span>
</header>


