package Controller;


import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Model.DatebaseMain;
import Model.contentOutClass;
import Model.loginDatabase;
import Model.loginStatus;
import Model.orderOutClass;
import Model.registStatus;




@RestController
public class controllerMain {
   private static loginDatabase logindatabase=new loginDatabase();
   private static DatebaseMain datebaseMain=new DatebaseMain();

	/*
	 * @RequestMapping("/") public String view(){ return "login"; }
	 */
   //接收login的get请求，传送uid，password字段的json数据集，返回status json数据集，成功status=200，反之300
   @PostMapping("/canteen/visitor/login")
   public loginStatus  loginFun(@RequestBody(required=false) JSONObject jsonParam,HttpServletRequest request, HttpServletResponse response)  {
		
	    System.out.println(jsonParam);
	    loginStatus loginstatus=new loginStatus(datebaseMain.canLogin(logindatabase,
	    		jsonParam.getString("user_telephone"),jsonParam.getString("user_password"),request,response));
	    return loginstatus; 
   }
   
   
   
   @PostMapping("/canteen/visitor/regist")
   public registStatus contentFun(@RequestBody(required=false) JSONObject jsonParam) {
	  registStatus registstatus=new registStatus(datebaseMain.canRegist(logindatabase,
			  jsonParam.getString("user_name"),jsonParam.getString("user_telephone"),jsonParam.getString("user_password")));
	  return registstatus;
   }
   
   
   @PostMapping("/canteen/visitor/windows")
   public contentOutClass menuMain(@RequestBody(required=false) JSONObject jsonParam) {
	   System.out.println(jsonParam);
	   contentOutClass contentoutClass=new contentOutClass();
	   contentoutClass.setFlag(datebaseMain.canMenu(contentoutClass, jsonParam.getString("canteen"),
			   jsonParam.getString("tier"), jsonParam.getString("time")));
	   return contentoutClass;
   }
     
   @PostMapping("/canteen/visitor/finishOrder")
   public orderOutClass finishOrderDisplay(@RequestBody(required=false) JSONObject jsonParam,HttpServletRequest request) {
	   orderOutClass orderoutClass =new orderOutClass();
	   orderoutClass.setFlag(datebaseMain.candisplayOrder(orderoutClass, request, 1));
	   return orderoutClass;
   }
   @PostMapping("/canteen/visitor/nofinishOrder")
   public orderOutClass NofinishOrderDisplay(@RequestBody(required=false) JSONObject jsonParam,HttpServletRequest request) {
	   orderOutClass orderoutClass =new orderOutClass();
	   orderoutClass.setFlag(datebaseMain.candisplayOrder(orderoutClass, request,0));
	   return orderoutClass;
   }
}
