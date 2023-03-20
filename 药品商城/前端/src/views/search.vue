<template>
  <div class="home_wrap">
    <el-container>
      <el-header>
        <forum-header />
      </el-header>
     <!-- <el-main>
      <div class="index">
        <div class="index-main">
           <div  style="font-size: 20px;font-weight:1000">疾病名称</div>
		   <div>脑卒中</div>
		   <div style="font-size: 20px;font-weight:1000">疾病详情</div>
		   <div>引起脑卒中的原因包括性别、年龄、家族史、高血压、糖尿病、高脂血症等。</div>
           <div>脑卒中是一种急性脑血管疾病，是由于脑部血管突然破裂或因血管阻塞导致血液不能流入大脑而引起脑组织损伤的一组疾病。</div>
		   <div>脑卒中的病因可分为不可控因素如性别、年龄、家族史、基因等原因；可控因素如高血压、糖尿病、高脂血症等基础疾病，亦</div>
		   <div>有房颤、心肌梗死等心脏疾病，还有血管炎、动脉夹层、颈动脉斑块等不常见因素，经药物调控或生活方式改变后，可有一定改善。</div>
		   <div>脑卒中常见的症状有说话不清楚、口角流口水、一侧口角歪斜、伸舌歪向一边、一侧肢体的麻木或者无力、头痛、头晕、走路不稳、</div>
		   <div>突发的记忆力下降等。</div>
		   <div style="font-size: 20px;font-weight:1000">疾病治疗</div>
           <div>脑卒中的治疗需根据其分类进行治疗。脑卒中主要包括出血性卒中和缺血性卒中。出血性卒中，主要是通过药物保守治疗和手术治疗，</div>
		   <div>药物保守治疗方面主要是应用促进出血吸收、减轻脑水肿和营养脑细胞的药物，具体包括甘露醇、七叶皂苷注射液、胞磷胆碱注射液、</div>
		   <div>奥拉西坦注射液等；缺血性脑卒中主要包括脑血栓形成和脑栓塞，脑血栓形成主要是应用抗血小板聚集、营养脑细胞和稳定斑块的药物</div>
		   <div>进行治疗，具体包括阿司匹林、氯吡格雷、瑞舒伐他汀、胞磷胆碱胶囊等。</div>
           <div>脑卒中患者应注意饮食，生活中要少吃快餐，避免进食油炸食物，多食用蔬菜、水果，补充维生素和膳食纤维，还应坚持用药，出院后</div>
		   <div>遵医嘱合理用药，有效预防脑卒中复发。因为脑卒中复发率较高，因此不可以因病情好转而自行停药或减药，需定期到脑血管病门诊复诊；</div>
		   <div>注意改善生活作息，不宜过度劳累，如果患者出现肢体偏瘫，还应减少身体受压、勤翻身、保持皮肤清洁卫生，以免发生褥疮等。</div>
          <div class="page-box" v-if="tableData.length">
            <el-pagination :current-page.sync="nowPageNum" background layout="prev, pager, next" :total="Math.ceil(total / 2)" @current-change="currentChange"></el-pagination>
          </div>
        </div>
      </div>
      </el-main> -->
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
import { getArticleData, addReadNumApi } from "@/api/api";
export default {
  name: "search",
  components:{  forumHeader,
    forumFooter,
    forumMain,},
  data() {
    return {
      tableData: [
		{"_id":1,"title":"脑系疾病的自述","readNum": 50,"commentNum":3,"likeNum":20,"createdTime":"2022-05-06",
		"userId":{"_id":1,"nickname":"爱开发的小罗","avatar": "/static/img/avatar/1.jpg"},
		"articleImgs":["/static/img/content/1.jpg",""]},
		{"_id":2,"title":"欢迎访问脑疗多功能系统","readNum": 50,"commentNum":3,"likeNum":20,"createdTime":"2022-05-02",
		"userId":{"_id":1,"nickname":"爱开发的小罗1","avatar": "/static/img/avatar/2.jpg"},
		"articleImgs":["/static/img/content/2.jpg",""]},
		{"_id":3,"title":"大家可以点我头像哈","readNum": 50,"commentNum":3,"likeNum":20,"createdTime":"2022-05-02",
		"userId":{"_id":1,"nickname":"爱开发的小罗2","avatar": "/static/img/avatar/3.jpg"},
		"articleImgs":["/static/img/content/3.jpg",""]},
		{"_id":1,"title":"脑系疾病的自诊","readNum": 50,"commentNum":3,"likeNum":20,"createdTime":"2022-05-01",
		"userId":{"_id":1,"nickname":"爱开发的小罗3","avatar": "/static/img/avatar/2.jpg"},
		"articleImgs":["/static/img/content/4.jpg",""]}
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
};
</script>

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

      p {
        margin: 7px 0px;
      }
    }
    .tb-t-bottom {
      display: flex;
      justify-content: space-between;
      height: 40px;

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