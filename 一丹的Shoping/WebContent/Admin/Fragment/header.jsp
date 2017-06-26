<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!--header-->
	<div class="line">
	</div>
	<div class="header">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/Admin/index.jsp"><img src="${pageContext.request.contextPath}/Admin/images/logo.png" alt="" ></a>
		</div>
		<div  class="header-top">
			<div class="header-grid">
				<ul class="header-in">
				<li id="account">
				<c:if test="${sessionScope.username != null }">
				
		<a href="http://localhost:8080/Shoping/carList">
			<%String username = request.getSession().getAttribute("username").toString();%>Hello,<%=username %>
			</a>  
				</c:if>
				
				<c:if test="${sessionScope.username == null }">
				
						<a href="${pageContext.request.contextPath}/Admin/account.jsp">My Account</a>
				</c:if>
				
						</li>
						<li>	
							<select class="in-drop">
							  <option value="Dollars" class="in-of">Dollars</option>
							  <option value="Euro" class="in-of">Euro</option>
							  <option value="Yen" class="in-of">Yen</option>
							</select>
						</li>					
					</ul>
					<div class="search-box">
					    <div id="sb-search" class="sb-search">
							<form>
								<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
								<input class="sb-search-submit" type="submit" value="">
								<span class="sb-icon-search"> </span>
							</form>
						</div>
				    </div>
					<!-- search-scripts -->
					<script src="${pageContext.request.contextPath}/Admin/js/classie.js"></script>
					<script src="${pageContext.request.contextPath}/Admin/js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
					<!-- //search-scripts -->
					<div class="online">
					<a href="single.html" >SHOP ONLINE</a>
					</div>
					<div class="clearfix"> </div>
			</div>
			<div class="header-bottom">
				<div class="h_menu4"><!-- start h_menu4 -->
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="product.html">Running</a></li>
					<li><a href="product.html">Fitness</a></li>		
					<li><a href="product.html">Tennis</a>	
					</li>
					<li><a href="product.html">Football</a></li>
					<li><a href="product.html">Golf</a></li>
					<li><a href="product.html">More <i> </i></a>
						<ul>
							<li><a href="contact.html">Contact</a></li>
							<li><a href="account.html">Account</a></li>
							<li><a href="register.html">Register</a></li>
						</ul>
					</li>
				</ul>
				<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/js/nav.js"></script>
			</div><!-- end h_menu4 -->
					<ul class="header-bottom-in">
						<li ><select class="drop">
							  <option value="Dollars" class="in-of">Get Active</option>
							  <option value="Euro" class="in-of">Get Active1</option>
							  <option value="Yen" class="in-of">Get Active2</option>
							</select> </li>
						<li ><select class="drop">
							  <option value="Dollars" class="in-of">Community</option>
							  <option value="Euro" class="in-of">Community1</option>
							  <option value="Yen" class="in-of">Community2</option>
							</select></li>		
					</ul>
			<div class="clearfix"> </div>
		</div>
		</div>
		<div class="clearfix"> </div>
	</div>
	<script>
	if( $("#dis").val()==""){
		$("#dis").html("My Account") ;
	}</script>
	<!---->