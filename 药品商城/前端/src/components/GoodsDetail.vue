
<template>
  <div class="home_wrap">
    <el-container>
      <el-header>
        <forum-header />
      </el-header>
      <el-main>
  <div style="overflow-y: hidden" >
    <!-- <div class="shop-item-path">
      <div class="shop-nav-container">
        <Breadcrumb>
          <BreadcrumbItem to="/">首页</BreadcrumbItem>
          <BreadcrumbItem to="/goodsList">手机壳</BreadcrumbItem>
          <BreadcrumbItem>手机保护套</BreadcrumbItem>
        </Breadcrumb>
      </div>
    </div> -->
    <!-- 商品信息展示 -->
    <ShowGoods ></ShowGoods>
    <!-- 商品详细展示 -->
    <ShowGoodsDetail></ShowGoodsDetail>
    <Spin size="large" fix v-if="isLoading"></Spin>
  </div>
      </el-main>
      <el-footer v-if="$route.name === 'Home'">
        <forum-footer />
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import Search from '@/components/Search';
import GoodsDetailNav from '@/components/nav/GoodsDetailNav';
import ShopHeader from '@/components/header/ShopHeader';
import ShowGoods from '@/components/goodsDetail/ShowGoods';
import ShowGoodsDetail from '@/components/goodsDetail/ShowGoodsDetail';
import store from '@/vuex/store';
import { mapState, mapActions } from 'vuex';
import forumHeader from "@/layout/header/forumHeader.vue";
import forumFooter from "@/layout/footer/forumFooter.vue";
import forumMain from "@/layout/main/forumMain.vue";
export default {
  name: 'GoodsDetail',
  beforeRouteEnter (to, from, next) {
    window.scrollTo(0, 0);
    next();
  },
  created () {
    this.loadGoodsInfo();
  },
  data () {
    return {
      tagsColor: [ 'blue', 'green', 'red', 'yellow' ]
    };
  },
  methods: {
    ...mapActions(['loadGoodsInfo'])
  },
  computed: {
    ...mapState(['goodsInfo', 'isLoading'])
  },
  components: {
    Search,
    ShopHeader,
    GoodsDetailNav,
    ShowGoods,
    ShowGoodsDetail,
	forumHeader,
	forumFooter,
	forumMain,
  },
  store
};
</script>

<style scoped>
.shop-item-path {
  height: 38px;
  background-color: rgb(236, 235, 235);
  line-height: 38px;
  color: #2c2c2c;
}
.shop-nav-container {
  margin: 0px auto;
  width: 80%;
}
</style>
