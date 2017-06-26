 <%@ page language="java" import="java.util.*" pageEncoding="GBK"%> 
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
  <head> 
    <base href="<%=basePath%>"> 
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <title>登录界面</title>  
 
<script type="text/javascript"> 
//验证输入不为空的脚本代码 
function checkForm(form){ 
if(form.username.value==""){ 
alert("账号不能为空"); 
form.username.focus(); 
return false; 
} 
if(form.password.value==""){ 
alert("密码不能为空"); 
form.password.focus(); 
return false; 
} 
return ture; 
} 
  </script> 
  </head> 
 <body>
 <h1>欢迎您登录本系统</h1>
<div class="login-form">
	<!--<div class="close"> </div>-->
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="images/avtar.png" />
	</div>
			<form name="regForm" method="post" action="Adlogin" > 
					<input name="name" type="text" class="text" value="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >
						<div  class="key">
					<input name="pass"type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
						</div>
			
	<div class="signin">
		<input name="Submit" type="submit" value="Login" >
	</div>
</div>
</form>
 <div class="copy-rights">
					<p>Copyright &copy; 2017 yinyidan</p>
			</div>

</body>
</html>