<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>unique</title>
<link type="text/css" href="css/css.css" rel="stylesheet" />
<script type="text/javascript" src="js/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>

</head>

<body>
	<div class="hrader" id="header">
		<div class="top">
				<li class="kefus"><a href="#">联系客服</a>
				</li>
				<li><a href="#" class="lan">中文</a>
				</li>
				<li><a href="#" class="lan">English</a>
				</li>
				<div class="clears"></div>
			</ul>
			<!--topNav/-->
		</div>
		<!--top/-->
	</div>
	<!--hrader/-->
	<div class="mid">
		<h1 class="logo" style="text-align:left;">
			<a href="index.jsp"><img src="images/logo.png" width="304"
				height="74" />
			</a>
		</h1>
		<form action="#" method="get" class="subBox">
			<div class="subBox2">
				<input type="text" class="subText" /> <input type="image"
					src="images/sub.jpg" width="95" height="32" class="subImg" />
				<div class="hotci">
					<a href="#">酷派大神</a> <a href="#">三星s5</a> <a href="#">诺基亚1020</a> <a
						href="#">Iphone 6</a> <a href="#">htc one</a>
				</div>
				<!--hotci/-->
			</div>
			<!--subBox2/-->
		</form>
		<!--subBox/-->
		<div class="ding-gou">
			<div class="ding">
				<a href="orderList"><img src="images/dingdan.jpg" width="106"
					height="32" />
				</a>
			</div>
			<!--ding/-->
			<div class="gou">
				<a href="showCar"><img src="images/gouwuche.jpg" width="126"
					height="32" />
				</a>
			</div>
			<!--gou/-->
			<div class="clears"></div>
		</div>
		<!--ding-gou/-->
	</div>
	<!--mid-->
	<div class="navBox navBg3">
		<ul class="nav">
			<li><a href="index.jsp">首页</a>
			</li>
			
			<li class="navCur"><a href="help.jsp">帮助</a>
			</li>
			<div class="clears"></div>
		</ul>
		<!--nav/-->
	</div>
	<!--navBox/-->
	<div class="car">
		<div class="cont">
			

			
			<!--zhzhifufangshii/-->
			<h4 class="orderTitle">订单清单</h4>
			<table class="orderList">
			<tr>
				
				<th width="430">商品名字</th>
				<th width="135">商品图片</th>
					<th width="135">商品价格</th>
					<th width="135">商品数量</th>
					<th width="135">地址</th>
					<th width="135">订单日期</th>
					
				
				
				
				
			</tr>
			<c:forEach items="${orders}" var="orders" >
				<tr>
				<td class="common-text required"><c:out value="${orders.sPicture}" /></td>
					<td class="common-text required"><c:out value="${orders.sName}" /></td>
				 <td class="common-text required"><c:out value="${orders.sPrice}" /></td>
				  <td class="common-text required"><c:out value="${orders.count}" /></td>
				 <td class="common-text required"><c:out value="${orders.address}" /></td>
					<td class="common-text required"><c:out value="${orders.sDate}" /></td> 
					
					

				</tr>
			</c:forEach> 
			
			<td> 总价为：<%=request.getAttribute("result") %> </td>
			
		</table>
			<!--zongjia/-->
			<div class="clears"></div>
		</div>
		<!--cont/-->
	</div>
	<!--car/-->
	<div class="footBox">
		<div class="footers">
			<div class="footersLeft">
				<a href="index.jsp"><img src="images/ftlogo.jpg" width="240"
					height="64" />
				</a>
				<h3 class="ftphone">400 000 0000</h3>
				<div class="ftKe">
					客服 7x24小时(全年无休)<br /> <span>客服邮箱：kefu@webqin.net </span>
				</div>
				<!--ftKe/-->
			</div>
			<!--footersLeft/-->
			<div class="footersRight">
				<ul>
					<li class="ftTitle">新手指南</li>
					<li><a href="#">购物流程</a>
					</li>
					<li><a href="#">会员计划及划分</a>
					</li>
					<li><a href="#">优惠券规则</a>
					</li>
					<li><a href="#">联系客服</a>
					</li>
					<li><a href="#">常见问题</a>
					</li>
				</ul>
				<ul>
					<li class="ftTitle">付款方式</li>
					<li><a href="#">在线支付</a>
					</li>
					<li><a href="#">礼品卡支付</a>
					</li>
					<li><a href="#">货到付款</a>
					</li>
					<li><a href="#">银行付款</a>
					</li>
				</ul>
				<ul>
					<li class="ftTitle">配送服务</li>
					<li><a href="#">配送时效及运费</a>
					</li>
					<li><a href="#">超时赔付</a>
					</li>
					<li><a href="#">验货与签收</a>
					</li>
					<li><a href="#">配货信息跟踪</a>
					</li>
				</ul>
				<ul>
					<li class="ftTitle">售后服务</li>
					<li><a href="#">退换货政策</a>
					</li>
					<li><a href="#">退换货区域</a>
					</li>
					<li><a href="#">退款时限</a>
					</li>
					<li><a href="#">先行赔付</a>
					</li>
					<li><a href="#">发票说明</a>
					</li>
				</ul>
				<ul>
					<li class="ftTitle">特色服务</li>
					<li><a href="#">礼品卡</a>
					</li>
					<li><a href="#">产品试用</a>
					</li>
					<li><a href="#">花粉中心</a>
					</li>
					<li><a href="#">快速购物</a>
					</li>
					<li><a href="#">推荐好友</a>
					</li>
				</ul>

				<div class="clears"></div>
			</div>
			<!--footersRight/-->
			<div class="clears"></div>
		</div>
		<!--footers/-->
	</div>
	<!--footBox/-->
	<div class="footer" style="text-align:left;">
		<a href="#">关于我们</a> <a href="#">友情链接</a> <a href="#">版权声明</a> <a
			href="#">网站地图</a> <br /> <span>&copy; 2014 Unqezi 使用前必读 沪ICP备
			12007626号-1</span>
	</div>
	<!--footer/-->
</body>
</html>

