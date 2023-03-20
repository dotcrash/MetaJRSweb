package com.luo.bhfront.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {
    @Insert("INSERT INTO f_article (title,content,contentHtml,love_count,look_count,comment_count,create_time,user_uid,imgs) VALUES(#{title},#{content},#{contentHtml},#{love_count},#{look_count},#{comment_count},#{create_time},#{user_uid},#{imgs})")
    public int addArticle(String title, String content, String contentHtml, int love_count, int look_count, int comment_count , Date create_time,Long user_uid,String imgs);

    @Select("SELECT f_article.*,f_user.* FROM f_article,f_user WHERE f_article.user_uid=f_user.uid ORDER BY f_article.uid DESC")
    public List<Map<String, Object>> getArticleById();
}
