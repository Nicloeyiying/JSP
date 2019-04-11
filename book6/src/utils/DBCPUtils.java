package utils;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
public class DBCPUtils {
//	public static DataSource ds = null;
//	static {
//		// 新建一个配置文件对象
//		Properties prop = new Properties();
//		try {
//			// 通过类加载器找到文件路径，读配置文件
//			InputStream in = new DBCPUtils().getClass().getClassLoader()
//					.getResourceAsStream("dbcpconfig.properties");
//			// 把文件以输入流的形式加载到配置对象中
//			prop.load(in);
//			// 创建数据源对象
//			ds = BasicDataSourceFactory.createDataSource(prop);
//		} catch (Exception e) {
//			throw new ExceptionInInitializerError(e);
//		}
//	}
//	public static void main(String[] args) throws SQLException {
//				// 获取数据库连接对象
//				Connection conn = ds.getConnection();
//				//获取数据库连接信息
//				DatabaseMetaData metaData = conn.getMetaData();
//				//打印数据库连接信息
//            System.out.println(metaData.getURL()
//            +",UserName="+metaData.getUserName()   
//                    +","+metaData.getDriverName());	
//}
	public static Connection getConnection() throws SQLException,
	ClassNotFoundException{
//		try {
//			return ds.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/books";
		String username = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	public static void release(Statement stmt, Connection conn) {
		if(stmt != null) {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		release(stmt, conn);
	}
}
