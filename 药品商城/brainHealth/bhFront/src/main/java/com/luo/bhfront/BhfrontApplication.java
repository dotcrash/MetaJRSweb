package com.luo.bhfront;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@MapperScan("com.luo.bhfront.mapper")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})

@ComponentScan(basePackages = {"com.luo.bhutils",
        "com.luo.bhfront",
        "com.luo.bhfront.Controller",
        "com.luo.bhfront.Service",
        "com.luo.bhfront.Entity",
        "com.luo.bhfront.mapper",
        "com.luo.bhfront.Service.Impl"

})
public class BhfrontApplication  {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(BhfrontApplication.class, args);

    }

}
