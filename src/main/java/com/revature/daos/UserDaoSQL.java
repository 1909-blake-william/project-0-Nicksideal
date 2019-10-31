package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDaoSQL implements UserDao {

	//private Logger log = Logger.getRootLogger();

	User extractUser(ResultSet rs) throws SQLException {
		int id = rs.getInt("adventurer_id");
		String rsUsername = rs.getString("username");
		String rsPassword = rs.getString("password");
		String rsRace = rs.getString("race");
		String rsClass_Type = rs.getString("class_type");
		String rsActive = rs.getString("active");
		String role = rs.getString("role_type");
		return new User(id, rsUsername, rsPassword, rsRace, rsClass_Type, rsActive, role);
	}

	@Override
	public int save(User u) {
		//log.debug("attempting to find user by credentials from DB");
		try (Connection c = ConnectionUtil.getConnection()) {
//c.getAutoCommit() 
//c.commit()
			String sql = "INSERT INTO adventurer_users (user_id, username, password, race, class_type) "
					+ " VALUES (adventurer_users_id_seq.nextval ,?,?,?,?) ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getRace());
			ps.setString(4, u.getClass_type());
			
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return 0;
		}
	}

	

	@Override
	public List<User> findAll() {
		//log.debug("attempting to find all users from DB");
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM adventurer_user";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<User>();
			while (rs.next()) {
				users.add(extractUser(rs));
			}

			return users;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
			return null;
		}
	}

	@Override
	public User findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		//log.debug("attempting to find user credentials from DB");
		try (Connection c= ConnectionUtil.getConnection()){
			
			String sql = "Select * FROM adventurer_user " + "WHERE username = ? AND password = ?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return extractUser(rs);
			} else {
				return null;
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
       		e.printStackTrace();
       		System.out.println(e);
			return null;
		}
		
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String findByRole() {
		
			return null;
		}
	

	@Override
	public User findByActive(String active) {
		// TODO Auto-generated method stub
		return null;
	}
}
