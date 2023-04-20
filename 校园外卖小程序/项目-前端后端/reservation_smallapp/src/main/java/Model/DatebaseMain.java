package Model;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class DatebaseMain  {
	private DataSource datasource;
	//数据库配置
	public DatebaseMain() { 
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
	    dataSource.setUrl("jdbc:mysql://localhost:3306/reservation?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8");
	    dataSource.setUsername("root");//用户名
	    dataSource.setPassword("root");//密码
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    this.datasource=dataSource;
	    this.jdbcTemplate=new JdbcTemplate(dataSource);
	 }
	private String tableName = ""; // table name
	
	private String sqltext = "";
	//绑定数据源
	private JdbcTemplate jdbcTemplate ;

	public void setTableName(String name) {
		this.tableName = name;
	}

	public String getTableName() {
		return this.tableName;
	}

	public boolean canLogin(loginDatabase logindatabase, String Tele, String Password,HttpServletRequest request, HttpServletResponse response) {
        boolean canlogin=false;
		//Boolean canlogin = false; // can login
		// 1、获取提交的值
		logindatabase.setTelephone(Tele);
		logindatabase.setPassword(Password);
		// 2、查值
		this.tableName = " client ";
		SQLmodel sqLmodel=new SQLmodel(this.tableName);
		ArrayList<String> field = new ArrayList<String>();
		ArrayList<String> conditionList = new ArrayList<String>();
		field.add(" id ");
		conditionList.add(" telephone ");
		conditionList.add(" password ");
		this.sqltext=sqLmodel.Select(field, conditionList);
		/* System.out.println(this.sqltext); */
		List<Map<String, Object>> list = this.jdbcTemplate.queryForList(this.sqltext,Tele,Password);
		if (list.isEmpty()==false) {
			canlogin = true;
			//加cookie
			Cookie cookie = new Cookie("userId",list.get(0).get("id").toString());
		    cookie.setHttpOnly(true);
		    cookie.setPath("/");
		    cookie.setDomain("localhost");
		    response.addCookie(cookie);
		}
		this.tableName = "";
		return canlogin;
	}
	public boolean canRegist(loginDatabase logindatabase, String name,String Tele, String Password) {
        boolean canlogin=false;
		//Boolean canlogin = false; // can login
		// 1、获取提交的值
		/*
		 * logindatabase.setTelephone(Tele); logindatabase.setPassword(Password);
		 */
		// 2、查值
		this.tableName = " client ";
		SQLmodel sqLmodel=new SQLmodel(this.tableName);
		ArrayList<String> field = new ArrayList<String>();
		ArrayList<String> conditionList = new ArrayList<String>();
		field.add(" id ");
		conditionList.add(" telephone ");
		this.sqltext=sqLmodel.Select(field, conditionList);
		/* System.out.println(this.sqltext); */
		List<Map<String, Object>> list = this.jdbcTemplate.queryForList(this.sqltext,Tele,Password);
		if (list.isEmpty()==true) {
			field.clear();
			conditionList.clear();
			this.sqltext=sqLmodel.Insert(6);
			int flag=this.jdbcTemplate.update(this.sqltext,name,"student",Tele,"",name,Password);
			if (flag!=0) {
				canlogin = true;
			}
			//加cookie
			
		}
		
		this.tableName = 
				"";
		return canlogin;
	}
	public boolean canMenu(contentOutClass contentoutClass , String area,String floor, String time) {
        boolean canMenu=false;
        try {
		
        timeFormat timeformat=new timeFormat();
        float timeInt=timeformat.timeformat(time);
        
        int addressId=0;
        SQLmodel sqLmodel=new SQLmodel(" dininghall ");
		ArrayList<String> field = new ArrayList<String>();
		ArrayList<String> conditionList = new ArrayList<String>();
		field.add(" id ");
		conditionList.add(" name ");
		conditionList.add(" parentname ");
		this.sqltext=sqLmodel.Select(field, conditionList);
		List<Map<String, Object>> list = this.jdbcTemplate.queryForList(this.sqltext,floor,area);
        addressId=(int)list.get(0).get("id");
        
        
        field.clear();
        conditionList.clear();
        sqLmodel=new SQLmodel(" food ");
        field.add(" id ");
        field.add(" name ");
        field.add(" value ");
        field.add(" windowName ");
        conditionList.add(" addressid ");
        conditionList.add(" isenough ");
        this.sqltext=sqLmodel.Select(field, conditionList);
        this.sqltext+=" AND starttime <= ? ";
        System.out.println(this.sqltext);
        
        List<Map<String, Object>> foodList=this.jdbcTemplate.queryForList(this.sqltext,addressId,1,timeInt);
        for (Iterator iterator = foodList.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();	
			ArrayList<contentInterClass> temlist=new ArrayList<contentInterClass>();
			temlist=contentoutClass.getMenuArr();
			int rank=temlist.size();
			int Windindex=-1;
			 for (int i=0;i<temlist.size();i++) {
				 if(temlist.get(i).getTitle().equals(map.get("windowName").toString())) {
					 temlist.get(i).setId(rank);
					 List<Map<String, String>> teminterList=temlist.get(i).getSubArr();
					 Map<String,String> temMap=new HashMap<String, String>();
					 temMap.put("imgDesc",map.get("name").toString());
					 temMap.put("imgSrc","/Images/menu/"+map.get("id").toString()+".jpg");
					 temMap.put("value", map.get("value").toString());
					 teminterList.add(temMap);
					 temlist.get(i).setSubArr(teminterList);
					 break;
				 }
			 }
			 if(Windindex==-1) {
				 contentInterClass contentinterClass=new contentInterClass();
				 contentinterClass.setTitle(map.get("windowName").toString());
				 contentinterClass.setId(rank+1);
				 temlist.add(contentinterClass);
				 List<Map<String, String>> teminterList=temlist.get(rank).getSubArr();
				 Map<String,String> temMap=new HashMap<String, String>();
				 temMap.put("imgDesc",map.get("name").toString());
				 temMap.put("imgSrc","/Images/menu/"+map.get("id").toString()+".jpg");
				 temMap.put("value", map.get("value").toString());
				 teminterList.add(temMap);
				 temlist.get(rank).setSubArr(teminterList);
			 }
			 contentoutClass.setMenuArr(temlist);
		}
        canMenu=true;
	} catch (Exception e) {
		// TODO: handle exception
	}
        
        return canMenu;
        
        
	}
	
	
	public boolean candisplayOrder(orderOutClass orderoutClass,HttpServletRequest request,int status) {
		boolean candisplay=false;
		try {
			
		
		String cookieName="userid";
		int clientId=0;
		Cookie[] cookies=request.getCookies();
	    for (Cookie cookie : cookies) {
	    	    if(cookieName.equals(cookie.getName())){
	    	    	clientId=Integer.valueOf(cookie.getValue());
	    	     }
	    }
	    SQLmodel sqLmodel=new SQLmodel(" orderlist ");
		ArrayList<String> field = new ArrayList<String>();
		ArrayList<String> conditionList = new ArrayList<String>();
		
		field.add(" id ");
		field.add(" foodid ");
		conditionList.add(" userid ");
		conditionList.add(" status ");
		this.sqltext=sqLmodel.Select(field, conditionList);
		List<Map<String, Object>> list = this.jdbcTemplate.queryForList(this.sqltext,clientId,status);
		ArrayList<orderClass> temList=new ArrayList<orderClass>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			orderClass orderclass=new orderClass();
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			sqLmodel=new SQLmodel(" food ");
			field.clear();
			conditionList.clear();
			field.add(" name ");
			field.add(" addressid ");
			field.add(" value ");
			field.add(" windowName ");
			conditionList.add(" id ");
			this.sqltext=sqLmodel.Select(field, conditionList);
			System.out.println(this.sqltext);
			List<Map<String, Object>> foodlist = this.jdbcTemplate.queryForList(this.sqltext,Integer.valueOf(map.get("id").toString()));
			sqLmodel=new SQLmodel(" dininghall ");
			field.clear();
			conditionList.clear();
			field.add(" name ");
			field.add(" parentname ");
			conditionList.add(" id ");
			this.sqltext=sqLmodel.Select(field, conditionList);
			List<Map<String, Object>> addressname = this.jdbcTemplate.queryForList(this.sqltext,Integer.valueOf(foodlist.get(0).get("addressid").toString()));
			orderclass.setFoodname(addressname.get(0).get("parentname").toString()+" > "+addressname.get(0).get("name").toString()+" > "+ foodlist.get(0).get("windowName").toString()+">>"+foodlist.get(0).get("name").toString());
			orderclass.setValue(foodlist.get(0).get("value").toString());
			temList.add(orderclass);
		}
	    orderoutClass.setData(temList);	  
	    candisplay=true;
	} catch (Exception e) {
		// TODO: handle exception
	}
		return candisplay;
	}
	
	
	
	
}
