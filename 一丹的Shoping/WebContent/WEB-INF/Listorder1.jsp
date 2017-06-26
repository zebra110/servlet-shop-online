<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
         <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>用户管理</a>
                    <ul class="sub-menu">
                        <li><a href="userAdd.jsp"><i class="icon-font">&#xe008;</i>添加用户</a></li>
                       
                        <li><a href="userList"><i class="icon-font">&#xe006;</i>用户一览</a></li>
                    </ul>
                </li>
                  <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>商品管理</a>
                    <ul class="sub-menu">
                        <li><a href="administer_add.jsp"><i class="icon-font">&#xe008;</i>添加商品</a></li>
                             <li><a href="AdminShopList"><i class="icon-font">&#xe006;</i>商品列表</a></li>
                    </ul>
                </li>
                 <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>订单管理</a>
                    <ul class="sub-menu">
                        <li><a href="administer_addorder"><i class="icon-font">&#xe008;</i>订单一览</a></li>
                        <li><a href="administer_addorder1"><i class="icon-font">&#xe008;</i>未处理订单</a></li>
                        <li><a href="administer_addorder2"><i class="icon-font">&#xe008;</i>已经处理的订单</a></li>
                        
        
                    </ul>
                </li>
             
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
<div class="result-wrap">
            <div class="result-content">
       <table class="insert-tab" width="100%">
			<tr>
				
				
				<td>商品名称</td>
				<td>商品价格</td>
				<td>价格</td>
				<td>购买日期</td>
				<td>商品状态</td>
				<td>状态</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${orders}" var="orders" begin="0" step="1">
				<tr>
					<td class="common-text required"><c:out value="${orders.sName}" /></td>
					<td class="common-text required"><c:out value="${orders.sPrice}" /></td>
					<td class="common-text required"><c:out value="${orders.address}" /></td>
					<td class="common-text required"><c:out value="${orders.sDate}" /></td>
					<td class="common-text required"><c:out value="${orders.status}" /></td>
			
					<c:choose>
						<c:when
							 test="${orders.status==0}"> 
							<td><a href="Send?id=${orders.id} ">发货</a></td>
							<td><a href="orderDelete?id=${orders.id} ">删除</a></td>
							
						</c:when>
					
					</c:choose>

				</tr>
			</c:forEach>
		</table>
    <!--/main-->
</div>
</body>
</html>