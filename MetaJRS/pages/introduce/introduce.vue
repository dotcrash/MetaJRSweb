<template>
	<view class="g-box">
		<view class="g-hd">
			<top-tabbar  :tabIndex="tabIndex" :tabBars="tabBars" @toggleToptab="toggleTab" 
					selectedBottomColor="#30c58d" selectedTextColor="#343434" textColor="#7d7e80" 
					bgColor="#ffffff"></top-tabbar>
			<idea v-if="tabIndex==0" ></idea>
			<!--顶部导航栏-->
			<direct v-if="tabIndex==1" :directions="directions"></direct>	
			<jobs v-if="tabIndex==2"  ></jobs>
			<!-- 	<view class="m-banner">
					<image src="../../static/img/join/ban-join.jpg" mode=""></image>
				</view>
			 -->
		</view>
		<view class="g-bd">
			
		</view>
		
		<!-- 底部区域 -->
		<!-- <i-footer></i-footer> -->
	</view>
</template>

<script>
import idea from "@/components/introduce/idea.vue"
import topTabbar from '@/components/top-tabbar/top-tabbar.vue'
import direct from '@/components/introduce/direct.vue'
import jobs from '@/components/introduce/jobs.vue'
import common from '@/common/common.js'
export default {
components: {topTabbar,idea,direct,jobs},
		teaminfo:{},
		jobs:[],
		directions:[],
		data() {
			return {
				//将选中标签的索引绑定为tabIndex，以便后续的调用
				tabIndex: 0,
				//导航栏标签列表数组数据结构示例，name为必须属性
				tabBars: [{
					name: "理念",
					id: 0
				}, {
					name: "方向",
					id: 1
				}, {
					name: "职位",
					id: 2
				}, 
				
				]
			};
		},
		onLoad() {
			console.log(common.teaminfo)
			this.teaminfo=common.teaminfo;
			
			this.directions=common.directions;
			
		},
	
		methods:{
			//点击导航栏标签改变当前索引
			toggleTab(index) {
				this.tabIndex = index
				
			},
		}	
}
</script>

<style lang="scss" scoped>

</style>
