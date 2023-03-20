package com.luo.bhfront.Service;


import com.luo.bhfront.VO.ArticleVO_;

public interface ArticleService {

    public  String   addArticle(ArticleVO_ articleVO_);
    public  String   getArticleByLoveCount(ArticleVO_ articleVO_);
    public  String   getArticleById(ArticleVO_ articleVO_);
}
