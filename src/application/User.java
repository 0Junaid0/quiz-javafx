package application;

public class User {
	public String username;
	public String password;
	public String role;
	
	public static String ROLE_ADMIN = "admin";
	public static String ROLE_STUDENT = "student";
	public static String ROLE_FACULTY = "faculty";
	
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
