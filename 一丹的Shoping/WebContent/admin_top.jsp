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
			<li><a href="admin_index.jsp">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
						<ul id="nav_dot">
      <li>
          <h4 class="M1"><span></span>用户管理</h4>
          <div class="list-item none">
            <a href="admin_userAdd.jsp" class="con">添加用户</a>
            <a href="userList" class="con">用户一览</a>
          </div>
        </li>
        <li>
          <h4 class="M2"><span></span>商品管理</h4>
          <div class="list-item none">
            <a href="administer_add.jsp" class="con">添加商品</a>
            <a href="AdminShopList" class="con">商品列表</a>
           </div>
        </li>
        <li>
          <h4 class="M3"><span></span>订单管理</h4>
          <div class="list-item none">
            <a href="administer_addorder" class="con">订单一览</a>
            <a href="administer_addorder1" class="con">未处理订单</a>
            <a href="administer_addorder2" class="con">已经处理的订单</a>
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
                        <li><a href="#" id="small"></a></li>
								<!--<li><a href="#">最新公告</a></li>-->
						</ul>
			</div>

	

