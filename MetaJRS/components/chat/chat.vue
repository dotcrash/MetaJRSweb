<template>
	<uni-list>
		<!-- title、note设置标题和小文字 -->
		<uni-list-item direction="row" v-for="item in chats"  >
			<!-- 通过v-slot:header插槽定义列表左侧的图片显示，其他内容通过List组件内置属性实现-->
			<template v-slot:header  class="info1">
				<!-- 当前判断长度只为简单判断类型，实际业务中，根据逻辑直接渲染即可 -->
				<view class="info">
				<view  class="info1">
				<image class="image-1" :src="item.avatar" mode="aspectFill">
					
				</image> 
				<view  >
					<view  class="info">
						{{item.nickname}}
					</view>
					<view  class="info">
						{{item.date}}
					</view>
					
				</view>
				</view>
				<view  class="infocontent">
					{{item.content}}
				</view>
				</view>
				
				
				<!-- <image class="image-1" :src="item.avatar" mode="aspectFill"></image> -->
			</template>
		</uni-list-item>
	</uni-list>

</template>

<script>
	export default {
		name: "chat",
		props:{
			chats: {
				type: Array,
				default: function() {
					return {};
				}
			},
		},
		data() {
			return {
				
			}
		},
		onLoad() {

		},
		methods: {

		}
	}
</script>

<style  lang="scss" scoped>
.info{
	display: flex;
	flex-direction: column;
	/* 允许在单词内换行。如果到一行末尾长单词没有结束会截断单词 拼接在下一行 */
   word-break: break-all;
	    /* 在长单词或 URL 地址内部进行换行。 在一行末尾处遇到长单词会自动换行去下一行展示 */
    word-wrap: break-word;
	justify-content: center;
	
}

.info1{
	display: flex;/*重要*/
	flex-wrap: wrap;/*重要*/    /*--让弹性盒元素在必要的时候拆行：*/
	align-content: space-between;/*重要*/


}
.infocontent{
	display: flex;/*重要*/
	flex-wrap: wrap;/*重要*/    /*--让弹性盒元素在必要的时候拆行：*/
	align-content: space-between;/*重要*/
	margin-left: 50rpx;
}
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
		width: 50px;
		height: 50px;
		border-radius: 25px;
		overflow: hidden;
		border: 1px #f5f5f5 solid;
	}
</style>


