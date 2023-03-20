<template>
  <div class="nav-main">
    <div class="logo-search">
      <img src="../../assets/logo.png" alt="" />
      <el-form>
        <el-input placeholder="请输入内容" v-model="beforeSearch" class="input-with-select" style="width: 400px">
          <el-button slot="append" icon="el-icon-search" @click="searchArticles" class="search-button"></el-button>
        </el-input>
      </el-form>
      <headLabel></headLabel>
    </div>
    <div class="btn-main" v-if="!getToken"  style="">
		 <!-- <el-button type="success">
			  <el-dropdown >
				<a href="javascript:void(0)">
				  <Icon type="ios-cart-outline"></Icon> 购物车
				</a>
				<el-dropdown-menu slot="dropdown">
					
				  <div class="shopping-cart-null" v-show="shoppingCart.length <= 0">
					<Icon type="ios-cart-outline" class="cart-null-icon"></Icon>
					<span>你的购物车没有空空哦</span>
					<span>赶快去添加商品吧~</span>
				  </div>
				  <div class="shopping-cart-list" v-show="shoppingCart.length > 0">
					<div class="shopping-cart-box" v-for="(item,index) in shoppingCart" :key="index">
					  <div class="shopping-cart-img">
						<img :src="item.img">
					  </div>
					  <div class="shopping-cart-info">
						<div class="shopping-cart-title">
						  <p>{{item.title.substring(0, 22)}}...</p>
						</div>
						<div class="shopping-cart-detail">
						  <p>
							套餐:
							<span class="shopping-cart-text">
							  {{item.package}}
							</span>
							数量:
							<span class="shopping-cart-text">
							  {{item.count}}
							</span>
							价钱:
							<span class="shopping-cart-text">
							  {{item.price}}
							</span>
						  </p>
						</div>
					  </div>
					</div>
					<div class="go-to-buy">
					  <Button type="error" size="small" @click="goToPay">
						去结账
					  </Button>
					</div>
				  </div>
				</el-dropdown-menu>
			  </el-dropdown></el-button> -->
		  <el-button type="primary" @click="$router.push('/register')">注册</el-button>
		  <el-button type="success" @click="$router.push('/login')">登录</el-button>
		  
	</div>
    <div class="my-box" v-else>
		 <img :src="avatarUrl" alt=" " @mouseenter="ifShowAvatar = false" v-show="ifShowAvatar" />
		 	<div style="width: 10px;"></div>
	  <el-button type="success">
	  			  <el-dropdown >
	  				<a href="javascript:void(0)" style="text-decoration:none;font-style: normal;color:white;fon;width: 200px;">
	  				  <Icon type="ios-cart-outline"></Icon> 购物车
	  				</a>
	  				<el-dropdown-menu slot="dropdown">
	  					
	  				  <div class="shopping-cart-null" v-show="shoppingCart.length <= 0">
	  					<Icon type="ios-cart-outline" class="cart-null-icon"></Icon>
	  					<span>你的购物车没有空空哦</span>
	  					<span>赶快去添加商品吧~</span>
	  				  </div>
	  				  <div class="shopping-cart-list" v-show="shoppingCart.length > 0">
	  					<div class="shopping-cart-box" v-for="(item,index) in shoppingCart" :key="index">
	  					  <div class="shopping-cart-img">
	  						<img :src="item.img">
	  					  </div>
	  					  <div class="shopping-cart-info">
	  						<div class="shopping-cart-title">
	  						  <p>{{item.title.substring(0, 22)}}...</p>
	  						</div>
	  						<div class="shopping-cart-detail">
	  						  <p>
	  							套餐:
	  							<span class="shopping-cart-text">
	  							  {{item.package}}
	  							</span>
	  							数量:
	  							<span class="shopping-cart-text">
	  							  {{item.count}}
	  							</span>
	  							价钱:
	  							<span class="shopping-cart-text">
	  							  {{item.price}}
	  							</span>
	  						  </p>
	  						</div>
	  					  </div>
	  					</div>
	  					<div class="go-to-buy">
	  					  <Button type="error" size="small" @click="goToPay">
	  						去结账
	  					  </Button>
	  					</div>
	  				  </div>
	  				</el-dropdown-menu>
	  			  </el-dropdown></el-button>
	             <div style="width: 40px;"></div>
				  <el-button type="danger" @click="sendBtn" :class="{ opacitySend: $route.name == 'SendArticle' || $route.name == 'UpdateArticle' }">发布</el-button>
	 
	<!-- <img :src="avatarUrl" alt=" " @mouseenter="ifShowAvatar = false" v-show="ifShowAvatar" /> -->
	<!--  <img :src="avatarUrl" alt=" " @mouseenter="ifShowAvatar = false" v-show="ifShowAvatar" /> --> 
     <!-- <el-button type="danger" @click="sendBtn" :class="{ opacitySend: $route.name == 'SendArticle' || $route.name == 'UpdateArticle' }">发布</el-button> -->
    </div>
    <div @mouseenter="ifShowAvatar = false" @mouseleave="ifShowAvatar = true" v-show="!ifShowAvatar" class="avatar-hover">
      <headMenu @closeMenu="closeMenu"></headMenu>
    </div>
  </div>
</template>

<script>
import headLabel from "./components/headLabel.vue";
import headMenu from "./components/headMenu.vue";
import { userAuthority } from "@/utils/authority";
import { getUserInfo } from "@/api/api";
import { mapGetters } from "vuex";
import store from '@/vuex/store';
import { mapState, mapActions } from 'vuex';

export default {
  name: "navbar",
  components: {
    headMenu,
    headLabel,
  },
  data() {
    return {
      ifShowAvatar: true,
      userId: "",
      timer: null,
    };
  },
  created() {
    this.init();
    this.timer = userAuthority();

	
  },
  beforeDestroy() {
    clearInterval(this.timer);
  },
  computed: {
	...mapState(['userInfo', 'shoppingCart']),
    ...mapGetters({
      getBeforeSearch: "getBeforeSearch",
    }),
    beforeSearch: {
      get() {
        return this.getBeforeSearch;
      },
      set(text) {
        return this.$store.commit("setBeforeSearch", text);
      },
    },
    getToken() {
      return !!this.$store.getters.getToken;
    },
    avatarUrl() {
      return this.$store.getters.getUser.avatar;
    },
  },
  methods: {
    async init() {
      this.userId = this.$utils.getUserId();
      if (this.userId) {
        let res = await getUserInfo({ id: this.userId });
        if (res) {
          this.$store.commit("setUser", res.data);
        }
      }
    },
    sendBtn() {
      this.$router.push("/article/send");
    },
    closeMenu(value) {
      this.ifShowAvatar = value;
    },
    //模糊查询文章
    searchArticles() {
      if (this.$route.path != "/") {
        this.$router.push("/");
        setTimeout(() => {
          this.$store.commit("setSearchForm", { text: this.beforeSearch, num: 1 });
        }, 50);
      } else {
        this.$store.commit("setSearchForm", { text: this.beforeSearch, num: 1 });
      }
    },
	goToPay () {
	  this.$router.push('/order');
	},
  },  store
};
</script>

<style scoped lang="less">
.nav-main {
  width: 100%;
  height: 64px;
  display: flex;
  justify-content: space-between;
  background-color: #444d56;
  line-height: 64px;
  text-align: center;
}
.logo-search {
  width: 770px;
  display: flex;
  margin-left: 100px;
  justify-content: center;
  align-items: center;
}
.search-button:hover {
  width: 56px;
  /deep/.el-icon-search {
    &::before {
      font-size: 16px;
      font-weight: 600;
    }
  }
}
.btn-main {
  margin-right: 200px;
}
.logo-search > img {
  width: 40px;
  height: 40px;
  margin-right: 20px;
  border-radius: 50%;
}
.el-form-item {
  margin-bottom: 0px;
}
.el-form > .el-input {
  width: 300px;
}
.my-box > img {
  width: 32px;
  height: 32px;
  margin-right: 20px;
  border-radius: 50%;
  cursor: pointer;
}
.my-box {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-right: 30px;
}
.opacitySend {
  visibility: hidden;
}
.avatar-hover {
  position: fixed;
  top: 64px;
  right: 50px;
  z-index: 2021;
}
.el-button--danger {
  color: #fff;
  border: 1px solid #0099ff;
  background-color: #0099ff;

  &:hover {
    border: 1px solid #015bf1;
    background-color: #015bf1;
  }
}
.box {
  width: 100%;
  height: 35px;
  background-color: #e3e4e5;
}
.nav {
  margin: 0% auto;
  width: 90%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.nav ul {
  list-style: none;
}
.nav li {
  float: left;
  font-size: 14px;
  line-height: 35px;
  margin-right: 15px;
  font-weight: bold;
}
.nav a {
  text-decoration: none;
  color: #999999;
  padding-left: 15px;
  border-left: 1px solid #ccc;
  cursor: pointer;
}
.location a {
  border-left: none;
}
.nav a:hover {
  color: #d9534f;
}
.location {
  color: #999999;
}
.icon {
  color: #d9534f;
}
.first {
  color: #999999;
}
.first a:first-child {
  padding-left: 3px;
  border-left: none;
}
.city {
  padding: 10px 15px;
}
.city-item {
  font-weight: bold;
  cursor: pointer;
  padding: 5px;
}
.city-item:hover {
  color: #d9534f;
}
.person-icon {
  color: #d9534f;
  background-color:  #f0cdb2;
}
.username {
  color: #999999;
}
.shopping-cart-list {
  padding: 3px 15px;
}
.shopping-cart-box {
  margin: 8px 0px;
  margin-top: 15px;
  padding-bottom: 15px;
  height: 40px;
  display: flex;
  align-items: center;
  border-bottom: 1px #ccc dotted;
}
.shopping-cart-box:first-child {
  margin-top: 8px;
}
.shopping-cart-img {
  margin-right: 15px;
  width: 40px;
  height: 40px;
}
.shopping-cart-img img {
  width: 100%;
}
.shopping-cart-info {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-content: space-between;
  width: 200px;
  overflow: hidden;
  font-size: 12px;
  line-height: 20px;
  color: #999999;
}
.shopping-cart-detail {
  color: #999999;
}
.shopping-cart-text {
  color: #ccc;
}
.go-to-buy {
  display: flex;
  justify-content: flex-end;
}
.shopping-cart-null {
  padding: 15px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.cart-null-icon {
  font-size: 38px;
  margin-bottom: 15px;
}
.shopping-cart-null span {
  color: #999999;
  font-size: 12px;
  line-height: 16px;
}
.username-p {
  cursor: pointer;
}
.my-page {
  padding: 3px 5px;
  width: 180px;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.my-page a {
  margin: 0px;
  padding: 0px;
  border: none;
}
.my-info {
  padding: 5px;
  width: 50%;
  height: 100%;
  text-align: center;
  cursor: pointer;
}
.my-info:hover {
  box-shadow: 0px 0px 5px #ccc;
}
.my-info i {
  font-size: 28px;
}
.my-info p {
  font-size: 12px;
}
.sign-out {
  padding: 5px;
  width: 50%;
  height: 100%;
  text-align: center;
  cursor: pointer;
}
.sign-out:hover {
  box-shadow: 0px 0px 5px #ccc;
}
.sign-out i {
  font-size: 28px;
}
.sign-out p {
  font-size: 12px;
}
</style>