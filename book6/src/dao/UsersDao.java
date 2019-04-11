package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.commons.dbutils.handlers.BeanHandler;
import model.User;
import utils.DBCPUtils;

public class UsersDao extends BaseDao{
	public static void main(String[] args) {
		User findAll = new UsersDao().findByUser("admin", "123456");
		System.out.println(findAll);
	}
	public boolean insert(User user){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.createStatement();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			int num = 0;
			if(num >= 1) {
				return true;
			}
			return false;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.release(rs, stmt, conn);
		}
		return false;
	}
	public ArrayList<User> findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
//				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
//				user.setBirthday(rs.getDate("birthday"));
				list.add(user);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.release(rs, stmt, conn);
		}
		return null;
	}
	public User find(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM users WHERE id=" + id;
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
//				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
//				user.setBirthday(rs.getDate("birthday"));
				return user;
			}
			return null;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.release(rs, stmt, conn);
		}
		return null;
	}
	public User findByUser(String name,String pwd) {
		try {
			String sql = "SELECT * FROM user WHERE username = ? and password = ?";
			User user = (User)this.query(sql, new BeanHandler<>(User.class), name,pwd);
			return user;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean delete(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "DELETE FROM users WHERE id="+id;
			int num = stmt.executeUpdate(sql);
			if(num > 0) {
				return true;
			}
			return false;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.release(rs, stmt, conn);
		}
		return false;
	}
	public boolean update(User user) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.createStatement();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
//			String birthday = sdf.format(user.getBirthday());
//			String sql = "UPDATE users set name='"+user.getName()
//				+"',password='"+user.getPassWord()+"',email='"
//				+ user.getEmail() + "',birthday='" + birthday
//				+ "' WHERE id=" + user.getId();
//			int num = stmt.executeUpdate(sql);
			int num = 0;
			if(num > 0) {
				return true;
			}
			return false;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.release(rs, stmt, conn);
		}
		return false;
	}
}
