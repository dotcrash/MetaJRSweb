
  

<template>
  <div class="home_wrap">
    <el-container>
      <el-header>
        <forum-header />
      </el-header>
      <el-main>
		  <div>
		    <div class="pay-done-box">
		      <img src="static/img/pay-success.png">
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
  name: 'PayDone',
  components:{
	  forumHeader,
	  	  forumFooter,
	  	  forumMain,
  }
};
</script>

<style scoped>
.pay-done-box {
  height: 600px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
