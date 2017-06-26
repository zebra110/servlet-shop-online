<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="concart1" style="background-color:white;">
    <div class="clearfix"> </div>
<div class="gwc" style=" margin:auto;">
    <table cellpadding="0" cellspacing="0" class="gwc_tb1">
        <tr>
            <td class="tb1_td1"><input id="Checkbox1" type="checkbox"  class="allselect"/></td>
            <td class="tb1_td1">all</td>
            <td class="tb1_td3">goods</td>
            <td class="tb1_td4">information</td>
            <td class="tb1_td5">count</td>
            <td class="tb1_td6">price</td>
            <td class="tb1_td7">operating</td>
        </tr>
    </table>



    <table cellpadding="0" cellspacing="0" class="gwc_tb2">
        <c:forEach items="${orders}" var="order" begin="0" step="1">
        <tr>
            <td class="tb2_td1"><input type="checkbox" value="1" name="newslist" id="newslist-1" /></td>
            <td class="tb2_td2"><a href="#"><img src="${pageContext.request.contextPath}/Admin/images/pr4.png"/></a></td>
            <td class="tb2_td3"><a href="#"><c:out value="${order.sName}" /></td></a></td>
            <td class="tb2_td4">Tiger shoes</td>
            <td class="tb1_td5">
                <input id="min1" name=""  style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="-" />
                <input id="text_box1" name="" type="text" value="1" style=" width:30px; text-align:center; border:1px solid orange;" />
                <input id="add1" name="" style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="+" />
            </td>
            <td class="tb1_td6"><label class="tot" style="color:#ff5500;font-size:14px; font-weight:bold;"><c:out value="${order.sPrice}" /></td></label></td>
            <td class="tb1_td7" onclick="goods_delete(${order.sName})"><a>delete</a></td>

        </tr>
        </c:forEach>
		</table>
 
  <table cellpadding="0" cellspacing="0" class="gwc_tb3">
        <tr>
            <td class="tb1_td1"><input id="checkAll" class="allselect" type="checkbox" /></td>
            <td class="tb1_td1">all</td>
            <td class="tb3_td1">
                <input id="invert" type="checkbox" />
                Anti-election
                <input id="cancel" type="checkbox" />cancel
            </td>
            <td class="tb3_td2">Selected <label id="shuliang" style="color:#ff5500;font-size:14px; font-weight:bold;">0</label> 件</td>
            <td class="tb3_td3">
                Total:<span>$</span><span style=" color:#ff5500;"><label id="zong1" style="color:#ff5500;font-size:14px; font-weight:bold;"></label></span></td>
            <td class="tb3_td4"><span id="jz1">Settlement</span><a href="#" style=" display:none;"  class="jz2" id="jz2">结算</a></td>
        </tr>

    </table>
 
 </div>
 </div>
<script type="text/javascript">
		function goods_delete(name){
			
			var result = confirm("Want to delete?");
			if (result) {
				 $.ajax({
			            url: "http://localhost:8080/Shoping/deleteCar",
			            type: "POST",
			            data: {
			                name: name
			            },
			            success: function () {
			                alert("删除成功");
			                location.href = "http://localhost:8080/Shoping/carList"
			            },
			            error: function (xhr, ajaxOptions, thrownError) {
			            	alert("删除失败!", "请重试");
			            }
			        });

			}
	
		}
        $(document).ready(function () {

            //jquery特效制作复选框全选反选取消(无插件)
            // 全选
            $(".allselect").click(function () {
                $(".gwc_tb2 input[name=newslist]").each(function () {
                    $(this).attr("checked", true);
                    // $(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
                });
                GetCount();
            });

            //反选
            $("#invert").click(function () {
                $(".gwc_tb2 input[name=newslist]").each(function () {
                    if ($(this).attr("checked")) {
                        $(this).attr("checked", false);
                        //$(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
                    } else {
                        $(this).attr("checked", true);
                        //$(this).next().css({ "background-color": "#3366cc", "color": "#000000" });
                    }
                });
                GetCount();
            });

            //取消
            $("#cancel").click(function () {
                $(".gwc_tb2 input[name=newslist]").each(function () {
                    $(this).attr("checked", false);
                    // $(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
                });
                GetCount();
            });

            // 所有复选(:checkbox)框点击事件
            $(".gwc_tb2 input[name=newslist]").click(function () {
                if ($(this).attr("checked")) {
                    //$(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
                } else {
                    // $(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
                }
            });

            // 输出
            $(".gwc_tb2 input[name=newslist]").click(function () {
                // $("#total2").html() = GetCount($(this));
                GetCount();
                //alert(conts);
            });
        });
        //******************
        function GetCount() {
            var conts = 0;
            var aa = 0;
            $(".gwc_tb2 input[name=newslist]").each(function () {
                if ($(this).attr("checked")) {
                    for (var i = 0; i < $(this).length; i++) {
                        conts += parseInt($(this).val());
                        aa += 1;
                    }
                }
            });
            $("#shuliang").text(aa);
            $("#zong1").html((conts).toFixed(2));
            $("#jz1").css("display", "none");
            $("#jz2").css("display", "block");
        }
    </script>
    <script type="text/javascript">
        $(function () {
            $(".quanxun").click(function () {
                setTotal();
                //alert($(lens[0]).text());
            });
            function setTotal() {
                var len = $(".tot");
                var num = 0;
                for (var i = 0; i < len.length; i++) {
                    num = parseInt(num) + parseInt($(len[i]).text());

                }
                //alert(len.length);
                $("#zong1").text(parseInt(num).toFixed(2));
                $("#shuliang").text(len.length);
            }
            //setTotal();
        })
    </script>
    
    <!---商品加减算总数---->
<script type="text/javascript">
    $(function () {
        var t = $("#text_box1");
        $("#add1").click(function () {
            t.val(parseInt(t.val()) + 1)
            setTotal(); GetCount();
        })
        $("#min1").click(function () {
            t.val(parseInt(t.val()) - 1)
            setTotal(); GetCount();
        })
        function setTotal() {

            $("#total1").html((parseInt(t.val()) * 9).toFixed(2));
            $("#newslist-1").val(parseInt(t.val()) * 9);
        }
        setTotal();
    })
</script>
<!---商品加减算总数---->
<script type="text/javascript">
    $(function () {
        var t = $("#text_box2");
        $("#add2").click(function () {
            t.val(parseInt(t.val()) + 1)
            setTotal(); GetCount();
        })
        $("#min2").click(function () {
            t.val(parseInt(t.val()) - 1)
            setTotal(); GetCount();
        })
        function setTotal() {

            $("#total2").html((parseInt(t.val()) * 8).toFixed(2));
            $("#newslist-2").val(parseInt(t.val()) * 8);
        }
        setTotal();
    })
</script>
    