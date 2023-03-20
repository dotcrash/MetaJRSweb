
  

<template>
  <div class="home_wrap">
    <el-container>
      <el-header>
        <forum-header />
      </el-header>
      <el-main>
		  <div>
		    
		    <div class="container">
		      <div class="bread-crumb">
		        <Breadcrumb>
		          <BreadcrumbItem to="/">
		            <!-- <Icon type="ios-home-outline"></Icon> 首页 -->
		          </BreadcrumbItem>
		          <BreadcrumbItem to="/goodsList?sreachData=">
		            <Icon type="bag"></Icon> {{searchItem}}
		          </BreadcrumbItem>
		        </Breadcrumb>
		      </div>
		      <!-- 商品标签导航 -->
		      <!-- <GoodsClassNav></GoodsClassNav> -->
		      <!-- 商品展示容器 -->
		      <div class="goods-box">
		        <!-- <div class="as-box">
		          <div class="item-as-title">
		            <span>商品精选</span>
		            <span>广告</span>
		          </div>
		          <div class="item-as" v-for="(item,index) in asItems" :key="index">
		            <div class="item-as-img">
		              <img :src="item.img" alt="">
		            </div>
		            <div class="item-as-price">
		              <span>
		                <icon type="social-yen text-danger"></icon>
		                <span class="seckill-price text-danger">{{item.price}}</span>
		              </span>
		            </div>
		            <div class="item-as-intro">
		              <span>{{item.intro}}</span>
		            </div>
		            <div class="item-as-selled">
		              已有<span>{{item.num}}</span>人评价
		            </div>
		          </div>
		        </div> -->
		        <div class="goods-list-box">
		          <div class="goods-list-tool">
		            <ul>
		              <li v-for="(item,index) in goodsTool" :key="index" @click="orderBy(item.en, index)"><span :class="{ 'goods-list-tool-active': isAction[index]}">{{item.title}} <Icon :type="icon[index]"></Icon></span></li>
		            </ul>
		          </div>
		          <div class="goods-list" style="margin-left: 10px;">
		            <div class="goods-show-info" v-for="(item, index) in orderGoodsList" :key="index">
		              <div class="goods-show-img">
		                <router-link to="/goodsDetail"><img :src="item.img"/></router-link>
		              </div>
		              <div class="goods-show-price">
		                <span>
		                  <icon type="social-yen text-danger"></icon>
		                  <span class="seckill-price text-danger">{{item.price}}</span>
		                </span>
		              </div>
		              <div class="goods-show-detail">
		                <span>{{item.intro}}</span>
		              </div>
		              <div class="goods-show-num">
		                已有<span>{{item.remarks}}</span>人评价
		              </div>
		              <div class="goods-show-seller">
		                <span>{{item.shopName}}</span>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
		      <div class="goods-page">
		        <Page :total="100" show-sizer></Page>
		      </div>
		    </div>
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
import GoodsListNav from '@/components/nav/GoodsListNav';
import GoodsClassNav from '@/components/nav/GoodsClassNav';
import store from '@/vuex/store';
import { mapState, mapActions, mapGetters, mapMutations } from 'vuex';
import forumHeader from "@/layout/header/forumHeader.vue";
	import forumFooter from "@/layout/footer/forumFooter.vue";
	import forumMain from "@/layout/main/forumMain.vue";
export default {
  name: 'GoodsList',
  beforeRouteEnter (to, from, next) {
    window.scrollTo(0, 0);
    next();
  },
  data () {
    return {
      searchItem: '',
      isAction: [ true, false, false ],
      icon: [ 'arrow-up-a', 'arrow-down-a', 'arrow-down-a' ],
      goodsTool: [
        {title: '综合', en: 'sale'},
        {title: '评论数', en: 'remarks'},
        {title: '价格', en: 'price'}
      ]
    };
  },
  computed: {
    ...mapState(['asItems', 'isLoading']),
    ...mapGetters(['orderGoodsList'])
  },
  methods: {
    ...mapActions(['loadGoodsList']),
    ...mapMutations(['SET_GOODS_ORDER_BY']),
    orderBy (data, index) {
      console.log(data);
      this.icon = [ 'arrow-down-a', 'arrow-down-a', 'arrow-down-a' ];
      this.isAction = [ false, false, false ];
      this.isAction[index] = true;
      this.icon[index] = 'arrow-up-a';
      this.SET_GOODS_ORDER_BY(data);
    }
  },
  created () {
    this.loadGoodsList();
  },
  mounted () {
    this.searchItem = this.$route.query.sreachData;
  },
  components: {
    Search,
    GoodsListNav,
    GoodsClassNav,forumHeader,
	  	  forumFooter,
	  	  forumMain,
  },
  store
};
</script>

<style scoped>
.container {
  margin: 15px auto;
  width: 93%;
  min-width: 1000px;
}
.text-danger {
  color: #A94442;
}
.seckill-price{
  margin-right: 5px;
  font-size: 25px;
  font-weight: bold;
}
.goods-box {
  display: flex;
  margin-left: 2px;
}
/* ---------------侧边广告栏开始------------------- */
.as-box {
  width: 200px;
  border: 1px solid #ccc;
}
.item-as-title{
  width: 100%;
  height: 36px;
  color: #B1191A;
  line-height: 36px;
  font-size: 18px;
}
.item-as-title span:first-child{
  margin-left: 20px;
}
.item-as-title span:last-child{
  float: right;
  margin-right: 15px;
  font-size: 10px;
  color: #ccc;
}
.item-as{
  width: 160px;
  margin: 18px auto;
}
.item-as-img{
  width: 160px;
  height: 160px;
  margin: 0px auto;
}
.item-as-price span{
  font-size: 18px;
}
.item-as-intro{
  margin-top: 5px;
  font-size: 12px;
}
.item-as-selled{
  margin-top: 5px;
  font-size: 12px;
}
.item-as-selled span{
  color: #005AA0;
}
/* ---------------侧边广告栏结束------------------- */

/* ---------------商品栏开始------------------- */
.goods-list-box {
  margin-left: 15px;
  width: calc(100% - 215px);
  margin-right: 100px;
}
.goods-list-tool{
  width: 90%;
  height: 38px;
  border: 1px solid #ccc;
  background-color: #F1F1F1;
  border-radius: 10px;
  margin-left: 120px;

}
.goods-list-tool ul{
  padding-left: 15px;
  list-style: none;
  margin-left: 50px;
}
.goods-list-tool li{
  cursor: pointer;
  float: left;
    border-radius: 10px;
}
.goods-list-tool span{
  padding: 5px 8px;
  border: 1px solid #ccc;
  border-left: none;
  line-height: 36px;
  background-color: #fff;
    border-radius: 10px;
}
.goods-list-tool span:hover{
  border: 1px solid #E4393C;
}
.goods-list-tool i:hover{
  color: #E4393C;
}
.goods-list-tool-active {
  color: #fff;
  border-left: 1px solid #ccc;
  background-color: #E4393C !important;
}

.goods-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin-left: 100px;
  margin-right: 100px;
}
.goods-show-info{
  width: 240px;
  padding: 10px;
  margin: 15px 0px;
  border: 1px solid #fff;
  cursor: pointer;
}
.goods-show-info:hover{
  border: 1px solid #ccc;
  box-shadow: 0px 0px 15px #ccc;
}
.goods-show-price{
  margin-top: 6px;
}
.goods-show-detail{
  font-size: 12px;
  margin: 6px 0px;
}
.goods-show-num{
  font-size: 12px;
  margin-bottom: 6px;
  color: #009688;
}
.goods-show-num span{
  color: #005AA0;
  font-weight: bold;
}
.goods-show-seller{
  font-size: 12px;
  color:#E4393C;
}
.goods-page {
  margin-top: 20px;
  display: flex;
  justify-content: flex-end;
}
/* ---------------商品栏结束------------------- */
</style>
