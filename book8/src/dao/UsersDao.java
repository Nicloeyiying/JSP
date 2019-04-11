package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.User;
import utils.JDBCUtils;
//计算机知识体系   
//软件设计 
//软件开发 : 计算机组成  计算机导论 数据结构 算法  网络基础 
//软件测试 
//软件实施  
public class UsersDao {//碎片化 ---》   时间的利用率  
	// 添加用户的操作  [注册]
	public boolean insert(User user){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		// 获得数据的连接
		conn = JDBCUtils.getConnection();
		// 获得Statement对象
		stmt = conn.createStatement();
		// 发送SQL语句
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birthday = sdf.format(user.getBirthday());
	    String sql = "INSERT INTO users(name,password,email,birthday) "+
					"VALUES('"+ user.getUsername()+ "','"
					+ user.getPassword()+ "','"
					+ user.getEmail()+ "','"
					+ birthday + "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	// 查询所有的User对象 【显示所有数据】
	public ArrayList<User> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//定义一个自定义的 【数据结构 】 存储数据
		ArrayList<User> list = new ArrayList<User>();
		//list.add("sdfsd");
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM users";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()){//循环一次 获取到一行
				User user = new User();//将每一行数据存放在用户对象中
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				list.add(user);//将用户对象存储到集合
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	// 根据id查找指定的user
	public User find(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM users WHERE id=" + id;
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				return user;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	// 删除用户
	public boolean delete(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "DELETE FROM users WHERE id=" + id;
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	// 修改用户
	public boolean update(User user) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birthday = sdf.format(user.getBirthday());
			String sql = "UPDATE users set name='" + user.getUsername()
					+ "',password='" + user.getPassword() + "',email='"
					+ user.getEmail() + "',birthday='" + birthday
					+ "' WHERE id=" + user.getId();
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
}
