<template>
  <div class="home_wrap">
    <el-container>
      <el-header>
        <forum-header />
      </el-header>
      <el-main>
        <forum-main />
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
import store from '@/vuex/store';
import { mapState, mapActions, mapGetters, mapMutations } from 'vuex';
export default {
  name: "home",
  components: {
    forumHeader,
    forumFooter,
    forumMain,
  },
  created() {
  	this.loadSeckillsInfo();
  	this.loadCarouselItems();
  	this.loadComputer();
  	this.loadEat();
  	this.loadShoppingCart();
  },
  beforeRouteEnter(to, from, next) {
    if (to.name === "Home" && from.name === "Login") {
      next((vm) => {
        history.pushState(history.state, "", document.URL);
        window.addEventListener("popstate", vm.cancelGoBack);
      });
    }
    next();
  },
  methods: {
	  ...mapActions(['loadSeckillsInfo', 'loadCarouselItems', 'loadComputer', 'loadEat', 'loadShoppingCart']),
    cancelGoBack() {
      history.pushState(history.state, "", document.URL);
    },
  },
  beforeDestroy() {
    window.removeEventListener("popstate", this.cancelGoBack);
  },
  store
};
</script>

<style scoped lang="less">
.home_wrap {
  min-width: 1200px;
  .el-header {
    padding: 0px;
    height: 64px !important;
  }
  .el-main {
   // padding: 0px;
   background-color: white;
    height: calc(100vh - 64px - 36px) !important;
  }
  .el-footer {
    padding: 0px;
    height: 36px !important;
  }
}
</style>