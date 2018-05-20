package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.UserModel;
import model.UserModel;
import util.JdbcUtil;

public class UserDao{

	/**
	 * 通过 身份证号id 获取用户信息
	 * @param id
	 * @return
	 */
	public static UserModel getUser(String ids) {
		UserModel user = null;
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = null;
		String sql = "SELECT * from users  where id = ? ";
		ResultSet rs = null;
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ids);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				user = new UserModel();
				user.setId(id);
				user.setName(name);
				user.setPhone(phone);
				user.setAddress(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return user;
	}

	public static boolean updateUser(UserModel user) {
		boolean result = false;
		String sql = "update users set name=?,phone=?,address=? WHERE id = ?";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPhone());
			stmt.setString(3, user.getAddress());
			stmt.setString(4, user.getId());
			return (stmt.executeUpdate() == 1);
		} catch (SQLException e) {
			try {
				conn.rollback();
				result = false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt);
		}
		return result;
	}

	public static boolean addUser(UserModel user) {
		boolean result = false;
		String sql = "insert into Users values(?,?,?,?,?)";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPhone());	
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getAdmin_id());
			int c = stmt.executeUpdate();
			if (c > 0) {
				result = true;
			}
		} catch (SQLException e) {
				result = false;
			e.printStackTrace();
		} 
		return result;
	}

}