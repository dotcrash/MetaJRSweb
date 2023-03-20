
<template>
  <div class="forum_wrap">
   <articleMain v-if="$route.path === '/'"></articleMain>
	<index v-if="$route.path === '/shop'"></index>
	<newsMain v-if="$route.path === '/news'"></newsMain>
    <router-view v-else></router-view>
  </div>
</template>

<script>
import articleMain from "@/views/article/articleMain/articleMain.vue";
import index from "@/components/Index.vue";
import newsMain from "@/views/news/newsMain/newsMain.vue";
export default {
  name: "forumMain",
  components: { articleMain,newsMain,index:()=>import("@/components/Index.vue")},
};
</script>
