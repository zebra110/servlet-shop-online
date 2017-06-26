<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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

        <td>id</td>
        <td>用户姓名</td>
        <td>用户密码</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${users}" var="users" begin="0" step="1">
        <tr>
            <td class="common-text required"><c:out value="${users.id}" /></td>
            <td class="common-text required"><c:out value="${users.username}" /></td>
            <td class="common-text required"><c:out value="${users.password}" /></td>
            <c:choose>
                <c:when
                        test="${users.username != null}">
                    <td class="common-text required"><a href="userdelete?id=${users.id} ">删除</a></td>
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