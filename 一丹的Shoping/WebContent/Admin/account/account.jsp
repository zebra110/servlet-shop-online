<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="container">
		<div class="account">
		<h2>Account</h2>
		<div class="account-pass">
		<div class="col-md-7 account-top">
			<form >
				
			<div>
						<span>Email</span>
						<input type="text" name="username" id="name">
					</div>
					<div>
						<span >Password</span>
						<input type="password" name="password" id="pass">
					</div>
					
				<input type="submit" value="Login" onclick="user_register()"> 
			</form>
		</div>
		<div class="col-md-5 left-account ">
			<a href="single.html"><img class="img-responsive " src="${pageContext.request.contextPath}/Admin/images/ac.png" alt=""></a>
			<div class="five">
			<h1>25% </h1><span >discount</span>
			</div>
			<a href="${pageContext.request.contextPath}/Admin/register.jsp" class="create">Create an account</a>
<div class="clearfix"> </div>
		</div>
	<div class="clearfix"> </div>
	</div>
	</div>

</div>
<script>
function user_register() {
    var username = $("#name").val();
    var password = $("#pass").val();
	
    var request = $.ajax({
        url: "http://localhost:8080/Shoping/userLogin",
        type: "POST",
        data: {username : username,
                password : password
        },
    success: function () {
        alert("登录成功");
        location.href = "http://localhost:8080/Shoping/Admin/index.jsp"
    },
    error: function (xhr, ajaxOptions, thrownError) {
    	alert("登录失败!", "请重试");
    }
    });
   
    
    



}
</script>