<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<jsp:include page="admin_top.jsp"></jsp:include>

<div class="main">
				<table class="insert-tab" width="100%">
    <tr>

        <td>商品名字</td>
        <td>商品价格</td>
        <td>商品日期</td>
        <td>商品图片</td>
        <td>商品简介</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${shops}" var="shops" >
        <tr>
            <td class="common-text required"><c:out value="${shops.sName}" /></td>
            <td class="common-text required"><c:out value="${shops.sPrice}" /></td>
            <td class="common-text required"><c:out value="${shops.sDate}" /></td>
            <td class="common-text required"><img src="upload/${shops.sPicture }"/></td>
            <td class="common-text required"><c:out value="${shops.sInfo}" /></td>
            <%-- <td>${msg.date}</td> --%>
            <c:choose>
                <c:when
                        test="${shops.sName != null}">
                    <td><a href="ShopUpdate?id=${shops.id}">修改</a></td>
                    <td><a href="ShopDelete2?id=${shops.id} ">删除</a></td>
                </c:when>
                <c:otherwise>
                    <td>修改</td>
                    <td>删除</td>
                </c:otherwise>
            </c:choose>

        </tr>
    </c:forEach>
</table>
</div>
<jsp:include page="admin_bootom.jsp"></jsp:include>
