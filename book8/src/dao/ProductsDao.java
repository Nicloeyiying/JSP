package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import model.Products;
import utils.DBCPUtils;

public class ProductsDao extends BaseDao{

	// 查询所有的User对象 【显示所有数据】
	public ArrayList<Products> findProductAll() {
		//定义一个自定义的 【数据结构 】 存储数据
		ArrayList<Products> list = new ArrayList<Products>();
		// 发送SQL语句
		String sql = "SELECT * FROM Products";
		try {
			list= (ArrayList<Products>)this.query(sql, new BeanListHandler<>(Products.class));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	// 查询所有的User对象 【显示所有数据】
	public ArrayList<Products> findAll() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			//定义一个自定义的 【数据结构 】 存储数据
			ArrayList<Products> list = new ArrayList<Products>();
			//list.add("sdfsd");
			try {
				// 获得数据的连接
				//conn = JDBCUtils.getConnection();
				conn = DBCPUtils.getConnection();
				// 获得Statement对象
				stmt = conn.createStatement();
				// 发送SQL语句
				String sql = "SELECT * FROM Products";
				rs = stmt.executeQuery(sql);
				// 处理结果集
				while (rs.next()){//循环一次 获取到一行
					Products prod = new Products();//将每一行数据存放在用户对象中
					prod.setId(rs.getString("id"));
					prod.setName(rs.getString("name"));
					prod.setCategory(rs.getString("category"));
					prod.setPrice(rs.getDouble("price"));
					prod.setPnum(rs.getInt("pnum"));
					prod.setImgurl(rs.getString("imgurl"));
					prod.setDescription(rs.getString("description"));
					list.add(prod);//将用户对象存储到集合
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBCPUtils.release(rs, stmt, conn);
			}
			return null;
		}
	public Products findProductsById(String id) {
		// 发送SQL语句
		String sql = "SELECT * FROM Products where id=?";
		try {
			Products prod=(Products)this.query(sql, new BeanHandler<>(Products.class), id);
			return prod;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
