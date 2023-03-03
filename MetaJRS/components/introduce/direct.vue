<template>
	
	<view class="g-bd">
		<uni-list class="i-about"  >
			<!-- title、note设置标题和小文字 -->
			<uni-list-item direction="row" v-for="item in directions"   >
				<!-- 通过v-slot:header插槽定义列表左侧的图片显示，其他内容通过List组件内置属性实现-->
				<template v-slot:header    >
					<!-- 当前判断长度只为简单判断类型，实际业务中，根据逻辑直接渲染即可 -->
					<view class="m-bd">
						<view class="title">
							<view class="u-tit">
								{{item.name}}
							</view>
							<view class="u-stit">
								About {{item.name}} 
							</view>
							<view class="u-line">
								line
							</view>
						</view>
						<view class="i-about">
							<view class="intro">
								<view class="introText">
									<span  ref="text" >
										{{item.intro}}
									</span>
									
									
								</view>
							</view>
							
							
							
							<view class="m-video"  v-if="item.type=='video'">
								<video :src="item.video"
								class="u-video"
								></video>
							</view>
							<view v-if="item.type=='image'" style="text-align: center;">
													<image  class="image-1" :src="item.photo" mode="aspectFill"></image>
													
							</view>
							
							
						</view>
					</view>
					
				</template>
			</uni-list-item>
		</uni-list>
		<!-- 牛汽介绍 -->
		
		
		
		
		
		
	</view>

</template>

<script>
	import common from "@/common/common.js"
	export default {
		name: "direct",
		components: {
			
		},
		
		data() {
			return {
				directions:[],
				
			}
		},
		mounted() {
            this.directions=common.directions
		},
		methods: {

		}
	}
</script>

<style  lang="scss" scoped>
	
	@import './index.scss'

</style>


