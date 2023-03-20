package com.luo.bhfront.Service.Impl;

import com.luo.bhfront.Entity.fArticle;
import com.luo.bhfront.Service.ArticleService;
import com.luo.bhfront.VO.ArticleVO_;
import com.luo.bhfront.mapper.ArticleMapper;
import com.luo.bhutils.CommonsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public  class ArticleServiceImpl  implements ArticleService {
    @Resource
    ArticleMapper articleMapper;
    @Autowired
    ArticleVO_ articleVO_;
  /*  @Autowired
    fArticle article;*/

    public  String addArticle(ArticleVO_ articleVO_){
         fArticle article=new fArticle();
         article.setUserUid(articleVO_.getUserId());
         article.setTitle(articleVO_.getTitle());
         article.setLoveCount(0);
         article.setCommentCount(0);
         article.setContent(articleVO_.getContentText());
         article.setLookCount(0);

         String imgsurl="";
        for (String img:articleVO_.getArticleImgs()) {
            imgsurl+=img+";";
        }
         //"/static/a/a.jpg;/static/a/a.jpg;/static/a/a.jpg;"
        article.setImgs(imgsurl);
        int flag= articleMapper.addArticle(articleVO_.getTitle(),articleVO_.getContentText()
                ,articleVO_.getContentHtml(),0,0,
                0,null,
                articleVO_.getUserId(),imgsurl);
        Map<String,Object> mapObj=new HashMap<String,Object>();
        if(flag!=-1){
            mapObj.put("code",200);
            mapObj.put("data",null);
            mapObj.put("Message","成功");
        }else{
            mapObj.put("code",700);
            mapObj.put("data",null);
            mapObj.put("Message","失败");
        }
        return   CommonsUtils.Bean2Json(mapObj);
    }
    public  String   getArticleByLoveCount(ArticleVO_ articleVO_){
        Map<String,Object> mapObj=new HashMap<String,Object>();


        return   CommonsUtils.Bean2Json(mapObj);
    }
    public  String   getArticleById(ArticleVO_ articleVO_) {
        Map<String,Object> mapObj=new HashMap<String,Object>();
        List<Map<String, Object>> articleList=articleMapper.getArticleById();
        if (articleList!=null){

            List<Map<String,Object>> total=new ArrayList<Map<String,Object>>();
            mapObj.put("Message","成功");
            mapObj.put("code",200);
            for (Map<String,Object> temp: articleList) {
                Map<String,Object> outer=new HashMap<String,Object>();
                Map<String,Object> inter=new HashMap<String,Object>();

                outer.put("_id",temp.get("uid"));
                outer.put("title",temp.get("title"));
                outer.put("content",temp.get("content"));
                outer.put("contentHtml",temp.get("contentHtml"));
                outer.put("articleImgs",temp.get("imgs").toString().split(";"));
                outer.put("readNum",temp.get("look_count"));
                outer.put("commentNum",temp.get("comment_count"));
                outer.put("likeNum",temp.get("love_count"));
                outer.put("createTime",temp.get("create_time"));

                inter.put("_id",temp.get("user_uid"));
                inter.put("nickname",temp.get("nick_name"));
                inter.put("avatar",temp.get("avatar"));
                outer.put("userId",inter);
                total.add(outer);

            }
            mapObj.put("data",total);

        }
        return   CommonsUtils.Bean2Json(mapObj);
    }


   /* @Override
    public Blog getArticleByUid(String uid) {
        Blog blog = blogMapper.selectById(uid);
        if (blog != null && blog.getStatus() != EStatus.DISABLED) {
            blog = setTagByBlog(blog);
            blog = setSortByBlog(blog);
            return blog;
        }
        return null;
    }
    @Override
    public String addBlog(ArticleVO ArticleVO) {
        HttpServletRequest request = RequestHolder.getRequest();
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.LEVEL, blogVO.getLevel());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        Integer count = blogService.count(queryWrapper);
        // 判断插入博客的时候，会不会超过预期设置
        String addVerdictResult = addVerdict(count + 1, blogVO.getLevel());
        // 判断是否能够添加推荐
        if (StringUtils.isNotBlank(addVerdictResult)) {
            return addVerdictResult;
        }
        Blog blog = new Blog();
        //如果是原创，作者为用户的昵称
        String projectName = sysParamsService.getSysParamsValueByKey(SysConf.PROJECT_NAME_);
        if (EOriginal.ORIGINAL.equals(blogVO.getIsOriginal())) {
            Admin admin = adminService.getById(request.getAttribute(SysConf.ADMIN_UID).toString());
            if (admin != null) {
                if(StringUtils.isNotEmpty(admin.getNickName())) {
                    blog.setAuthor(admin.getNickName());
                } else {
                    blog.setAuthor(admin.getUserName());
                }
                blog.setAdminUid(admin.getUid());
            }
            blog.setArticlesPart(projectName);
        } else {
            blog.setAuthor(blogVO.getAuthor());
            blog.setArticlesPart(blogVO.getArticlesPart());
        }
        blog.setTitle(blogVO.getTitle());
        blog.setSummary(blogVO.getSummary());
        blog.setContent(blogVO.getContent());
        blog.setTagUid(blogVO.getTagUid());
        blog.setBlogSortUid(blogVO.getBlogSortUid());
        blog.setFileUid(blogVO.getFileUid());
        blog.setLevel(blogVO.getLevel());
        blog.setIsOriginal(blogVO.getIsOriginal());
        blog.setIsPublish(blogVO.getIsPublish());
        blog.setType(blogVO.getType());
        blog.setOutsideLink(blogVO.getOutsideLink());
        blog.setStatus(EStatus.ENABLE);
        blog.setOpenComment(blogVO.getOpenComment());
        Boolean isSave = blogService.save(blog);

        //保存成功后，需要发送消息到solr 和 redis
        updateSolrAndRedis(isSave, blog);
        return ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
    }
*/


}
