package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.CurrencyTable;
import com.revature.models.User;
import com.revature.models.CurrencyTable;
import com.revature.util.AuthUtil;
import com.revature.util.ConnectionUtil;

public class CurrencyTableDaoSQL implements CurrencyTableDao {
	CurrencyTable extractCurrency(ResultSet rs) throws SQLException {
		int id = rs.getInt("account_id");
		int gold = rs.getInt("gold");
		int silver = rs.getInt("silver");
		int copper = rs.getInt("copper");
		int adventurer = rs.getInt("adventurer");
		return new CurrencyTable(id, gold, silver, copper, adventurer);

	}

	@Override
	public int delete(int account_id) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "DELETE FROM currency " + 
			"VALUES (account_id=?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1,account_id);

			ps.executeUpdate();
			if(ps.equals(0) ) {
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return account_id;
	}
	
	@Override
	public int save(int gold, int silver, int copper) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO currency (account_id, gold, silver, copper, adventurer) " + 
			"VALUES (account_id_seq.nextval, ?, ?, ?, ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, gold);
			ps.setInt(2, silver);
			ps.setInt(3, copper);
			ps.setInt(4, AuthUtil.getCurrentUser().getId());

			ps.executeUpdate();
			

			return 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<CurrencyTable> findAll() {
		// log.debug("attempting to find all users from DB");
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM currency";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<CurrencyTable> currency = new ArrayList<CurrencyTable>();
			while (rs.next()) {
				CurrencyTable it = new CurrencyTable(rs.getInt("account_id"), rs.getInt("gold"), rs.getInt("silver"),
						rs.getInt("copper"), rs.getInt("adventurer"));
				currency.add(it);
			}
			
			return currency;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CurrencyTable> findByAdventurer(int adventurer) {

		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "Select * FROM currency " + "WHERE adventurer = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, adventurer);

			ResultSet rs = ps.executeQuery();
			List<CurrencyTable> currencyTable = new ArrayList<CurrencyTable>();
			while (rs.next()) {
				CurrencyTable it = new CurrencyTable(rs.getInt("account_id"), rs.getInt("gold"), rs.getInt("silver"),
						rs.getInt("copper"), rs.getInt("adventurer"));
				currencyTable.add(it);
			}
			return currencyTable;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CurrencyTable> rmvCurrency(int gold, int silver, int copper) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String getRow = "SELECT * FROM currency " + "Where adventurer = ?";

			PreparedStatement qs = c.prepareStatement(getRow);
			qs.setInt(1, AuthUtil.getCurrentUser().getId());

			ResultSet ss = qs.executeQuery();
//			List<CurrencyTable> cTable = new ArrayList<CurrencyTable>();
			CurrencyTable cTable = new CurrencyTable();
			while (ss.next()) {
				cTable = extractCurrency(ss);
			}

			String sql = "UPDATE currency SET gold= ?, silver=?, copper=? " + "Where adventurer = ?";
			int goldChange = cTable.getGold() - gold;
			int silverChange = cTable.getSilver() - silver;
			int copperChange = cTable.getCopper() - copper;

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, goldChange);
			ps.setInt(2, silverChange);
			ps.setInt(3, copperChange);
			ps.setInt(4, AuthUtil.getCurrentUser().getId());

			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return null;

	}

	@Override
	public List<CurrencyTable> addCurrency(int gold, int silver, int copper) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String getRow = "SELECT * FROM currency " + "Where adventurer = ?";

			PreparedStatement qs = c.prepareStatement(getRow);
			qs.setInt(1, AuthUtil.getCurrentUser().getId());

			ResultSet ss = qs.executeQuery();
//			List<CurrencyTable> cTable = new ArrayList<CurrencyTable>();
			CurrencyTable cTable = new CurrencyTable();
			while (ss.next()) {
				cTable = extractCurrency(ss);
			}

			String sql = "UPDATE currency SET gold= ?, silver=?, copper=? " + "Where adventurer = ?";
			int goldChange = cTable.getGold() + gold;
			int silverChange = cTable.getSilver() + silver;
			int copperChange = cTable.getCopper() + copper;
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, goldChange);
			ps.setInt(2, silverChange);
			ps.setInt(3, copperChange);
			ps.setInt(4, AuthUtil.getCurrentUser().getId());

			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return null;

	}
}
