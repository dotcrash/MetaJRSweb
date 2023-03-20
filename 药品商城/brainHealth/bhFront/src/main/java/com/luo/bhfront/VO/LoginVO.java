package com.luo.bhfront.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class LoginVO {
    private Long _id;
    private String account;
    private String password;
    private String nickName;
    private Integer gender;
    private String avatar;
    private String email;
    private Date birth;
    private String mobile;
    private String summary;
    private Integer loginCount;
    private Date createTime;
}
