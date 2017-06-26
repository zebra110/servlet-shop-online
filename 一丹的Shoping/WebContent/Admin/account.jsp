<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<jsp:include page="/Admin/Fragment/head.jsp"></jsp:include>
<body> 
<jsp:include page="/Admin/Fragment/header.jsp"></jsp:include>
<jsp:include page="/Admin/account/account.jsp"></jsp:include>
<jsp:include page="/Admin/Fragment/footer.jsp"></jsp:include>
</body>
</html>