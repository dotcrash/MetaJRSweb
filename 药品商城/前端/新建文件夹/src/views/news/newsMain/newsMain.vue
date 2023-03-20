<template>
	
  <div class="index">
	<!--  <swiper >
	      <swiper-slide >
	        <img src="../../../assets/images/02.png" alt="" />
	      </swiper-slide>
		  
		   <div class="swiper-pagination"></div>
		   <div class="swiper-button-prev"></div>
		   <div class="swiper-button-next"></div>
	   
		</swiper> -->
<div class="xwzxbanner wrap_box" style="border-radius: 10px;height: 500px;">
	 	<div class="wrapper" style="border-radius: 10px;">
	 		<div class="swiper-container bannercon" style="border-radius: 20px;height: 500px;">
	 			<div class="swiper-wrapper" >
	 				<div class="swiper-slide" style="border-radius: 10px;">
	 					<a href="#"><img src="../../../assets/images/02.png" alt="" /></a>
	 				</div>
	 				<div class="swiper-slide">
	 					<a href="#"><img src="../../../assets/images/02.png" alt="" /></a>
	 				</div>
	 				<div class="swiper-slide">
	 					<a href="#"><img src="../../../assets/images/02.png" alt="" /></a>
	 				</div>
	 			</div>
	 			<div class="swiper-button-prev">
	 				<i class="iconfont">&#xe624;</i>
	 			</div>
	 			<div class="swiper-button-next">
	 				<i class="iconfont">&#xe624;</i>
	 			</div>
	 			<div class="swiper-pagination">
	 
	 			</div>
	 		</div>
	 	</div>
	 </div> 
    <div class="index-main">
		
      <el-table :data="tableData" style="width: 100%">
		  <el-table-column width="250px">
		    <template slot-scope="scope">
		      <div class="demo-image__preview">
		        <el-image style="width: 250px; height: 150px" :src="require('/public/static/img/content/'+scope.row.articleImgs[0])" :preview-src-list="scope.row.articleImgs" lazy>
		          <div slot="error" class="image-slot">
		            <i class="el-icon-picture-outline"></i>
		          </div>
		        </el-image>
		      </div>
		    </template>
		  </el-table-column>
        <el-table-column width="800px">
          <template slot-scope="scope">
            <div class="tb-t-top">
              <span v-html="scope.row.title"></span>
            </div>
            <div class="tb-t-center">
              <p v-html="scope.row.contentText"></p>
            </div>

		
            <div class="tb-t-bottom-right">
              <div style="margin-right: 60px;">
               <!-- <img :src="scope.row.userId.avatar" @click="goToUserDetails(scope.row.userId._id)" /> -->
		<!-- 	   <img :src="scope.row.userId.avatar"  /> -->
			  <!-- <span class="nickname" >{{ scope.row.userId.nickname }}</span> -->
			 
			  <!-- <span>{{scope.row.from}}</span> -->
			  <span >来源：</span>
			   <span>{{ scope.row.from}}</span>
			   <span style="width: 400px;"></span>
               <span class="nickname" @click="goToUserDetails(scope.row.userId._id)">{{ scope.row.userId.nickname }}</span>
               <span style="width: 20px;"></span>
				<span>{{ getTime(scope.row.createdTime) }}</span>
              </div>
              <!-- <div class="icon-box">
                <span><i class="el-icon-view"></i>{{ scope.row.readNum }}</span>
                <span><i class="el-icon-chat-dot-round"></i>{{ scope.row.commentNum }}</span>
                <span><i class="el-icon-thumb"></i>{{ scope.row.likeNum }}</span>
              </div> -->
            </div>
			
          </template>
        </el-table-column>
        
      </el-table>
       <div class="page-box" v-if="tableData.length">
        <el-pagination :current-page.sync="nowPageNum" background layout="prev, pager, next" :total="Math.ceil(total / 2)" @current-change="currentChange"></el-pagination>
      </div> 
    </div>
  </div>
</template>

<script>
import { getArticleData, addReadNumApi } from "@/api/api";
import "@/assets/css/common.css"
import "@/assets/css/index.css"
import "@/assets/css/module.css"
import "@/assets/css/swiper.min.css"
import 'element-ui/lib/theme-chalk/index.css';


/* import "swiper/dist/css/swiper.css"; */
import { Swiper, SwiperSlide } from "swiper";
/* import SwiperCore, { Navigation, Pagination, Scrollbar, A11y,Autoplay,} from 'swiper';
SwiperCore.use([Navigation, Pagination, Scrollbar, A11y, Autoplay]); */


export default {
  name: "newsMain",
  data() {
    return {
      tableData: [
		{"_id":1,"title":"脑系疾病的自述","readNum": 50,"commentNum":3,"likeNum":20,"createdTime":"2022-05-06",
		"userId":{"_id":1,"nickname":"爱开发的小罗","avatar": "./static/img/avatar/1.jpg"},"contentText":"11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
		"from":"中国网",
		"articleImgs":["1.jpg",""]},
		{"_id":2,"title":"欢迎访问脑疗多功能系统","readNum": 50,"commentNum":3,"likeNum":20,"createdTime":"2022-05-02",
		"userId":{"_id":1,"nickname":"爱开发的小罗1","avatar": "./static/img/avatar/2.jpg"},
		"from":"中国网",
		"articleImgs":["2.jpg",""]},
		{"_id":3,"title":"大家可以点我头像哈","readNum": 50,"commentNum":3,"likeNum":20,"createdTime":"2022-05-02",
		"userId":{"_id":1,"nickname":"爱开发的小罗2","avatar": "./static/img/avatar/3.jpg"},
		"from":"中国网",
		"articleImgs":["3.jpg",""]},
		{"_id":1,"title":"脑系疾病的自诊","readNum": 50,"commentNum":3,"likeNum":20,"createdTime":"2022-05-01",
		"userId":{"_id":1,"nickname":"爱开发的小罗3","avatar": "./static/img/avatar/2.jpg"},
		"from":"中国网",
		"articleImgs":["4.jpg",""]}
		],
      total: 3,
      nowPageNum: 1,
    };
  },
 
  created() {
    this.getData();
  },
  computed: {
    searchForm() {
      return this.$store.getters.getSearchForm;
    },
    // 时间转换
    getTime() {
      return function (value) {
        return this.$utils.getDate(value);
      };
    },
  },
  methods: {
    async getData() {
      /* let res = await getArticleData(this.searchForm);
      if (res && res.code === 200) {
        this.tableData = res.data.articleData;
        this.highLight(this.tableData);
        this.total = res.data.total;
      }
      //点击下一页时跳转到顶部
      document.documentElement.scrollTop = 0; */
    },
    //搜索关键词高亮
    highLight(tableData) {
      const search = this.searchForm.search;
      if (search && tableData.length) {
        tableData.forEach((item) => {
          item.title = item.title.replace(search, `<em style="color: #fc5531; font-style: normal;"> ${search} </em>`);
          item.contentText = item.contentText.replace(search, `<em style="color: #fc5531; font-style: normal;">${search}</em>`);
        });
      }
    },
    //点击某一页时，currentpage为页码
    currentChange(currentpage) {
      this.$store.commit("setPageNum", currentpage);
      this.getData();
    },
    //前往文章详情页
    async goToArticleDetails(id) {
      this.$router.push(`/article/details/${id}`);
      await addReadNumApi({ id });
    },
    goToUserDetails(userId) {
      this.$router.push({ path: `/article/release_manage/${userId}` });
    },
  },
  watch: {
    searchForm: {
      async handler() {
        await this.getData();
      },
      deep: true,
    },
  },
 /*  setup() {
      // swiper相关配置属性放在swiper_options这个变量里
      let swiper_options = reactive({
        autoplay: {
          disableOnInteraction: false, // 鼠标滑动后继续自动播放
          delay: 4000, //4秒切换一次
        },
        speed: 500, //切换过渡速度
        loop: true,
        slidesPerView: "auto", //解决最后一张切换到第一张中间的空白
        centeredSlides: true, //设置slide居中
        spaceBetween: 20,
        coverflowEffect: {
          // rotate: 0, //slide做3d旋转时Y轴的旋转角度。默认50。
          stretch: 50, //每个slide之间的拉伸值（距离），越大slide靠得越紧。 默认0。
          depth: 100, //slide的位置深度。值越大z轴距离越远，看起来越小。 默认100。
          modifier: 1, //depth和rotate和stretch的倍率，相当于            depth*modifier、rotate*modifier、stretch*modifier，值越大这三个参数的效果越明显。默认1。
          // slideShadows: false, //开启slide阴影。默认 true。
        },
        navigation: {
          nextElRef: ".swiper-button-next",
          prevElRef: ".swiper-button-prev",
        },
        pagination: {
          clickable: true,
        },
      });
      // 将swiper_options返回给模板中的swiper组件使用
      return { swiper_options };
    }, */
};
</script>



<!-- 
<style scoped lang="less">
 @import url("./assets/css/common.css");
/* @import '../../assets/css/common.css'; */
@import './assets/css/index.css';
@import './assets/css/module.css';
@import './assets/css/swipe.min.css';

</style> -->
<!-- 
<style lang="scss" scoped>
.swiper-wrapper {
  img {
    width: 100%;
    height: 300px;
  }
} 
 -->
</style>
<style scoped lang="less">

.index {
  width: 100%;
  min-height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;

  .index-main {
    border-radius: 10px;
    box-shadow: 0 0px 30px 3px #aaa;
    padding: 20px 20px 0px 20px;
    .tb-t-top {
      font-size: 20px;
      font-weight: 520;
      height: 32px;
      line-height: 32px;
      color: #333;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
	  margin-left:350px;

      &:hover {
        cursor: pointer;
        color: #0099ff;
      }
    }
    .tb-t-center {
      margin-bottom: 20px;
      word-break: break-all;
      text-overflow: ellipsis;
      overflow: hidden;
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
      font-size: 14px;
      height: 55px;
      color: #999;
	  margin-left:50px;

      p {
        margin: 7px 0px;
      }
    }
    .tb-t-bottom-right {
      display: flex;
      justify-content: space-between;
      height: 40px;
       margin-left:50px;
      div {
        flex: 1;
        display: flex;
        justify-content: flex-start;
        align-items: center;

        img {
          width: 32px;
          height: 32px;
          cursor: pointer;
          border-radius: 50%;
        }
        span {
          color: #999;
          font-size: 12px;
        }
        span:nth-child(2) {
          margin: 0px 20px;
        }
        .nickname {
          cursor: pointer;
        }
        .nickname:hover {
          color: #0099ff;
        }
      }
      .icon-box {
        .el-icon-view {
          margin-right: 2px;
          font-size: 14px;
        }
        .el-icon-chat-dot-round {
          margin-right: 2px;
          font-size: 14px;
        }
        .el-icon-thumb {
          margin-right: 2px;
          font-size: 14px;
        }
      }
    }
	
  }
  .el-table ::v-deep {
    .el-table__header-wrapper {
      display: none;
    }
    .image-slot {
      font-size: 30px;
      display: flex;
      justify-content: center;
      align-items: center;
      width: 100%;
      height: 100%;
      background: #f5f7fa;
      color: #909399;
    }
  }
  .page-box {
    text-align: center;
    margin: 20px 0px 40px 0px;
  }
}
</style>