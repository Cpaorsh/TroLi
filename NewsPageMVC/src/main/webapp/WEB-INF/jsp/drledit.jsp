<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Điểm rèn luyện</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<% 
String rolea = (String)session.getAttribute("role");
String max = (String)session.getAttribute("max");
String blockG = "blocli";
String blockL = "blocli";
String blockS = "blocli";
String url = (String)request.getAttribute("javax.servlet.forward.request_uri");
url = url.substring(url.lastIndexOf("/") + 1);
if(rolea!=null){
	if(max.equals(url)) {
		blockS = "fail";
	}if(rolea.equals("loptruong"))  {
		blockL = "fail";
	}if(rolea.equals("gv")){
		blockG = "fail";
	}
}
request.setAttribute("blockG", blockG);
request.setAttribute("blockL", blockL);
request.setAttribute("blockS", blockS);

%>
</head>
<body>

	<jsp:include page="_header.jsp" />
	<div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
   <div class="col-md-12 mx-auto">
   
   <div class="bg-light d-flex justify-content-between align-items-center">
   <h4 class="p-3">Đánh giá điểm rèn luyện</h4>
   </div>
   <br>
   <br>

<table id="fixedheight"><tr>
	
    <td class="col-6">
      <table>
        <tr><th>Hạng mục</th></tr>
        <tr><td><label class="form-control alwa"></label></td></tr>
        <tr><td><label class="form-control ">1.1. Ý thức và thái độ học tập</label></td></tr>
        <tr><td><label class="form-control ">1.2.Tham gia CLB học thuật</label></td></tr>
        <tr><td><label class="form-control ">1.3. Tham gia các kỳ thi, nghiêm túc, đúng quy chế, quy định</label></td></tr>
        <tr><td><label class="form-control ">1.4. Tinh thần vượt khó</label></td></tr>
        <tr><td><label class="form-control ">1.5. Học tập</label></td></tr>
        <tr><td><label class="form-control ">1.6. Thi sinh viên giỏi và NCKH</label></td></tr>
        <tr><td><label class="form-control ">2. Ý thức và kết quả chấp hành nội quy, quy chế trong nhà trường</label></td></tr>
        <tr><td><label class="form-control ">3. Ý thức và kết quả tham gia các hoạt động chính trị - xã hội, văn hóa - văn nghệ, thể thao, phòng chống các tệ nạn xã hội</label></td></tr>
        <tr><td><label class="form-control ">4.1. Ý thức chấp hành và tham gia tuyên truyền các chủ trương của Đảng, chính sách, pháp luật của Nhà nước và cộng đồng</label></td></tr>
        <tr><td><label class="form-control ">4.2. Ý thức tham gia các hoạt động xã hội có thành tích được ghi nhận, biểu dương khen thưởng</label></td></tr>
        <tr><td><label class="form-control ">4.3. Có tinh thần chia sẻ, giúp đỡ người thân, người có khó khăn, hoạn nạn</label></td></tr>
        <tr><td><label class="form-control ">5. Ý thức tham gia công tác lớp, đoàn, Hội SV, các tổ chức khác</label></td></tr>
      </table>
    </td>
    

    <td class="col-2">
      <table>
      <form:form method="post" action="/NewsPageMVC/drl/savesv" class="p-3">
        <tr><th>Tự Chấm</th></tr>
        <tr><td>
        	<form:input readonly="true" class="form-control alwa ${blockS}" placeholder="Msv" path="msv" />
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Ythuc" path="ythuc">
			  	<form:option value="4">Đúng giờ, đủ giờ, nghiêm túc, không nói chuyện, làm việc không liên quan đến môn học, có thức thức XD bài, chuẩn bị bài đầy đủ... </form:option>
   				<form:option value="2">Có ý thức nhưng chưa thật đầy đủ</form:option>
   				<form:option value="0">Ý thức yếu, kém</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Clbhoc" path="clbhoc">
   				<form:option value="2">Có tham gia </form:option>
   				<form:option value="0">Không tham gia </form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Quyche" path="quyche">
   				<form:option value="2">Có</form:option>
   				<form:option value="0">Không</form:option>   				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Vuotkho" path="vuotkho">
   				<form:option value="2">Có</form:option>
   				<form:option value="0">Không</form:option>  				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Hoctap" path="hoctap">
   				<form:option value="8">Điểm TBCHT học kỳ từ 3,60 đến 4,00 </form:option>
   				<form:option value="6">Điểm TBCHT học kỳ từ 3,20 đến 3,59 </form:option>
   				<form:option value="4">Điểm TBCHT học kỳ từ 2,50 đến 3,19 </form:option>
   				<form:option value="2">Điểm TBCHT học kỳ từ 2,00 đến 2,49</form:option>
   				<form:option value="1">Điểm TBCHT học kỳ từ 1,00 đến 1,99 </form:option>
   				<form:option value="0">Điểm TBCHT học kỳ <1,00 (0)</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Tsvgioi" path="tsvgioi">
   				<form:option value="2">Sinh viên Thi Olympic, Thi sinh viên giỏi, NCKH đạt giải cấp khoa trở lên</form:option>
   				<form:option value="1">Sinh viên Thi Olympic, Thi sinh viên giỏi, tham gia NCKH, Không đạt giải</form:option> 
   				<form:option value="0">Sinh viên không tham gia </form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Kqchaphanh" path="kqchaphanh">
   				<form:option value="25">Thực hiện tốt các nội quy quy chế </form:option>
   				<form:option value="15">Nộp học phí, đoàn phí không đúng kỳ hạn</form:option>
   				<form:option value="10">Vi phạm nội quy, quy chế</form:option>
   				<form:option value="0">Vi phạm quy chế thi và kiểm tra; không đóng học phí học kỳ; Không hoàn thành nghĩa vụ công lao động sinh viên</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Tgngoaikhoa" path="tgngoaikhoa">
   				<form:option value="20">Tham gia đầy đủ các hoạt động và được khen thưởng của các tổ chức Đoàn, HSV, Hội liên hiệp thanh niên, được khen thưởng Cấp khoa trở lên</form:option>
   				<form:option value="18">Tham gia đầy đủ các hoạt động</form:option>
   				<form:option value="10">Tham gia không đầy đủ</form:option>
   				<form:option value="5">Tham gia đầy đủ tuần SHCD - SV đầu năm nhưng bài thu hoạch không đạt</form:option>
   				<form:option value="0">Không tham gia các hoạt động</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Dangnn" path="dangnn">
   				<form:option value="15">Tích cực tham gia tuyên truyền và chấp hành tốt pháp luật, được lớp và CĐ tín nhiệm có ý thức tập thể tốt (có >=70% số SV trong lớp biểu quyết đồng ý)</form:option>
   				<form:option value="10">Tích cực tham gia tuyên truyền và chấp hành tốt pháp luật, được lớp và CĐ tín nhiệm có ý thức tập thể tốt (có 30%-69% số SV trong lớp biểu quyết đồng ý)</form:option>
   				<form:option value="5">Tích cực tham gia tuyên truyền và chấp hành tốt pháp luật, được lớp và CĐ tín nhiệm có ý thức tập thể tốt (có <30% số SV trong lớp biểu quyết đồng ý) </form:option>
   				<form:option value="0">Vi phạm khuyết điểm, gây mất đoàn kết</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Bieuduong" path="bieuduong">
   				<form:option value="5">Có</form:option>
   				<form:option value="0">Không</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Giupdo" path="giupdo">
   				<form:option value="5">Có</form:option>
   				<form:option value="0">Không</form:option>   				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockS}" placeholder="Tgdoanhoi" path="tgdoanhoi">
   				<form:option value="10">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên mà TT đó được khen</form:option>
   				<form:option value="9">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên</form:option> 
   				<form:option value="5">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên mà lớp có sai phạm nhưng chưa bị thi hành kỷ luật</form:option> 
   				<form:option value="0">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên mà lớp có sai phạm, bị phê bình từ cấp Khoa trở lên</form:option> 
   				<form:option value="9">Đội TNXK; TNTN thường trực; đội Văn nghệ; Thể thao; thành viên CLB SV có Quyết định của Trường, Khoa trở lên được khen thưởng</form:option> 
   				<form:option value="5">Đội TNXK; TNTN thường trực; đội Văn nghệ, Thể thao; thành viên CLB SV có Quyết định của Trường, Khoa trở lên</form:option>
   				<form:option value="0">Không tham gia</form:option>     				
			</form:select>
        </td></tr>
        <tr><td><button type="submit" class="col-12 btn  ${blockS}">Cập nhật</button></td></tr>
      </form:form>
      </table>
    </td>
    
    <!-- lop truong -->
	<td class="col-2">
      <table>
      <form:form method="post" action="/NewsPageMVC/drl/savelt" class="p-3">      
        <tr><th>L/Trưởng</th></tr>
        <tr><td>
        	<form:input readonly="true" class="form-control alwa ${blockL}" placeholder="Msv" path="msv"/>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Ltythuc" path="ltythuc">
			  	<form:option value="4">Đúng giờ, đủ giờ, nghiêm túc, không nói chuyện, làm việc không liên quan đến môn học, có thức thức XD bài, chuẩn bị bài đầy đủ... </form:option>
   				<form:option value="2">Có ý thức nhưng chưa thật đầy đủ</form:option>
   				<form:option value="0">Ý thức yếu, kém</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Ltclbhoc" path="ltclbhoc">
   				<form:option value="2">Có tham gia </form:option>
   				<form:option value="0">Không tham gia </form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Ltquyche" path="ltquyche">
   				<form:option value="2">Có</form:option>
   				<form:option value="0">Không</form:option>   				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Ltvuotkho" path="ltvuotkho">
   				<form:option value="2">Có</form:option>
   				<form:option value="0">Không</form:option>  				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Lthoctap" path="lthoctap">
   				<form:option value="8">Điểm TBCHT học kỳ từ 3,60 đến 4,00 </form:option>
   				<form:option value="6">Điểm TBCHT học kỳ từ 3,20 đến 3,59 </form:option>
   				<form:option value="4">Điểm TBCHT học kỳ từ 2,50 đến 3,19 </form:option>
   				<form:option value="2">Điểm TBCHT học kỳ từ 2,00 đến 2,49</form:option>
   				<form:option value="1">Điểm TBCHT học kỳ từ 1,00 đến 1,99 </form:option>
   				<form:option value="0">Điểm TBCHT học kỳ <1,00 (0)</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Lttsvgioi" path="lttsvgioi">
   				<form:option value="2">Sinh viên Thi Olympic, Thi sinh viên giỏi, NCKH đạt giải cấp khoa trở lên</form:option>
   				<form:option value="1">Sinh viên Thi Olympic, Thi sinh viên giỏi, tham gia NCKH, Không đạt giải</form:option> 
   				<form:option value="0">Sinh viên không tham gia </form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Ltkqchaphanh" path="ltkqchaphanh">
   				<form:option value="25">Thực hiện tốt các nội quy quy chế </form:option>
   				<form:option value="15">Nộp học phí, đoàn phí không đúng kỳ hạn</form:option>
   				<form:option value="10">Vi phạm nội quy, quy chế</form:option>
   				<form:option value="0">Vi phạm quy chế thi và kiểm tra; không đóng học phí học kỳ; Không hoàn thành nghĩa vụ công lao động sinh viên</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Lttgngoaikhoa" path="lttgngoaikhoa">
   				<form:option value="20">Tham gia đầy đủ các hoạt động và được khen thưởng của các tổ chức Đoàn, HSV, Hội liên hiệp thanh niên, được khen thưởng Cấp khoa trở lên</form:option>
   				<form:option value="18">Tham gia đầy đủ các hoạt động</form:option>
   				<form:option value="10">Tham gia không đầy đủ</form:option>
   				<form:option value="5">Tham gia đầy đủ tuần SHCD - SV đầu năm nhưng bài thu hoạch không đạt</form:option>
   				<form:option value="0">Không tham gia các hoạt động</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Ltdangnn" path="ltdangnn">
   				<form:option value="15">Tích cực tham gia tuyên truyền và chấp hành tốt pháp luật, được lớp và CĐ tín nhiệm có ý thức tập thể tốt (có >=70% số SV trong lớp biểu quyết đồng ý)</form:option>
   				<form:option value="10">Tích cực tham gia tuyên truyền và chấp hành tốt pháp luật, được lớp và CĐ tín nhiệm có ý thức tập thể tốt (có 30%-69% số SV trong lớp biểu quyết đồng ý)</form:option>
   				<form:option value="5">Tích cực tham gia tuyên truyền và chấp hành tốt pháp luật, được lớp và CĐ tín nhiệm có ý thức tập thể tốt (có <30% số SV trong lớp biểu quyết đồng ý) </form:option>
   				<form:option value="0">Vi phạm khuyết điểm, gây mất đoàn kết</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Ltbieuduong" path="ltbieuduong">
   				<form:option value="5">Có</form:option>
   				<form:option value="0">Không</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Ltgiupdo" path="ltgiupdo">
   				<form:option value="5">Có</form:option>
   				<form:option value="0">Không</form:option>   				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockL}" placeholder="Lttgdoanhoi" path="lttgdoanhoi">
   				<form:option value="10">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên mà TT đó được khen</form:option>
   				<form:option value="9">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên</form:option> 
   				<form:option value="5">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên mà lớp có sai phạm nhưng chưa bị thi hành kỷ luật</form:option> 
   				<form:option value="0">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên mà lớp có sai phạm, bị phê bình từ cấp Khoa trở lên</form:option> 
   				<form:option value="9">Đội TNXK; TNTN thường trực; đội Văn nghệ; Thể thao; thành viên CLB SV có Quyết định của Trường, Khoa trở lên được khen thưởng</form:option> 
   				<form:option value="5">Đội TNXK; TNTN thường trực; đội Văn nghệ, Thể thao; thành viên CLB SV có Quyết định của Trường, Khoa trở lên</form:option>
   				<form:option value="0">Không tham gia</form:option>     				
			</form:select>
        </td></tr>
        <tr><td><button type="submit" class="col-12 btn  ${blockL}">Cập nhật</button></td></tr>         
      </form:form>
      </table>
    </td> 
    
       
    
    <!-- giao vien -->
    <td class="col-2">
      <table>
      <form:form method="post" action="/NewsPageMVC/drl/savegv" class="p-3">
        <tr><th>Giáo viên</th></tr>
        <tr><td>
        	<form:input readonly="true" class="form-control alwa ${blockG}" placeholder="Msv" path="msv" />
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvythuc" path="gvythuc">
			  	<form:option value="4">Đúng giờ, đủ giờ, nghiêm túc, không nói chuyện, làm việc không liên quan đến môn học, có thức thức XD bài, chuẩn bị bài đầy đủ... </form:option>
   				<form:option value="2">Có ý thức nhưng chưa thật đầy đủ</form:option>
   				<form:option value="0">Ý thức yếu, kém</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvclbhoc" path="gvclbhoc">
   				<form:option value="2">Có tham gia </form:option>
   				<form:option value="0">Không tham gia </form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvquyche" path="gvquyche">
   				<form:option value="2">Có</form:option>
   				<form:option value="0">Không</form:option>   				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvvuotkho" path="gvvuotkho">
   				<form:option value="2">Có</form:option>
   				<form:option value="0">Không</form:option>  				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvhoctap" path="gvhoctap">
   				<form:option value="8">Điểm TBCHT học kỳ từ 3,60 đến 4,00 </form:option>
   				<form:option value="6">Điểm TBCHT học kỳ từ 3,20 đến 3,59 </form:option>
   				<form:option value="4">Điểm TBCHT học kỳ từ 2,50 đến 3,19 </form:option>
   				<form:option value="2">Điểm TBCHT học kỳ từ 2,00 đến 2,49</form:option>
   				<form:option value="1">Điểm TBCHT học kỳ từ 1,00 đến 1,99 </form:option>
   				<form:option value="0">Điểm TBCHT học kỳ <1,00 (0)</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvtsvgioi" path="gvtsvgioi">
   				<form:option value="2">Sinh viên Thi Olympic, Thi sinh viên giỏi, NCKH đạt giải cấp khoa trở lên</form:option>
   				<form:option value="1">Sinh viên Thi Olympic, Thi sinh viên giỏi, tham gia NCKH, Không đạt giải</form:option> 
   				<form:option value="0">Sinh viên không tham gia </form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvkqchaphanh" path="gvkqchaphanh">
   				<form:option value="25">Thực hiện tốt các nội quy quy chế </form:option>
   				<form:option value="15">Nộp học phí, đoàn phí không đúng kỳ hạn</form:option>
   				<form:option value="10">Vi phạm nội quy, quy chế</form:option>
   				<form:option value="0">Vi phạm quy chế thi và kiểm tra; không đóng học phí học kỳ; Không hoàn thành nghĩa vụ công lao động sinh viên</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvtgngoaikhoa" path="gvtgngoaikhoa">
   				<form:option value="20">Tham gia đầy đủ các hoạt động và được khen thưởng của các tổ chức Đoàn, HSV, Hội liên hiệp thanh niên, được khen thưởng Cấp khoa trở lên</form:option>
   				<form:option value="18">Tham gia đầy đủ các hoạt động</form:option>
   				<form:option value="10">Tham gia không đầy đủ</form:option>
   				<form:option value="5">Tham gia đầy đủ tuần SHCD - SV đầu năm nhưng bài thu hoạch không đạt</form:option>
   				<form:option value="0">Không tham gia các hoạt động</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvdangnn" path="gvdangnn">
   				<form:option value="15">Tích cực tham gia tuyên truyền và chấp hành tốt pháp luật, được lớp và CĐ tín nhiệm có ý thức tập thể tốt (có >=70% số SV trong lớp biểu quyết đồng ý)</form:option>
   				<form:option value="10">Tích cực tham gia tuyên truyền và chấp hành tốt pháp luật, được lớp và CĐ tín nhiệm có ý thức tập thể tốt (có 30%-69% số SV trong lớp biểu quyết đồng ý)</form:option>
   				<form:option value="5">Tích cực tham gia tuyên truyền và chấp hành tốt pháp luật, được lớp và CĐ tín nhiệm có ý thức tập thể tốt (có <30% số SV trong lớp biểu quyết đồng ý) </form:option>
   				<form:option value="0">Vi phạm khuyết điểm, gây mất đoàn kết</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvbieuduong" path="gvbieuduong">
   				<form:option value="5">Có</form:option>
   				<form:option value="0">Không</form:option>    				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvgiupdo" path="gvgiupdo">
   				<form:option value="5">Có</form:option>
   				<form:option value="0">Không</form:option>   				
			</form:select>
        </td></tr>
        <tr><td>
       		<form:select class="form-control ${blockG}" placeholder="Gvtgdoanhoi" path="gvtgdoanhoi">
   				<form:option value="10">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên mà TT đó được khen</form:option>
   				<form:option value="9">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên</form:option> 
   				<form:option value="5">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên mà lớp có sai phạm nhưng chưa bị thi hành kỷ luật</form:option> 
   				<form:option value="0">Thành viên BCS; BCHHSV; BCH từ cấp CĐ; BCN các CLB SV có Quyết định của Trường, Khoa trở lên mà lớp có sai phạm, bị phê bình từ cấp Khoa trở lên</form:option> 
   				<form:option value="9">Đội TNXK; TNTN thường trực; đội Văn nghệ; Thể thao; thành viên CLB SV có Quyết định của Trường, Khoa trở lên được khen thưởng</form:option> 
   				<form:option value="5">Đội TNXK; TNTN thường trực; đội Văn nghệ, Thể thao; thành viên CLB SV có Quyết định của Trường, Khoa trở lên</form:option>
   				<form:option value="0">Không tham gia</form:option>     				
			</form:select>
        </td></tr>
        <tr><td><button type="submit" class="col-12 btn  ${blockG}">Cập nhật</button></td></tr>
      </form:form>
      </table>
    </td>    
</tr></table>


	</div>
	</div>
	<jsp:include page="_footer.jsp" />
</body>
</html>

