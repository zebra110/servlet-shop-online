<!---->	
	<div class="container">
<div class="single">
				<div class="col-md-9 top-in-single">
					<div class="col-md-5 single-top">	
						<div class="flexslider">
							        <!-- FlexSlider -->
										<script src="${pageContext.request.contextPath}/Admin/js/imagezoom.js"></script>
										  <script defer src="${pageContext.request.contextPath}/Admin/js/jquery.flexslider.js"></script>
										<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/flexslider.css" type="text/css" media="screen" />

										<script>
										// Can also be used with $(document).ready()
										$(window).load(function() {
										  $('.flexslider').flexslider({
											animation: "slide",
											controlNav: "thumbnails"
										  });
										});
										</script>
									<!-- //FlexSlider-->
									  <ul class="slides">
										<li data-thumb="${pageContext.request.contextPath}/Admin/images/si1.jpg">
											<div class="thumb-image"> <img src="${pageContext.request.contextPath}/Admin/images/s2.jpg" data-imagezoom="true" class="img-responsive"> </div>
										</li>
										<li data-thumb="${pageContext.request.contextPath}/Admin/images/si2.jpg">
											 <div class="thumb-image"> <img src="${pageContext.request.contextPath}/Admin/images/s3.jpg" data-imagezoom="true" class="img-responsive"> </div>
										</li>
										<li data-thumb="${pageContext.request.contextPath}/Admin/images/si.jpg">
										   <div class="thumb-image"> <img src="${pageContext.request.contextPath}/Admin/images/s1.jpg" data-imagezoom="true" class="img-responsive"> </div>
										</li>
										<li data-thumb="${pageContext.request.contextPath}/Admin/images/si3.jpg">
										   <div class="thumb-image"> <img src="${pageContext.request.contextPath}/Admin/images/s4.jpg" data-imagezoom="true" class="img-responsive"> </div>
										</li>
									  </ul>
									<div class="clearfix"></div>
						</div>
					</div>	
					<div class="col-md-7 single-top-in">
						<div class="single-para">
							<h4>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h4>
							<p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.</p>
							<div class="star">
								<ul>
									<li><i> </i></li>
									<li><i> </i></li>
									<li><i> </i></li>
									<li><i> </i></li>
									<li><i> </i></li>
								</ul>
								<div class="review">
									<a href="#"> 3 reviews </a>/
									<a href="#">  Write a review</a>
								</div>
							<div class="clearfix"> </div>
							</div>
							
								<label  class="add-to">$32.8</label>
							
							<div class="available">
								<h6>Available Options :</h6>
								<ul>
									
								<li>Size:<select>
									<option>Large</option>
									<option>Medium</option>
									<option>small</option>
									<option>Large</option>
									<option>small</option>
								</select></li>
								<li>Cost:
										<select>
										<option>U.S.Dollar</option>
										<option>Euro</option>
									</select></li>
							</ul>
						</div>
							
								<a href="${pageContext.request.contextPath}/Admin/cart.jsp" class="cart " onclick="goods_add()">add to Shopping Cart</a>
							
						</div>
					</div>
				<div class="clearfix"> </div>
				<div class="product-top">
		<div class="col-md-4 grid-product-in">	
		<div class=" product-grid">	
			<a href="single.html"><img class="img-responsive " src="${pageContext.request.contextPath}/Admin/images/sh2.png" alt=""></a>		
			<div class="shoe-in">
				<h6><a href="single.html">Lorem Ipsum is simply</a></h6>
				<label>$67.99</label>
				<a href="single.html" class="store">FIND A STORE</a>
			</div>
			
			<b class="plus-on">+</b>
		</div>	
		</div>
		<div class="col-md-4 grid-product-in">	
		<div class=" product-grid">	
			<a href="single.html"><img class="img-responsive " src="${pageContext.request.contextPath}/Admin/images/pr1.png" alt=""></a>
			<div class="shoe-in">
				<h6><a href="single.html">Lorem Ipsum is simply</a></h6>
				<label>$67.99</label>
				<a href="single.html" class="store">FIND A STORE</a>
			</div>
		
			<b class="plus-on">+</b>
		</div>
		</div>
		<div class="col-md-4 grid-product-in">	
		<div class=" product-grid">	
			<a href="single.html"><img class="img-responsive " src="${pageContext.request.contextPath}/Admin/images/pr.png" alt=""></a>
			<div class="shoe-in">
				<h6><a href="single.html">Lorem Ipsum is simply </a></h6>
				<label>$67.99</label>
				<a href="single.html" class="store">FIND A STORE</a>
			</div>
			
			<b class="plus-on">+</b>
		</div>
		</div>
	<div class="clearfix"> </div>
	</div>
				</div>
				<div class="col-md-3">
					<div class="single-bottom">
						<h4>Brands</h4>
						<ul>
						<li>
							<input type="checkbox"  id="brand" value="">
							<label for="brand"><span></span> Contrary belief</label>
						</li>
						<li>
							<input type="checkbox"  id="brand1" value="">
							<label for="brand1"><span></span> Lorem Ipsum</label>
						</li>
						<li>
							<input type="checkbox"  id="brand2" value="">
							<label for="brand2"><span></span> Fusce feugiat</label>
						</li>
						<li>
							<input type="checkbox"  id="brand3" value="">
							<label for="brand3"><span></span> Contrary belief</label>
						</li>
						<li>
							<input type="checkbox"  id="brand4" value="">
							<label for="brand4"><span></span>Injected humour</label>
						</li>
						</ul>
					</div>
					<div class="single-bottom">
						<h4>Colors</h4>
						<ul>
						<li>
							<input type="checkbox"  id="color" value="">
							<label for="color"><span></span> Red</label>
						</li>
						<li>
							<input type="checkbox"  id="color1" value="">
							<label for="color1"><span></span> Blue</label>
						</li>
						<li>
							<input type="checkbox"  id="color2" value="">
							<label for="color2"><span></span> Black</label>
						</li>
						<li>
							<input type="checkbox"  id="color3" value="">
							<label for="color3"><span></span> White</label>
						</li>
						<li>
							<input type="checkbox"  id="color4" value="">
							<label for="color4"><span></span>Green</label>
						</li>
						</ul>
					</div>
					<div class="single-bottom">
						<h4>Product Categories</h4>
							<div class="product-go">
								<img class="img-responsive fashion" src="${pageContext.request.contextPath}/Admin/images/sh.png" alt="">
							<div class="grid-product">
								<a href="#" class="elit">Consectetuer adipiscing elit</a>
								<span class=" price-in"><small>$500.00</small> $400.00</span>
							</div>
							<div class="clearfix"> </div>
							</div>
							<div class="product-go">
								<img class="img-responsive fashion" src="${pageContext.request.contextPath}/Admin/images/sh1.png" alt="">
							<div class="grid-product">
								<a href="#" class="elit">Consectetuer adipiscing elit</a>
								<span class=" price-in"><small>$500.00</small> $400.00</span>
							</div>
							<div class="clearfix"> </div>
							</div>
							<div class="product-go">
								<img class="img-responsive fashion" src="${pageContext.request.contextPath}/Admin/images/sh2.png" alt="">
							<div class="grid-product">
								<a href="#" class="elit">Consectetuer adipiscing elit</a>
								<span class=" price-in"><small>$500.00</small> $400.00</span>
							</div>
							<div class="clearfix"> </div>
							</div>
				</div>
				</div>
				<div class="clearfix"> </div>		
		</div>
	</div>
<script type="text/javascript">
		function goods_delete(){
			
			var result = confirm("Want to add to Shopping Cart?");
			if (result) {
				 $.ajax({
			            url: "http://localhost:8080/Shoping/orderServlet",
			            type: "POST",
			            data: {
			                id: 5
			            },
			            success: function () {
			                alert("添加成功");
			                location.href = "http://localhost:8080/Shoping/carList"
			            },
			            error: function (xhr, ajaxOptions, thrownError) {
			            	alert("添加失败!", "请重试");
			            }
			        });

			}
	
		}
		</script>
	<!---->