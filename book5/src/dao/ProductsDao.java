package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import model.Products;
import model.User;
import utils.DBCPUtils;

public class ProductsDao extends BaseDao{
	/*public static void main (String args[]) {
		ArrayList<Products> findAll = new ProductsDao().findAll();
		System.out.println(findAll);
	}*/
	public List<Products> findAll() {
		ArrayList<Products> list = new ArrayList<Products>();
		BaseDao basedao = new BaseDao();
		String sql = "SELECT * FROM Products";// sql脚本
		try {
			list = (ArrayList<Products>)this.query(sql, new BeanListHandler<>(Products.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			//记录异常日志 日志框架
			return null;
		}		
		//return list;
	}
	public static void main(String[] args) {
		List<Products> findAll = new ProductsDao().findAll();
		System.out.println(findAll);
	}
}
