package entity;

public class Account {
	private int uid;
	private String user;
	private String pass;
	private int isshell;
	private int isadmin;
	private String name;
	private int age;
	private String address;	
	public Account(int uid, String user, String pass, int isshell, int isadmin,String name,int age, String address) {
		super();
		this.uid = uid;
		this.user = user;
		this.pass = pass;
		this.isshell = isshell;
		this.isadmin = isadmin;
		this.name = name;
		this.age = age;
		this.address = address;
		
	}	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getIsshell() {
		return isshell;
	}
	public void setIsshell(int isshell) {
		this.isshell = isshell;
	}
	public int getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Account [uid=" + uid + ", user=" + user + ", pass=" + pass + ", isshell=" + isshell + ", isadmin="
				+ isadmin + ", name=" + name + ", address=" + address + ", age=" + age + "]";
	}
	
}
