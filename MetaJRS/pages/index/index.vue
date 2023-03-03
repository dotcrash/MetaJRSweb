<template>
	<view class="g-box">
		<!-- 头部 -->
		<view class="g-hd">
			<swiper class="m-banner" 
				:indicator-dots="swiper.indicatorDots" 
				:indicator-color="swiper.indicatorColor"
				:indicator-active-color="swiper.indicatorActiveColor"
				:autoplay="swiper.autoplay" 
				:interval="swiper.interval" 
				:duration="swiper.duration">
				<swiper-item class="swiper-item"   v-for="item in banners"  >
					<image :src="item.url"  mode=""></image>
				</swiper-item>
				
			</swiper>
		</view>
		<!-- 内容区域 -->
		<view class="g-bd">
			<!-- 牛汽介绍 -->
			<view class="m-bd">
				<view class="title">
					<view class="u-tit">
						团队介绍
					</view>
					<view class="u-stit">
						About {{teaminfo.name}}
					</view>
					<view class="u-line">
						line
					</view>
				</view>
				<view class="i-about">
					<view class="img-box">
						<image class="img-about" :src="teaminfo.introphoto"></image>
					</view>
					<view class="about-con">
						<view style="border-radius: 15px;">
							
							<linsindex  :line="3" expandText="展开" foldHint="收起" enableButton="true">
							       
							</linsindex> 
								<!--  -->
								
							</view>
						
					</view>
					
				</view>
			</view>
			<!-- 牛汽产品 -->
			<view class="m-bd">
				<view class="title">
					<view class="u-tit">
						产品总览
					</view>
					<view class="u-stit">
						Products List
					</view>
					<view class="u-line">
						line
					</view>
				</view>
				<view class="g-product" v-for="item in directions">
					<view class="i-product">
						<view class="">
							<view class="pro-img">
								<image :src="item.logo" mode=""></image>
								<!-- <text>牛汽商城</text> -->
							</view>
						</view>
						<view class="pro-con">
							<view class="pro-tit">
								{{item.name}}
							</view>
							<view class="pro-desc">
								{{item.intro}}
							</view>
							
						</view>
					</view>
					
					
				</view>
			</view>
			
			<!-- 牛汽介绍 -->
			
			<!-- 牛汽产品 -->
			<view class="m-bd">
				<view class="title">
					<view class="u-tit">
						游戏试玩
					</view>
					<view class="u-stit">
						Game Play
					</view>
					<view class="u-line">
						line
					</view>
				</view>
				<view class="g-product">
					
					 <button  lang="zh_CN"  @click="downapk" class="button-yuanjiao" hover-class="bg-click" >MetaJRSHero下载</button>
					
					
				</view>
				
			</view>
			
			
			
		</view>
		
		<!-- 底部区域 -->
		<!-- <i-footer></i-footer> -->
	</view>
</template>

<script>
	
    import common from "@/common/common.js"
	import linsindex from "@/components/mote-lines-divide/mote-lines-divide-index.vue"

	export default {
		components: {
			linsindex
		},
		data() {
			return {
	
				banners: [],
				teaminfo:{},
				directions:[],
				

		
                
				// 轮播图配置
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
		
			 this.banners=common.teaminfodata["teaminfo"]["banners"];
			 this.directions=common.directions
			 this.teaminfo=common.teaminfo
			 // console.log(this.teaminfo)
			 this.changeLogin();
			
		},

		methods: {
		downapk(){
			 uni.navigateTo({
									url:`/components/webview/web`
								})
		},
         getimage(){
				
				//console.debug(path.resolve(__dirname,"config.json"));
				//var config=JSON.parse(fs.readFileSync(path.resolve(__dirname,"config.json")));
			},
		changeLogin(){
	// 授权
	// 获取用户详细信息, 可以获取到说明已经授权过, 直接拿到用户信息
	uni.getUserInfo({
		provider: 'qq',
		//授权成功的回调
		success(res) {
			uni.showToast({
			    title:'授权成功',
				icon:'none'
			})
			
			//that.login(res.data);//授权成功调用自己的登录方法就可以了
		},
		//第一次进入小程序
		fail() {
			uni.showToast({
				title: '请点击授权进行登录',
				icon: 'none'
			});
		}
	});
  }

		}
	}
</script>

<style lang="scss">
	@import './index.scss'
</style>
