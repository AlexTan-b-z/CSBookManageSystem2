package model;

public class User {

	public String uid;
	public String username;
	public String password;
	public String borrowtime;
	
	public User(String uid,String username,String password,String borrowtime){
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.borrowtime = borrowtime;
	}
}
