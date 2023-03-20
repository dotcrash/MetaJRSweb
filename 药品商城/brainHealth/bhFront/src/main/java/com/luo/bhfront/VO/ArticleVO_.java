package com.luo.bhfront.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
public class ArticleVO_ {

    private String title;

    private  String  contentText;

    private String contentHtml;

    private Long userId;

    private List<String> articleImgs;

}
