package Model;



public class loginDatabase {
	private int id=-1;  //users' id
	private String role=""; //users' role
	private String telephone=""; // users' telephone
	private String password=""; // users' password
	
	public void setId(int Id) {
		this.id=Id;
	}
	public int getId() {
		return this.id; 
	}
	
	public void setRole(String Role) {
		this.role=Role;
	}
	public String getRole() {
		return this.role;
	}
	
	public void setTelephone(String Telephone) {
		this.telephone=Telephone;
	}
	public String getTelephone() {
		return this.telephone;
	}
	
	public void setPassword(String Password) {
		this.password=Password;
	}
	public String getPassword() {
		return this.password;
	}
	
	
}
