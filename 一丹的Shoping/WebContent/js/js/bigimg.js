//$(function (){
var x = 0; // cont = $(".content"), bottom = $(".bottom");
var img = new Image();
var width_per, height_per;
function img_block() {
	var img_width, img_height;
	$(".content span").show();// ����ͼƬ����
	var width = $(window).width(); // ��ȡ�������ʾ����Ŀ��
	var height = $(window).height();// ��ȡ�������ʾ����ĸ߶�
	$('.close_div').css({
		"width" : (width - 50)
	});// �ر����Ŀ��
	$(".bottom").stop();
	$(".content").stop();
	$(".content .img").css("display", "none");// ��ǰͼƬ��ʧ
	$(".bottom").css({
		"height" : "0px"
	});// �ײ�������ʧ
	$("#xz").text(x + 1); // �ڼ���ͼƬ
	// ͼƬ��ʾ��
	$(".content").animate(
			{
				"width" : (width - 50) + "px",
				"height" : height - 100 + "px"
			},
			300,
			function() {
				img.src = $(".content .img:eq(" + x + ")").attr("src");// img.width�ɻ�ȡͼƬ�Ŀ��img.height�߶�
				img_width = img.width; // img.width�ɻ�ȡͼƬ���
				img_height = img.height;// img.height�ɻ�ȡͼƬ�߶�
				width_per = (img_width / img_height).toFixed(2); // ��ߵı���
				height_per = (img_height / img_width).toFixed(2);// ��ߵı���

				// �߶ȳ�����ҳ��������û�г� ����ȫ���������ǿ�������ȴ��ڸ߶�
				if (img_height >= height - 100 && img_width < width - 50
						|| img_height > height - 100 && img_width > width - 50
						&& (width - 50) > (height - 100)) {// �߶ȳ�������
					img_height = height - 100;
					img_width = parseInt((height - 100) * width_per);
				}
				// �������෴
				if (img_width >= width - 50 && img_height < height - 100
						|| img_height > height - 100 && img_width > width - 50
						&& (width - 50) < (height - 100)) {// ��ȳ�������ʱ
					img_width = width - 50;
					img_height = parseInt((width - 50) * height_per);
				}
				// ��û�г���
				if (img_height <= height - 100 && img_width <= width - 50) {
					img_height = img_height;
					img_height = img_height;
				}

				$(".content .img:eq(" + x + ")").attr('height', img_height);// ����ͼƬ�ĸ�
				$(".content .img:eq(" + x + ")").attr('width', img_width);// ����ͼƬ�Ŀ�

				$(".content .img:eq(" + x + ")").css("left",
						(width - 50 - parseInt(img_width)) / 2);// ͼƬˮƽ����λ��
				$(".content .img:eq(" + x + ")").css("top",
						(height - 100 - parseInt(img_height)) / 2);// ͼƬ��ֱ����λ��

				$(".content .img:eq(" + x + ")").css("display", "block");// ��һ��ͼƬ��ʾ
				$(".bottom").css("width", (width - 50) + "px");// �ײ����Ŀ��
				$(".bottom").animate({
					"height" : "30px"
				});// �ײ����ĸ߶�
				$(".left,.right").css({
					"width" : (width - 50) / 2 + "px",
					"height" : (height - 100) + "px"
				});// ���ҷ����Ŀ��
				$(".content span").hide();
			});
}

$(document).ready(function() {
	// �鿴��ͼ
	$('.see_big_pic').click(function() {
		$('.container').fadeIn(300);
		// ͼƬ����
		$("#img_count").text($(".content .img").length);
		img_block();
	});
	// ���ͼƬ
	$('.thumb_photo').click(function() {
		$('.container').fadeIn(300);
		// ��ʱ�Զ���һ��
		x = parseInt(this.title) - 1;
		// ͼƬ����
		$("#img_count").text($(".content .img").length);
		img_block();
	});
	// �رղ鿴��ͼ
	$('.close_pop').click(function() {
		$('.container').fadeOut(300);
	});
	// ����
	$(".right").click(function() {
		rights();
	});
	// ����
	$(".left").click(function() {
		lefts();
	});
});

// ��һ��
function rights() {
	if (x == $(".content .img").length - 1) {
		notification('warn', '�������һ��', 500);
		// x = 0;
	} else {
		x++;
		img_block();
	}
	;
}
// ��һ��
function lefts() {
	if (x == 0) {
		notification('warn', '���ǵ�һ��', 500);
		// x = $(".content .img").length-1;
	} else {
		x--;
		img_block();
	}
}
// });
function seeBig(obj) {
	$('.container').fadeIn(300);
	// ��ʱ�Զ���һ��
	x = parseInt(obj.title) - 1;
	// ͼƬ����
	$("#img_count").text($(".content .img").length);
	img_block();
}