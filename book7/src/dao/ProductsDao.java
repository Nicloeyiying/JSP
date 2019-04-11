package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import model.Products;
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
	public boolean addProd(Products prod) {
		try {
			String sql="insert into products values(?,?,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner(DBCPUtils.getDataSource());
			//调用方法
			int num =runner.update(sql, new Object[]{
					prod.getId(),
					prod.getName(),
					prod.getPrice(),
					prod.getCategory(),
					prod.getPnum(),
					prod.getImgurl(),
					prod.getDescription()
			} );
			if (num>=1)
				return true;
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return false;
	}
}
