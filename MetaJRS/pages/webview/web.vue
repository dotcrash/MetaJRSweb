<template>
	<view>
		<!-- 新闻头条详情 -->
		<web-view :src="url"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
								url: 'https://metajrs.pek3b.qingstor.com/apk/MetaJRS.apk',
			};
		},
		onLoad() {
		    
		}
	}
</script>

<style lang="scss">

</style>