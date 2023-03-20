package com.luo.bhfront.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class MapObj {
    private List<Object> data=new ArrayList<Object>();
    private int code;
    private String Message;
    private  String token;

}
