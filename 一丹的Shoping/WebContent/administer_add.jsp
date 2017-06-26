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
				<form action="ShopAdd" method="post" id="myform" name="myform" enctype="multipart/form-data">
    <table class="insert-tab" width="100%">
        <tbody>
        <tr>
            <th><i class="require-red">*</i>商品名字：</th>
            <td>
                <input class="common-text required" id="title" name="sName" size="50" value="" type="text">
            </td>
        </tr>
        <tr>
            <th><i class="require-red">*</i>商品价格：</th>
            <td>
                <input class="common-text required" id="title" name="sPrice" size="50" value="" type="text">
            </td>
        </tr>
        <tr>
            <th><i class="require-red">*</i>上架日期：</th>
            <td>
                <input class="common-text required" id="title" name="sDate" size="50" value="" type="text">
            </td>
        </tr>
        <tr>
            <th><i class="require-red">*</i>商品图片：</th>
            <td><input name="sPicture" id="" type="file"></td>
        </tr>

        <tr>
            <th>商品介绍：</th>
            <td><textarea name="sInfo" class="common-textarea" cols="30" style="width: 98%;" rows="10"></textarea></td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input class="btn btn-primary btn6 mr10" value="添加" type="submit">
                <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
            </td>
        </tr>
        </tbody></table>
</form>
<jsp:include page="admin_bootom.jsp"></jsp:include>