<template>
	<view class="g-bd">
		<view style="display: flex;flex-direction: column;align-items: center;">
		<!-- 牛汽介绍 -->
		<view class="m-bd">
			<view class="title">
				<view class="u-tit" >
					{{teaminfo.name}}
				</view>
				<view class="u-stit">
					About {{teaminfo.name}}
				</view>
				<view class="u-line">
					line
				</view>
			</view>
			<view class="i-about">
				<view class="m-video">
					<video 
					:src="teaminfo.video" 
					class="u-video"
					></video>
				</view>
				<view style="height: 30rpx;"></view>
				<!-- unfold -->
				<view class="u-video" style="width: 600rpx;border: 2px solid grey;margin-left: 20rpx;;font-size: 30rpx;">
				<ideaintro  :line="3" expandText="展开" foldHint="收起" enableButton="true" ></ideaintro >
				</view>
				
			</view>
		</view>
		<view class="m-bd">
			<view class="title">
				<view class="u-tit">
					团队风采
				</view>
				<view class="u-stit">
					About Teams
				</view>
				<view class="u-line">
					line
				</view>
				
				
			</view>
			<uni-list class="i-about"  >
				<!-- title、note设置标题和小文字 -->
				<uni-list-item direction="row" v-for="item in teaminfo.teamelegant"  >
					<!-- 通过v-slot:header插槽定义列表左侧的图片显示，其他内容通过List组件内置属性实现-->
					<template v-slot:header    >
						<!-- 当前判断长度只为简单判断类型，实际业务中，根据逻辑直接渲染即可 -->
						<view class="m-video1"  v-if="item.type=='video'"  style="text-align: center;" >
							<video  :src="item.url" mode="aspectFill"
							class="u-video1"
							></video>
						{{item.name}}</view>
						<view v-if="item.type=='image'" style="text-align: center;">
						<image  class="image-1" :src="item.url" mode="aspectFill"></image>
						{{item.name}}
					   </view>
					</template>
				</uni-list-item>
			</uni-list>
		</view>
		<view class="m-bd">
			<view class="title">
				<view class="u-tit">
					加入我们
				</view>
				<view class="u-stit">
					Join Us
				</view>
				<view class="u-line">
					line
				</view>
				
				
			</view>
			<uni-list class="i-about"  >
				<!-- title、note设置标题和小文字 -->
				<uni-list-item direction="row" v-for="item in this.teaminfo.joinus"   >
					<!-- 通过v-slot:header插槽定义列表左侧的图片显示，其他内容通过List组件内置属性实现-->
					<template v-slot:header    >
						<!-- 当前判断长度只为简单判断类型，实际业务中，根据逻辑直接渲染即可 -->
						<view class="m-video1"  v-if="item.type=='video'"  style="text-align: center;" >
							<video  :src="item.url" mode="aspectFill"
							class="u-video1"
							></video>
						{{item.name}}</view>
						<view v-if="item.type=='image'" style="text-align: center;">
						<image  class="image-1" :src="item.url" mode="aspectFill"></image>
						{{item.name}}
					   </view>
					</template>
				</uni-list-item>
			</uni-list>
		</view>
		
		</view>
		
	</view>
</template>

<script>
	import common from "@/common/common.js"
	import ideaintro from "@/components/mote-lines-divide/mote-lines-divide-idea.vue"
	export default {
		name: "idea",
		components:{ideaintro},
		
		data() {
			return {
				teaminfo:{},
			
			
			}
		},
		created() {
			var that=this
            that.teaminfo=common.teaminfo
			
			
		},
		methods: {
			
			
			
		},
		
		
	}
</script>

<style  lang="scss" scoped>
	
	@import './index.scss'

</style>


