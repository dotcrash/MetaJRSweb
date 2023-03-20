import Vue from 'vue'
import VueRouter from 'vue-router'
import user from "./modules/user"
import article from "./modules/article"
import Index from '@/components/Index';
const Login = resolve => require(['@/components/Login'], resolve);
const SignUp = resolve => require(['@/components/SignUp'], resolve);
const CheckPhone = resolve => require(['@/components/signUp/CheckPhone'], resolve);
const InputInfo = resolve => require(['@/components/signUp/InputInfo'], resolve);
const SignUpDone = resolve => require(['@/components/signUp/SignUpDone'], resolve);
const GoodsList = resolve => require(['@/components/GoodsList'], resolve);
const GoodsDetail = resolve => require(['@/components/GoodsDetail'], resolve);
const ShoppingCart = resolve => require(['@/components/ShoppingCart'], resolve);
const Order = resolve => require(['@/components/Order'], resolve);
const Pay = resolve => require(['@/components/Pay'], resolve);
const PayDone = resolve => require(['@/components/PayDone'], resolve);
const Freeback = resolve => require(['@/components/Freeback'], resolve);
const Home = resolve => require(['@/components/Home'], resolve);
const MyAddress = resolve => require(['@/components/home/MyAddress'], resolve);
const AddAddress = resolve => require(['@/components/home/AddAddress'], resolve);
const MyOrder = resolve => require(['@/components/home/MyOrder'], resolve);
const MyShoppingCart = resolve => require(['@/components/home/MyShoppingCart'], resolve);
const Merchant = resolve => require(['@/components/Merchant'], resolve);

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    meta: {
      breadcrumbName: "首页",
    },
    component: () => import('@/views/home.vue'),
    children: [
      ...user,
      ...article,
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('@/views/register.vue')
  },
  {
    path: '/not_found',
    name: 'notFound',
    component: () => import('@/components/404/notFound.vue')
  },
  {
    path: '/shop',
    name: 'shop',
   component: () => import('@/views/shop.vue')
/*   component: () => import('@/components/Index.vue') */
  },
  {
      path: '/news',
      name: 'news',
     component: () => import('@/views/news.vue')
  /*   component: () => import('@/components/Index.vue') */
    },
	{
	    path: '/search',
	    name: 'search',
	   component: () => import('@/views/search.vue')
	/*   component: () => import('@/components/Index.vue') */
	  },
  {
    path: '/goodsList', // 商品列表
    name: 'GoodsList',
    component: GoodsList
  },
  {
    path: '/goodsDetail', // 商品详情
    name: 'GoodsDetail',
    component: GoodsDetail
  },
  {
    path: '/shoppingCart', // 商品详情
    name: 'ShoppingCart',
    component: ShoppingCart
  },
  {
    path: '/order', // 订单页面
    name: 'Order',
    component: Order
  },
  {
    path: '/pay', // 支付页面
    name: 'Pay',
    component: Pay
  },
  {
    path: '/payDone', // 支付成功页面
    name: 'PayDone',
    component: PayDone
  },
  {
    path: '/freeback', // 反馈页面
    name: 'Freeback',
    component: Freeback
  },
  {
      path: '/shophome', // 主页
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/',
          name: 'HomeIndex',
          component: MyOrder
        },
        {
          path: 'myAddress',
          name: 'MyAddress',
          component: MyAddress
        },
        {
          path: 'addAddress',
          name: 'AddAddress',
          component: AddAddress
        },
        {
          path: 'myOrder',
          name: 'MyOrder',
          component: MyOrder
        },
        {
          path: 'myShoppingCart',
          name: 'MyShoppingCart',
          component: MyShoppingCart
        }
      ]
    },
    {
      path: '/merchant',
      name: 'Merchant',
      component: Merchant
    }
  
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  // 如果前往的页面是不存在的页面那么跳转到404页面
  if (!to.matched.length) {
    next('/not_found')
  }
  next()
});
export default router
