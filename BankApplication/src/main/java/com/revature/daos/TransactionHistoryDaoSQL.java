package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.ItemTable;
import com.revature.models.TransactionTable;
import com.revature.util.AuthUtil;
import com.revature.util.ConnectionUtil;

public class TransactionHistoryDaoSQL implements TransactionHistoryDao {

	TransactionTable extractTransaction(ResultSet rs) throws SQLException {
		int id = rs.getInt("transaction_id");
		String type = rs.getString("type");
		String quantity = rs.getString("quantity_amount");
		String name = rs.getString("item_name");
		String memo = rs.getString("memo");
		int adventurer = rs.getInt("adventurer");
		return new TransactionTable();

	}

	@Override
	public List<TransactionTable> findAll() {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM transaction_history";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<TransactionTable> transactionTable = new ArrayList<TransactionTable>();
			while (rs.next()) {
				TransactionTable it = new TransactionTable(rs.getInt("transaction_id"), rs.getString("type"), rs.getString("quantity_amount"), rs.getString("item_name"), rs.getString("memo"), rs.getInt("adventurer"));
				transactionTable.add(it);
			}

			return transactionTable;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int rmvTransactionItem(String item, String memo) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO transaction_history (transaction_id, type, quantity_amount, item_name, memo, adventurer) "
					+ "VALUES (transaction_id_seq.nextval, 'item', -1, ?,?,?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, item);
			ps.setString(2, memo);
			ps.setInt(3, AuthUtil.getCurrentUser().getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return 0;

	}

	@Override
	public int addTransactionItem(String item, String memo) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO transaction_history (transaction_id, type, quantity_amount, item_name, memo, adventurer) "
					+ "VALUES (transaction_id_seq.nextval, 'item', 1, ?,?,?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, item);
			ps.setString(2, memo);
			ps.setInt(3, AuthUtil.getCurrentUser().getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return 0;

	}

	@Override
	public int addTransactionCurrency(String quantity, String memo) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO transaction_history (transaction_id, type, quantity_amount, item_name, memo, adventurer) "
					+ "VALUES (transaction_id_seq.nextval, 'currency', ?, 1,?,?)";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, quantity);
			ps.setString(2, memo);
			ps.setInt(3, AuthUtil.getCurrentUser().getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return 0;
	}

	@Override
	public List<TransactionTable> findByAdventurer(int id) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM transaction_history " + "WHERE adventurer = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			List<TransactionTable> transactionTable = new ArrayList<TransactionTable>();
			while (rs.next()) {
				TransactionTable it = new TransactionTable(rs.getInt("transaction_id"), rs.getString("type"), rs.getString("quantity_amount"), rs.getString("item_name"), rs.getString("memo"), rs.getInt("adventurer"));
				transactionTable.add(it);
			}

			return transactionTable;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public int rmvTransactionCurrency(String quantity, String memo) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO transaction_history (transaction_id, type, quantity_amount, item_name, memo, adventurer) "
					+ "VALUES (transaction_id_seq.nextval, 'currency', ?, 1,?,?)";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, quantity);
			ps.setString(2, memo);
			ps.setInt(3, AuthUtil.getCurrentUser().getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return 0;
	}

	@Override
	public int save(TransactionTable c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
