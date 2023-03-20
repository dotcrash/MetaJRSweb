package com.luo.bhfront.Service.Impl;

import com.luo.bhfront.mapper.UserMapper;

import javax.annotation.Resource;

public class RegisterServiceImpl {
    @Resource
    UserMapper userMapper;


   /* public String register(RegisterVO registerVO){
        //service层生成随机token
        String token = String.valueOf(UUID.randomUUID());
        Map<String,Object> mapObj=new HashMap<String,Object>();
        Map<String,Object> loginVO3=new HashMap<String,Object>();
        fUser fuser=userMapper.getUserByacps(loginVO_.getNickname(),loginVO_.getPassword());
        if (fuser!=null){
            loginVO3.put("_id",fuser.getUid());
            loginVO3.put("avatar",fuser.getAvatar());
            mapObj.put("code",200);
            mapObj.put("data",loginVO3);
            mapObj.put("Message","成功");
            mapObj.put("token",token);
        }else {
            mapObj.put("code",700);
            mapObj.put("data",null);
            mapObj.put("Message","失败");
        }
        return CommonsUtils.Bean2Json(mapObj);
    }*/
}
