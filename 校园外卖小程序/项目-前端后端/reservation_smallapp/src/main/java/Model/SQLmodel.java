package Model;


import java.util.ArrayList;

public class SQLmodel {
    private String tablename=null;
    public SQLmodel(String tablename) {
		this.tablename=tablename;
	}
    
    public String Select(ArrayList<String> field,ArrayList<String> conditionList) {
		String sql=null;
		if (field.isEmpty()) {
			if (conditionList.isEmpty()) {
				sql=" SELECT  *  FROM "+this.tablename;
			}else {
				sql=" SELECT * FROM "+this.tablename+" WHERE ";
				for(int i = 0 ; i <conditionList.size(); i++) {
				   sql=sql+conditionList.get(i)+"=? ";
				   if (i!=conditionList.size()-1) {
				   sql=sql+" AND ";
				   }
				}
			}
			
		}else {
			sql=" SELECT ";
			for(int i = 0 ; i <field.size(); i++) {
				   sql=sql+field.get(i);
				   if (i!=field.size()-1) {
				   sql=sql+",";
				   }else {
					sql=sql+" FROM "+this.tablename;
				}
			}
			if (!conditionList.isEmpty()) {
				sql=sql+" WHERE ";
				for(int i = 0 ; i <conditionList.size(); i++) {
					   sql=sql+conditionList.get(i)+"=? ";
					   if (i!=conditionList.size()-1) {
					   sql=sql+" AND ";
					   }
				}
			}
		}
    	return sql; 
	}
    public String Insert(int num) {
		String sql=null;
		sql=" INSERT INTO "+this.tablename+" VALUES(NULL ";
		for(int i = 0 ; i <num; i++) {
			   sql+=",?";
		}
		sql+=")";
    	return sql; 
	}
	public String Update(ArrayList<String> field,ArrayList<String> conditionList) {
		String sql=null;
		if (!field.isEmpty()){
			sql=" UPDATE "+this.tablename+" SET ";
			for(int i = 0 ; i <field.size(); i++) {
				   sql=sql+field.get(i)+"=?";
				   if (i!=field.size()-1) {
				   sql=sql+",";
				   }
			}
			if (!conditionList.isEmpty()) {
				sql=sql+" WHERE ";
				for(int i = 0 ; i <conditionList.size(); i++) {
					   sql=sql+conditionList.get(i)+"=? ";
					   if (i!=conditionList.size()-1) {
					   sql=sql+" AND ";
					   }
				}
			}
		}
    	return sql; 
	}
	public String Delete(ArrayList<String> conditionList) {
		String sql=null;
			
		if (!conditionList.isEmpty()) {
		   sql=" DELETE  FROM "+this.tablename+" WHERE ";
				for(int i = 0 ; i <conditionList.size(); i++) {
				   sql=sql+conditionList.get(i)+"=? ";
				   if (i!=conditionList.size()-1) {
				   sql=sql+" AND ";
				   }
				}
			}
		
    	return sql; 
	}
}
