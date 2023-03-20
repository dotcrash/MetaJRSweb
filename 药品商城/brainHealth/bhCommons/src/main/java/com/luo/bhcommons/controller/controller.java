package com.luo.bhcommons.controller;


import com.luo.bhcommons.Entity.fUser;
import com.luo.bhcommons.Mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.InputStream;

@RestController
@RequestMapping("/api/front")
@Slf4j
public class controller  {

    @Autowired
    @Resource
    private UserMapper userMapper;
    @PostMapping("/login/{id}")
    public fUser getDepartment(@PathVariable("id") Integer id) {
        System.out.print(userMapper.getUserById(id));
        return userMapper.getUserById(id);
    }

}
