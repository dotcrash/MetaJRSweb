<template>
	<view class="g-bd" >
		<view style="display: flex;flex-direction: column;align-items: center;">
		<uni-list   v-for="(item,index) in jobs"  :key="index">
			<!-- title、note设置标题和小文字 -->
			<uni-list-item  direction="row"  v-for="(itemc,index1) in item.jobs" :key="index1">
				<!-- 通过v-slot:header插槽定义列表左侧的图片显示，其他内容通过List组件内置属性实现-->
				<template v-slot:header   >
					<!-- 当前判断长度只为简单判断类型，实际业务中，根据逻辑直接渲染即可 -->
					<view class="m-bd"  >
						<view class="title">
							<view class="u-tit">
								{{itemc.name}}
							</view>
							<view class="u-stit">
								属于 {{item.name}} 
							</view>
							<view class="u-line">
								line
							</view>
						</view>
						<view class="i-about" >
							<view class="about-con">
								{{itemc.intro}}
							</view>
							<!-- <view class="about-con">
								{{itemc.contentc[1]}}
							</view> -->
							<view class="about-con">
								人数 {{itemc.neednum}}
							</view>
							<view class="about-con">
								成果展示
							</view>
							
							<view v-if="item.type=='image'" >
								<swiper class="m-banner"
									:indicator-dots="swiper.indicatorDots" 
									:indicator-color="swiper.indicatorColor"
									:indicator-active-color="swiper.indicatorActiveColor"
									:autoplay="swiper.autoplay" 
									:interval="swiper.interval" 
									:duration="swiper.duration"
								>
									<swiper-item class="swiper-item"   v-for="item2 in itemc.photos"  >
										<image :src="item.url"  mode=""></image>
									</swiper-item>
								</swiper>
												
													
							</view>
							
							<view class="btn-more1" @click="click" >
								投递
							</view>
						</view>
					</view>
					
				</template>
			</uni-list-item>
		</uni-list>
		<!-- 牛汽介绍 -->
		</view>
		
		
		
		
		
	</view>

</template>

<script>
	import common from "@/common/common.js"
	export default {
		name: "jobs",
		
		data() {
			return {
				jobs:[],
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
				}
			}
		},
		mounted() {
			var that=this
			that.jobs=common.directions
            
		},
		methods: {
			click(){
				uni.showToast({
								title: "申请未开放，请静候！",
								icon:'exception',
								duration:1000
				});
			}
		}
	}
</script>
<style  lang="scss" scoped>
	
	@import './index.scss'

</style>



