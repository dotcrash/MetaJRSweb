<template>
  <div class="home_wrap">
    <el-container>
      <el-header>
        <forum-header />
      </el-header>
      <el-main>

		  <div>
			<div class="pay-container">
			  <el-alert title="扫码支付" show-icon center  description="请扫描以下二维码进行支付">
			  </el-alert>
			  <div class="pay-box">
				<div class="pay-demo">
				  <img src="static/img/pay/pay-demo.png">
				</div>
				<div class="pay-qr-scan">
				  <img src="static/img/pay/pay-qrscan.png">
				  <div class="pay-tips">
					<router-link to="/payDone"><p>点击我, 完成支付</p></router-link>
				  </div>
				</div>
			  </div>
			</div>
		  </div>
 </el-main>
      <el-footer v-if="$route.name === 'Home'">
        <forum-footer />
      </el-footer>
    </el-container>
  </div>
</template>
<script>
import forumHeader from "@/layout/header/forumHeader.vue";
import forumFooter from "@/layout/footer/forumFooter.vue";
import forumMain from "@/layout/main/forumMain.vue";
export default {
  name: 'Pay',
  components: {
	  forumHeader,
	  forumFooter,
	  forumMain,
  }
};
</script>

<style scoped>
.pay-container {
  margin: 15px auto;
  width: 50%;
  min-width: 1000px;
}
.pay-box {
  height: 500px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.pay-demo {
  width: 50%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.pay-demo img{
  height: 80%;
}
.pay-qr-scan {
  width: 50%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.pay-tips {
  width: 50%;
  text-align: center;
  font-size: 14px;
  line-height: 30px;
}
.pay-tips a {
  color: #999999;
}
</style>
