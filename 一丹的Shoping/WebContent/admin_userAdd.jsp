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
				<form action="UserAdd" method="post" id="myform" name="myform" >
    <table class="insert-tab" width="100%">
        <tbody>
        <tr>
            <th><i class="require-red">*</i>用户昵称：</th>
            <td>
                <input class="common-text required"  name="username" size="50"  type="text">
            </td>
        </tr>
        <tr>
            <th><i class="require-red">*</i>用户密码：</th>
            <td>
                <input class="common-text required"  name="password" size="50"  type="text">
            </td>
        </tr>
        <td>

            <input class="btn btn-primary btn6 mr10" value="添加" type="submit">

        <td>
            <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
        </td>
        </td>
        </tr>
        </tbody></table>
</form> 
</div>

<jsp:include page="admin_bootom.jsp"></jsp:include>