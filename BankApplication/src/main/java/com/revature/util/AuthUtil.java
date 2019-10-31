package com.revature.util;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class AuthUtil {
	public static final AuthUtil instance = new AuthUtil();

	private static UserDao userDao = UserDao.currentImplementation;
	private static User currentUser = null;

	private AuthUtil() {
		super();
	}

	public static User login(String username, String password) {
		User u = userDao.findByUsernameAndPassword(username, password);
		currentUser = u;
		return u;
	}

	public static User getCurrentUser() {
		return currentUser;
	}
}
