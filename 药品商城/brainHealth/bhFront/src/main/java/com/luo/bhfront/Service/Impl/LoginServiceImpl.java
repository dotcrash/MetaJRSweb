package com.luo.bhfront.Service.Impl;

import com.luo.bhfront.Entity.fUser;
import com.luo.bhfront.Service.LoginService;
import com.luo.bhfront.VO.LoginVO;
import com.luo.bhfront.VO.LoginVO_;
import com.luo.bhfront.mapper.UserMapper;
import com.luo.bhutils.CommonsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//导入UUID包

@Service

public  class LoginServiceImpl  implements LoginService {
    @Resource
    UserMapper userMapper;
    @Autowired
    LoginVO loginVO;

    public String login(LoginVO_ loginVO_){
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
    }
}
