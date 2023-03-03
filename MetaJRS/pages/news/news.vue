<template>
	<view class="g-box">
		<view class="g-hd">
			<top-tabbar  :tabIndex="tabIndex" :tabBars="tabBars" @toggleToptab="toggleTab" 
					selectedBottomColor="#30c58d" selectedTextColor="#343434" textColor="#7d7e80" 
					bgColor="#ffffff"></top-tabbar>
			<team-activity v-if="tabIndex==0"  :team_news="team_news"></team-activity>
			<!--顶部导航栏-->
			<game-thing v-if="tabIndex==1" ></game-thing>
			<projects v-if="tabIndex==2" :project_news="project_news">=</projects>			
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
import teamActivity from "@/components/info/team.vue"
import topTabbar from '@/components/top-tabbar/top-tabbar.vue'
import gameThing from '@/components/info/game.vue'
import projects from '@/components/info/project.vue'
import common from '@/common/common.js'
export default {
		components: {topTabbar,teamActivity,gameThing,projects},
		data() {
			return {
				team:{},
				team_news:[],
				
				project:{},
				project_news:[],
				//将选中标签的索引绑定为tabIndex，以便后续的调用
				tabIndex: 0,
				//导航栏标签列表数组数据结构示例，name为必须属性
				tabBars: [{
					name: "团队",
					id: 0
				}, {
					name: "游戏",
					id: 1
				}, {
					name: "项目",
					id: 2
				}, 
				
				]
			};
		},
		created() {        
			 this.team=common.news["activity"][0];
			 this.team_news=this.team["news"];
			 
			 this.project=common.news["activity"][2];
			 this.project_news=this.project["news"];
	
					 
			
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
 @import './news.scss'
</style>

