package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TradModel;
import util.JdbcUtil;

public class TradDao {

	public static TradModel getTrad(String card_id) {
		TradModel trad = null;
		Connection conn = JdbcUtil.getConnection();// 获取数据库连接
		PreparedStatement stmt = null;
		String sql = "SELECT * from Trad  where card_id = ? ";
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, card_id);
			rs = stmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				// 获取数据
				String tradTime = rs.getString("trad_time");
				Double amount = rs.getDouble("amount");
				int tradType = rs.getInt("trad_type");
				String tradTo = rs.getString("trad_to");
				// 把数据封装进定义的TradInfo对象
				trad = new TradModel();
				trad.setCard_id(card_id);
				trad.setTrad_time(tradTime);
				trad.setAmount(amount);
				trad.setTrad_type(tradType);
				trad.setTrad_to(tradTo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);// 关闭连接
		}
		return trad;
	}

	/**
	 * 执行存款等操作后，保存交易信息
	 * 
	 * @param trade
	 *            一次的交易信息
	 * @return
	 * @author Lanny
	 */
	public static boolean addTrad(TradModel trade) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "INSERT INTO Trad(card_id,trad_time,amount,trad_type,trad_to) VALUES(?,getDate(),?,?,?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, trade.getCard_id());
			stmt.setDouble(2, trade.getAmount());
			stmt.setInt(3, trade.getTrad_type());
			stmt.setString(4, trade.getTrad_to());

			int c = stmt.executeUpdate();
			if (c > 0) {
				result = true;
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt);
		}
		return result;
	}

	/**
	 * 通过卡号、类型 ，获取当天“取款”或“存款”或“转账”的交易金额
	 * 
	 * @param card_id
	 * @param trad_type
	 * @return 统计当天交易金额
	 */
	public static double getTodayTrad(String card_id, int trad_type) {
		double today_trad_money = 0.0;
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = null;
		String sql = "select SUM(amount) todayTrad from Trad where card_id = ? AND trad_type = ? "
				+ "AND trad_time between CONVERT(varchar(100), GETDATE(), 112) and CONVERT(varchar(100), GETDATE()+1, 112);";
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, card_id);
			stmt.setInt(2, trad_type);
			rs = stmt.executeQuery();
			while (rs.next()) {
				today_trad_money = rs.getDouble("todayTrad");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return today_trad_money;
	}

	/**
	 * 根据类型?、卡号?、交易时间查询
	 * 
	 * @author Lanny
	 */
	public List<TradModel> findByIDADateAType(String card_id, String startStr, String finalStr, int trad_type) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if (!(finalStr.equals("")))
			finalStr += " 23:59:59";
		System.out.println(finalStr);
		try {
			conn = JdbcUtil.getConnection();
			String sql = null;
			if (trad_type == 0) {
				if (card_id.equals("")) {
					if ((startStr.equals("")) && (finalStr.equals(""))) {// 时间为空时
						sql = "SELECT * FROM Trad where trad_time>=getDate()-90 and trad_time<=getDate() order by trad_time desc";
						stmt = conn.prepareStatement(sql);
					} else {// 时间都不为空时
						sql = "SELECT * FROM Trad where trad_time>=? and trad_time<=? order by trad_time desc";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, startStr);
						stmt.setString(2, finalStr);
					}
				} else {
					if ((startStr.equals("")) && (finalStr.equals(""))) {// 时间为空时
						sql = "SELECT * FROM Trad where trad_time>=getDate()-90 and trad_time<=getDate() "
								+ " and card_id=? order by trad_time desc";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, card_id);
					} else {// 时间都不为空时
						sql = "SELECT * FROM Trad where trad_time>=? and trad_time<=? "
								+ " and card_id=? order by trad_time desc;";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, startStr);
						stmt.setString(2, finalStr);
						stmt.setString(3, card_id);
					}
				}
			} else {
				if (card_id.equals("")) {
					if ((startStr.equals("")) && (finalStr.equals(""))) {// 时间为空时
						sql = "SELECT * FROM Trad where trad_time>=getDate()-90 and trad_time<=getDate() "
								+ "and trad_type=? order by trad_time desc;";
						stmt = conn.prepareStatement(sql);
						stmt.setInt(1, trad_type);
					} else {// 时间都不为空时
						sql = "SELECT * FROM Trad where trad_time>=? and trad_time<=? "
								+ "and trad_type=? order by trad_time desc;";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, startStr);
						stmt.setString(2, finalStr);
						stmt.setInt(3, trad_type);
					}
				} else {
					if ((startStr.equals("")) && (finalStr.equals(""))) {// 时间为空时
						sql = "SELECT * FROM Trad where trad_time>=getDate()-90 and trad_time<=getDate() "
								+ "and trad_type=? " + "and card_id=? order by trad_time desc;";
						stmt = conn.prepareStatement(sql);
						stmt.setInt(1, trad_type);
						stmt.setString(2, card_id);
					} else {// 时间都不为空时
						sql = "SELECT * FROM Trad where trad_time>=? and trad_time<=? " + "and trad_type=? "
								+ "and card_id=? order by trad_time desc;";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, startStr);
						stmt.setString(2, finalStr);
						stmt.setInt(3, trad_type);
						stmt.setString(4, card_id);
					}
				}
			}
			// 执行
			rs = stmt.executeQuery();
			List<TradModel> list = new ArrayList<TradModel>();
			while (rs.next()) {
				TradModel trade = new TradModel();
				trade.setCard_id(rs.getString("card_id"));
				trade.setTrad_type(rs.getInt("trad_type"));
				trade.setAmount(rs.getDouble("amount"));
				trade.setTrad_to(rs.getString("trad_to"));
				trade.setTrad_time(rs.getString("trad_time"));
				list.add(trade);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}
}
