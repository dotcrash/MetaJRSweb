package com.luo.bhfront.Entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Data
@TableName("f_article")
@Component
public class fArticle {
    @TableId(type = IdType.AUTO)
    private Long uid;
    private String title;
    private String content;
    private String contentHtml;
    private Integer loveCount;
    private Integer lookCount;
    private Integer commentCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String createTime;
    private Long userUid;
    private String imgs;
}
