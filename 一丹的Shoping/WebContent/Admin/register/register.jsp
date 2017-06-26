<div class="container">
	<div class="account">
		<h2>REGISTER</h2>
		<div class="account-pass">
			<div class="col-md-7 account-top">
				<form action="../register" method="post" >
					<div>
						<span>Email</span>
						<input type="text" name="username" id="name">
					</div>
					<div>
						<span >Password</span>
						<input type="password" name="password" id="pass">
					</div>
					<input type="submit" value="Submit" onclick="user_register()">
				</form>
			</div>
			<div class="col-md-5 left-account ">
				<a href="single.html"><img class="img-responsive " src="images/pr2.png" alt=""></a>
				<div class="five">
					<h1>25% </h1><span>discount</span>
				</div>
				<a href="${pageContext.request.contextPath}/Admin/account.jsp" class="create">Account already logged in directly</a>
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
        url: "../register",
        type: "POST",
        data: {username : username,
                password : password
        }
    });

    request.done(function(msg) {
         if (msg.code == 204){ 
            alert("shibai");
            location.href = "register.jsp";
         }else{
        	alert("chenggong");
            location.href = "index.jsp";
        } 
    });

    request.fail(function(jqXHR, textStatus) {
        alert( "Request failed: " + textStatus );
    });




}
</script>