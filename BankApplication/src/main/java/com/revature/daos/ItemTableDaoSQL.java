package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.ItemTable;
import com.revature.models.ItemTable;
import com.revature.util.AuthUtil;
import com.revature.util.ConnectionUtil;

public class ItemTableDaoSQL implements ItemTableDao {
	ItemTable extractItem(ResultSet rs) throws SQLException {
		int id = rs.getInt("item_id");
		String type = rs.getString("item_name");
		int adventurer = rs.getInt("adventurer");
		return new ItemTable();
	}

	@Override
	public int save(ItemTable i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ItemTable> findAll() {
		// log.debug("attempting to find all users from DB");
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM item";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<ItemTable> items = new ArrayList<ItemTable>();
			while (rs.next()) {
				ItemTable it = new ItemTable(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("adventurer"));
				items.add(it);
			}

			return items;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ItemTable> findByAdventurer(int adventurer) {

		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "Select * FROM item " + "WHERE adventurer = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, adventurer);

			ResultSet rs = ps.executeQuery();
			List<ItemTable> itemTable = new ArrayList<ItemTable>();
			while (rs.next()) {
				ItemTable it = new ItemTable(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("adventurer"));
				itemTable.add(it);
			}
			return itemTable;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String findById(int itemId) {

		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "Select * FROM item " + "WHERE item_id = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			ItemTable itemTable = new ItemTable();
			String itemName = null;
			while (rs.next()) {
				
				itemTable = new ItemTable(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("adventurer"));
				itemName = itemTable.getItem_name();
			}
			
			return itemName;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public String addItem(String item) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO item (item_id, item_name, adventurer) " + "VALUES (item_id_seq.nextval, ?, ?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, item);
			ps.setInt(2, AuthUtil.getCurrentUser().getId());
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return item;

	}

	@Override
	public int rmvItem(int item) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "DELETE FROM item " + "WHERE item_id= (?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, item);
			
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return item;
	}
}
