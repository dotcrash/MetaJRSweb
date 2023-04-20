package Model;

public class loginStatus {
       private boolean flag;
       private String errorMsg=null;
       public loginStatus() {
   		
   	}
       public loginStatus(boolean can) {
		if (can) {
			this.flag=true;
		}else {
			this.flag=false;
			this.errorMsg="登入失败，请稍后再试！！！";
		}
		
	}
       public void setFlag(boolean Flag) {
		this.flag=Flag;
	}
       public boolean getFlag() {
   		return this.flag;
   	}
       public void setErrorMsg(String Errortext) {
   		this.errorMsg=Errortext;
   	}
          public String getErrorMsg() {
      		return this.errorMsg;
      	}
}
