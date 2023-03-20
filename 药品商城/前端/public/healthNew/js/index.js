(function($) {
	var obj = {
		init: function() {
			this.indexbanner();			
		},
		indexbanner: function() {
			var swiper = $('.xwzxbanner .swiper-container')
			var mySwiper = new Swiper(swiper, {
				autoplay: 5000, //可选选项，自动滑动
				autoplayDisableOnInteraction: false,
				pagination: '.swiper-pagination',
				paginationClickable: true,
				prevButton: '.swiper-button-prev',
				nextButton: '.swiper-button-next',
				loop: true
			})
		}		
	}
	obj.init();

})(jQuery)