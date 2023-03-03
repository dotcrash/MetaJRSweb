<template>
	<uni-list>
		<!-- title、note设置标题和小文字 -->
		<uni-list-item direction="row" v-for="item in project_news"  :title="item.title" :note="item.from + ' '+item.date">
			<!-- 通过v-slot:header插槽定义列表左侧的图片显示，其他内容通过List组件内置属性实现-->
			<template v-slot:header>
				<!-- 当前判断长度只为简单判断类型，实际业务中，根据逻辑直接渲染即可 -->
				<view class="m-video"  v-if="item.type=='video'">
					<video  :src="item.vedio" mode="aspectFill"
					class="u-video"
					></video>
				</view>
				<view class="img-box">
				 <swiper class="m-banner"
				 	:indicator-dots="swiper.indicatorDots" 
				 	:indicator-color="swiper.indicatorColor"
				 	:indicator-active-color="swiper.indicatorActiveColor"
				 	:autoplay="swiper.autoplay" 
				 	:interval="swiper.interval" 
				 	:duration="swiper.duration">
				 	<swiper-item class="swiper-item"   v-for="itemc in item.photos"  >
				 		<image :src="itemc.url"  mode=""></image>
				 	</swiper-item>
				 	
				 </swiper>
				</view>
				<!-- <image class="image-1" :src="item.avatar" mode="aspectFill"></image> -->
			</template>
		</uni-list-item>
	</uni-list>

</template>

<script>
	export default {
		name: "projects",
		props:{
			project_news: {
				type: Array,
				default: function() {
					return {};
				}
			},
		},
		data() {
			return {
				swiper:{
					// 是否显示面板指示点
					indicatorDots: true,
					// 指示点颜色
					indicatorColor: "#333",
					// 当前选中的指示点颜色
					indicatorActiveColor: "#fff",
					// 是否自动切换
					autoplay: true,
					// 自动切换时间间隔
					interval: 2000,
					// 滑动动画时长
					duration: 500
				},
			}
		},
		onLoad() {

		},
		methods: {

		}
	}
</script>

<style  lang="scss" scoped>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
    .m-video{
    	.u-video{
    		width: 125px;
    		height: 75px;
    	}
    }
	.image-1 {
		flex-shrink: 0;
		margin-right: 10px;
		width: 125px;
		height: 75px;
		border-radius: 6px;
		overflow: hidden;
		border: 1px #f5f5f5 solid;
	}
	.m-banner{
		width: 150px;
		height: 100px;
		margin-top: 20px;
	}
</style>


