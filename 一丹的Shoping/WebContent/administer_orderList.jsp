<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板管理系统</title>
 <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
<link type="text/css" rel="stylesheet" href="css/styleht.css" />
   
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
	<div class="logo">后台管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><%= session.getAttribute("adminname") %></li>
			<li><a href="">修改密码</a></li>
			<li><a href="">设置</a></li>
			<li><a href="">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
						<ul id="nav_dot">
      <li>
          <h4 class="M1"><span></span>用户管理</h4>
          <div class="list-item none">
            <a href="admin_userAdd.jsp">添加用户</a>
            <a href="userList">用户一览</a>
          </div>
        </li>
        <li>
          <h4 class="M2"><span></span>商品管理</h4>
          <div class="list-item none">
            <a href="administer_add.jsp">添加商品</a>
            <a href="AdminShopList">商品列表</a>
           </div>
        </li>
        <li>
          <h4 class="M3"><span></span>订单管理</h4>
          <div class="list-item none">
            <a href="administer_addorder">订单一览</a>
            <a href="administer_addorder1">未处理订单</a>
            <a href="administer_addorder2">已经处理的订单</a>
          </div>
        </li>
  </ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
					<ul>
							<li><img src="imagesht/home.png"></li>
								<li style="margin-left:25px;">您当前的位置：</li>
								<li ><a href="#" id="big"></a></li>
                        <li><a href="#" id="small">--</a></li>
								<!--<li><a href="#">最新公告</a></li>-->
						</ul>
			</div>
			<div class="main">
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
                <c:when
                        test="${orders.status==2}">

                    <td>客户已收货</td>
                    <td><a href="orderDelete?id=${orders.id} ">删除</a></td>
                </c:when>
                <c:otherwise>
                    <td>已发货</td>
                    <td><a href="orderDelete?id=${orders.id} ">删除</a></td>
                </c:otherwise>
            </c:choose>

        </tr>
    </c:forEach>
</table>
			</div>
		</div>
</div><script>navList();</script>
</body>
</html>
