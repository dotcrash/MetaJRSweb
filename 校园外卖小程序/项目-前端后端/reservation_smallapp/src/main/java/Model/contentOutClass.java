package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.data.relational.core.sql.Values;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

public class contentOutClass  {
	private boolean flag;

	private ArrayList<contentInterClass> menuArr = new ArrayList<contentInterClass>();

	public void clear() {
		this.menuArr.clear();
	}
	public ArrayList<contentInterClass> getMenuArr() {
		return this.menuArr;
	}
	public void setMenuArr(ArrayList<contentInterClass> MenuArr) {
		this.menuArr=MenuArr;
	}
	public boolean getFlag() {
		return this.flag;
	}
	public void setFlag(boolean Flag) {
		this.flag=Flag;
	}
	
	
}
