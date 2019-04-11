package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Products;
//import utils.C3p0Utils;
import utils.DBCPUtils;

public class ProductsDao {
	public List<Products> findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Products> list = new ArrayList<Products>();
		try {
			conn = DBCPUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM Products";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Products product = new Products();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getDouble("price"));
				product.setPnum(rs.getInt("pnum"));
				product.setImgurl(rs.getString("imgurl"));
				product.setDescription(rs.getString("description"));
				list.add(product);
			}
			return list;
		}catch (Exception e) {
			System.out.println("-----------eeeeee---------");
			e.printStackTrace();
		}finally {
			//JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	/*public static void main (String args[]) {
		ArrayList<Products> findAll = new ProductsDao().findAll();
		System.out.println(findAll);
	}*/
	
}
