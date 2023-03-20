package com.luo.bhfront.Controller;


import com.luo.bhfront.Service.Impl.ArticleServiceImpl;
import com.luo.bhfront.Service.Impl.LoginServiceImpl;
import com.luo.bhfront.VO.ArticleVO_;
import com.luo.bhfront.VO.LoginVO_;
import com.luo.bhfront.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/front")
@Slf4j
@Component
@CrossOrigin
public class controller  {

    @Resource
    private UserMapper userMapper;
    @Autowired    //自动装配
    private LoginServiceImpl loginServicelmpl ;
    @Autowired
    private ArticleServiceImpl articleServiceImpl;
    @PostMapping("/login")
    public String getDepartment(@RequestBody LoginVO_  loginVO_) {
        return loginServicelmpl.login(loginVO_);
    }

    @CrossOrigin
    @PostMapping("/article/allArticles")
    public String getArticle(@RequestBody ArticleVO_ articleVO_) {
        return articleServiceImpl.getArticleById(articleVO_);
    }
    @CrossOrigin
    @PostMapping("/article/send")
    public String sendArticle(@RequestBody ArticleVO_ articleVO_) {
        return articleServiceImpl.addArticle(articleVO_);
    }
   /* @CrossOrigin
    @PostMapping("/article/send")
    public String register(@RequestBody RegisterVO registerVO) {

    }*/



}
