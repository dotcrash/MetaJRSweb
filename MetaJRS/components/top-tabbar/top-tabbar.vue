<template>
	<view>
		<view class="uni-top-tabbar">
			<scroll-view :scroll-x="true"   class="uni-swiper-tab" :style="{backgroundColor:bgColor}">
				<block v-for="(tabBar,index) in tabBars" :key="index">
					<view class="swiper-tab-list" :class="{'active': tabIndex==index}" :style="{color:tabIndex==index?selectedTextColor:textColor}" @tap="toggleTab(index)">
						{{tabBar.name}}
						<view class="swiper-tab-line" :style="{backgroundColor:tabIndex==index?selectedBottomColor:bgColor}"></view>
					</view>
				</block>
			</scroll-view>
				
		</view>
	</view>
</template>



<script>
	export default {
		name: "topTabbar",
				props: {
					//选中标签栏的索引
					tabIndex: {
						type: Number,
						default: 0
					},
		
					//导航栏标签内容
					tabBars: {
						type: Array,
						default: [{
								name: '标签1',
								id: 1
							},
							{
								name: '标签2',
								id: 2
							},
							{
								name: '标签3',
								id: 3
							}
						]
					},
					
					//选中时底部横条颜色
					selectedBottomColor:{
						type:String,
						default:'#30c58d'
					},
					
					//导航区背景颜色
					bgColor:{
						type:String,
						default:'#ffffff'
					},
					
					//选中时文字颜色
					selectedTextColor:{
						type:String,
						default:'#343434'
					},
					
					//默认文本颜色
					textColor:{
						type:String,
						default:'#7d7e80'
					}
				},
				data() {
					return {
		
					}
				},
				mounted() {
					
						
				},
				methods: {
					//点击导航栏标签触发
					toggleTab(index) {
						this.$emit("toggleToptab", index)
					}
				}
	}
</script>

<style lang="scss" scoped>


.uni-top-tabbar {
		/* 以下3项设置用于开启底部阴影显示 */
		/* position: relative;
		z-index: 1;
		overflow: visible; */
	    white-space: nowrap;
		top:var(--window-top); 
		 z-index: 2;
		.uni-swiper-tab {
			
			height: 100rpx;
			//设置底部阴影
			/* box-shadow: rgba(170, 170, 170, 0.5) 0 2rpx 8rpx 0;
	        white-space: nowrap; */
			.swiper-tab-list {
				font-size: 28rpx;
				font-weight: normal;
				line-height: 82rpx;
				text-align: center;
		        display: inline-block; /* 必要，导航栏才能横向*/

				//设置标签宽度
				width: 22%;
			}
	
			.active {
				.swiper-tab-line {
					 
					height: 6rpx;
					width: 82rpx;
					margin: auto;
					
				}
			}
		}
	}
</style>

