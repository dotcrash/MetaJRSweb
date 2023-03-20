package com.luo.bhcommons;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value="com.luo.bhcommons.Mapper")

public class BhCommonsApplication {

    public static void main(String[] args) {

        SpringApplication.run(BhCommonsApplication.class, args);


    }

}
