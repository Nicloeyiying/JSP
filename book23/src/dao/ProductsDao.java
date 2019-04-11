package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Products;
import model.User;
import utils.C3p0Utils;
import utils.JDBCUtils;

public class ProductsDao {
	public ArrayList<Products>findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Products> list = new ArrayList<Products>();
		try {
			conn = C3p0Utils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM Products";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Products product = new Products();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setPnum(rs.getInt("pnum"));
				product.setImgurl(rs.getString("imgurl"));
				product.setDescription(rs.getString("description"));
				list.add(product);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
}
