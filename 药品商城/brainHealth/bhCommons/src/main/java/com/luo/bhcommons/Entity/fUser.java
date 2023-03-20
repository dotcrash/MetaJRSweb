package com.luo.bhcommons.Entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Data
@TableName("f_user")
public class fUser {
    @TableId(value = "uid")
    private Integer uid;
/*    private static final long serialVersionUID = 1L;*/
    private String account;
    private String password;
    private String nickName;
    private Integer gender;
    private String avatar;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private String mobile;
    private String summary;
    private Integer loginCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
