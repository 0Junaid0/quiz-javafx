package application;

import java.util.ArrayList;

public class UsersDatabase {

	private static ArrayList<User> users = new ArrayList<User>();
	
	/**
	 * Add a new user to the database.
	 * @param user
	 */
	public static void addUser(User user) {
		users.add(user);
	}

	/**
	 * Validate the username and password and return the verified user.
	 * @param username
	 * @param password
	 * @return verified user or null.
	 */
	public static User validateLogin(String username, String password) {
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			// Return the user that matches the given username and password.
			if (u.username.equals(username) && u.password.equals(password)) {
				return u;
			}
		}
		return null;
	}
}

