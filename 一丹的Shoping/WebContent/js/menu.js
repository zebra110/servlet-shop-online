// JavaScript Document


//导航菜单
function navList() {
    var $obj = $("#nav_dot");
    var big=$('#big').html();
    var big3 = localStorage.getItem("big");
    var small3 = localStorage.getItem("small");
    if(big3!=null){
        $("#big").text(big3+" - -");
    }
    else {
        $("#big").text(" - -");
    }
    if(small3!=null){
        $("#small").text(small3);
    }
    else {
        $("#small").text("");
    }
    $obj.find("h4").hover(function () {
        $(this).addClass("hover");
    }, function () {
        $(this).removeClass("hover");
    });
    $obj.find("p").hover(function () {
        if ($(this).hasClass("on")) { return; }
        $(this).addClass("hover");
    }, function () {
        if ($(this).hasClass("on")) { return; }
        $(this).removeClass("hover");
    });


    $obj.find("h4").click(function () {
        $("#big").text($(this).html().substring(13,17));

        localStorage.setItem("big",$(this).html().substring(13,17));

        var $div = $(this).siblings(".list-item");
        if ($(this).parent().hasClass("selected")) {
            $div.slideUp(600);
            $(this).parent().removeClass("selected");


            // alert($(this).html().substring(13,17));
            // $big.HTML($(this));
        }
        if ($div.is(":hidden")) {
            $("#nav_dot li").find(".list-item").slideUp(600);
            $("#nav_dot li").removeClass("selected");
            $(this).parent().addClass("selected");
            $div.slideDown(600);

        } else {
            $div.slideUp(600);
        }
    });

    $obj.find(".con").click(function (){
        $("#small").text("  -  - "+$(this).html());
        localStorage.setItem("small",$(this).html());
    });
}

/****表格隔行高亮显示*****/
window.onload=function(){
	oTable=document.getElementById("tab");//找表格
	aTr=document.getElementsByTagName("tr");//找所有的行
	for(i=0;i<aTr.length;i++){
		if(i%2==0){
			aTr[i].style.background="#fff";	
		}else{
			aTr[i].style.background="#ccc";	
		};
	};
};


