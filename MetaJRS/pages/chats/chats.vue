<template>
	<view>
		<chat :chats="chats"></chat>
	</view>
</template>

<script>
import common from '@/common/common.js'
import chat from '@/components/chat/chat.vue'
	export default {
		components: {chat},
		data() {
			return {
				chats:[],
			};
		},
		onShow() {
			uni.request({
			       url: 'https://metajrschat.pek3b.qingstor.com/json/chats.json',
			       method: 'get',
			       success: res => {
			         this.chats = res.data;
					 common.chats=this.chats;
			       }
			 });
		  
		
				    
					
			    
		},
	}
</script>

<style lang="scss">

</style>
