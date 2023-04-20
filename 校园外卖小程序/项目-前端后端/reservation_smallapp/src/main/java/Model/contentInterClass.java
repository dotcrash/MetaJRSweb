package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class contentInterClass {
	/*私有字段及其封装*/
	private int id;
	private String title;
	private List<Map<String, String>> subArr=new ArrayList<Map<String,String>>();
	
	public int getId() {
		return this.id;
	}
	public void setId(int Id) {
		this.id=Id;
	}
	
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String Title) {
		this.title=Title;
	}
	public void setSubArr(List<Map<String, String>> SubArr) {
		this.subArr=SubArr;
	}
	public List<Map<String, String>> getSubArr() {
		return this.subArr;
	}
	
}
