package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AdminModel;
import model.MoreInfo;
import util.JdbcUtil;

public class AdminDao{
	/**
	 * Admin表：通过admin_id查询
	 */
	public static AdminModel checkAdmin(String admin_id) {
		AdminModel admin = null;
		Connection conn = JdbcUtil.getConnection();//获取数据库连接
		//编写sql语句  查询
		String sql = "SELECT * from admin  where admin_id = ? ";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, admin_id);
			rs = stmt.executeQuery();//执行SQL语句
			while (rs.next()) {
				//获取数据
				String id = rs.getString("admin_id");
				String password = rs.getString("admin_pw");
				//把数据封装进定义的admin对象
				admin = new AdminModel();
				admin.setAdmin_id(admin_id);
				admin.setAdmin_pw(password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt, rs);//关闭连接
		}
		return admin;
	}

	/**
	 * 添加管理员
	 * @param admin
	 * @return
	 */
	public static boolean addAdmin(AdminModel admin) {
		boolean result = false;
		String sql = "insert into Admin values(?,?)";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, admin.getAdmin_id());
			stmt.setString(2, admin.getAdmin_pw());
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
	
	//修改管理员密码
	public static int changePasswd(String password,String admin_id){
		System.out.println(password);
		System.out.println(admin_id);
		int i=0;
		Connection conn=null;
		PreparedStatement stmt=null;
		try{
			String sql="update Admin set admin_pw=? where admin_id=?";
			conn=JdbcUtil.getConnection();//获取数据库连接
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, admin_id);
			i=stmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		JdbcUtil.close(conn, stmt);//关闭连接
	}
		System.out.println(i);
		return i;
		
	}
	
	//查询用户信息
	public static List selectUserInfo(String card_id,String user_id){
		List list=new ArrayList();
		Connection conn=null;
		PreparedStatement stmt=null;
		try{
			String sql="SELECT [Users].id, [Users].name, [Card].card_id, [Card].moneys,[Card].type,[Card].status,[Users].phone,[Users].address, [Admin].admin_id FROM [Admin] INNER JOIN [Users] ON [Admin].admin_id = [Users].admin_id INNER JOIN [Card] ON [Users].id = [Card].id WHERE ([Card].card_id = '"+card_id+"' and [Users].id='"+user_id+"')";
			conn=JdbcUtil.getConnection();//获取数据库连接
			stmt=conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					MoreInfo moreInfo=new MoreInfo();
					moreInfo.setId(rs.getString("id"));
					System.out.println(rs.getString("id"));
					moreInfo.setName(rs.getString("name"));
					moreInfo.setCard_id(rs.getString("card_id"));
					moreInfo.setMoneys(rs.getDouble("moneys"));
					moreInfo.setType(rs.getInt("type"));
					moreInfo.setStatus(rs.getInt("status"));
				//	moreInfo.setPhone(rs.getString("phone"));
				//	moreInfo.setAddress(rs.getString("address"));
				//	moreInfo.setAdmin_id(rs.getString("admin_id"));
					list.add(moreInfo);
					System.out.println(list);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn, stmt);//关闭连接
			}
			return list;
	}
	
	//更新卡的状态
	public static int updateStatus(String card_id,int status) {
		int i=0;
		Connection conn=null;
		PreparedStatement stmt=null;
		try{
			String sql="update Card set status=? where card_id=?";
			conn=JdbcUtil.getConnection();//获取数据库连接
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, status);
			stmt.setString(2, card_id);
			i=stmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		JdbcUtil.close(conn, stmt);//关闭连接
	}
		System.out.println(i);
		return i;
		
	}

}
