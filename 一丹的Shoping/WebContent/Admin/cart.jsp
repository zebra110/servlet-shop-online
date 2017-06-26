<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
<jsp:include page="/Admin/cart/cart.jsp"></jsp:include>
<jsp:include page="/Admin/Fragment/footer.jsp"></jsp:include>
</body>
</html>