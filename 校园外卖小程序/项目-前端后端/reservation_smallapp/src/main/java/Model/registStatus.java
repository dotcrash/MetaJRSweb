package Model;

public class registStatus {
	 private String registMsg=null;
public registStatus(boolean can) {
	if(can) {
		this.registMsg="注册成功！";
	}else {
		this.registMsg="失败，请稍后再试！！！";
	}
}
public void setRegistMsg(String Errortext) {
		this.registMsg=Errortext;
	}
      public String getRegistMsg() {
  		return this.registMsg;
 	}
}