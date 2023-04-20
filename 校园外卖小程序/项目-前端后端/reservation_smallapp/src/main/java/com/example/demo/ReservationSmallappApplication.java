package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication(scanBasePackages="Controller")
public class ReservationSmallappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationSmallappApplication.class, args);
	}
	@Bean 
	public HttpMessageConverters fastJsonHttpMessageConverters(){
	  FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
	  List<MediaType> supportedMediaTypes = new ArrayList<>();
	  supportedMediaTypes.add(MediaType.APPLICATION_JSON);
	  supportedMediaTypes.add(MediaType.APPLICATION_JSON);
	  supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
	  supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
	  supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
	  supportedMediaTypes.add(MediaType.APPLICATION_PDF);
	  supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
	  supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
	  supportedMediaTypes.add(MediaType.APPLICATION_XML);
	  supportedMediaTypes.add(MediaType.IMAGE_GIF);
	  supportedMediaTypes.add(MediaType.IMAGE_JPEG);
	  supportedMediaTypes.add(MediaType.IMAGE_PNG);
	  supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
	  supportedMediaTypes.add(MediaType.TEXT_HTML);
	  supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
	  supportedMediaTypes.add(MediaType.TEXT_PLAIN);
	  supportedMediaTypes.add(MediaType.TEXT_XML);
	  fastConverter.setSupportedMediaTypes(supportedMediaTypes);
	
	  FastJsonConfig fastJsonConfig = new FastJsonConfig();
	  fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	  fastConverter.setFastJsonConfig(fastJsonConfig);
	  HttpMessageConverter<?> converter =fastConverter; 
	  return new HttpMessageConverters(converter);
	  }
	 

}
