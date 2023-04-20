package Model;

import java.util.ArrayList;

public class orderOutClass {

	private ArrayList<orderClass> data=new ArrayList<orderClass>();
	private boolean flag;
	public void setData(ArrayList<orderClass> Data) {
		this.data=Data;
	}
	public ArrayList<orderClass> getData(){
		return this.data;
	}
	  public void setFlag(boolean Flag) {
			this.flag=Flag;
		}
	       public boolean getFlag() {
	   		return this.flag;
	   	}

}
