package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import dao.ProductsDao;
import model.Products;

public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public addProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		response.setContentType("text/html;charset=utf-8");
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			File f = new File("f:\\Target");
			if (!f.exists()) {
				f.mkdirs();
			}
			factory.setRepository(f);
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setHeaderEncoding("utf-8");
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			PrintWriter writer = response.getWriter();
			Products products = new Products();
			products.setId(UUID.randomUUID().toString());
			for(FileItem fileItem : fileItems) {
				if(fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					switch (name) {
					case "name":
						products.setName(fileItem.getString("utf-8"));
						break;
					case "price":
					    double price = Double.parseDouble(fileItem.getString("utf-8"));
						products.setPrice(price);
						break;
					case "pnum":
						int pnum = Integer.parseInt(fileItem.getString("utf-8"));
						products.setPnum(pnum);
						break;
					case "category":
						products.setCategory(fileItem.getString("utf-8"));
						break;
					case "description":
						products.setDescription(fileItem.getString("utf-8"));
						break;
					default:
						break;
					}
					String value = fileItem.getString("utf-8");
					writer.print("上传者："+value+"<br>");
				}else {
					// 上传的文件路径
					String filename = fileItem.getName();
					writer.print("文件来源："+filename+"<br>");
					// 截取出文件名
					filename = filename
							.substring(filename.lastIndexOf("\\") + 1);
					writer.print("成功上传的文件："+filename+"<br>");
					// 文件名需要唯一
					filename = UUID.randomUUID().toString() + "_" + 
                        		filename;
					// 在服务器创建同名文件
					String webPath = "/upload/";
					products.setImgurl(webPath+filename);
					String filepath =
                       getServletContext().getRealPath(webPath+filename); 
					// 创建文件
					File file = new File(filepath);
					file.getParentFile().mkdirs();
					file.createNewFile();
					// 获得上传文件流
					InputStream in = fileItem.getInputStream();
					// 获得写入文件流
					OutputStream out = new FileOutputStream(file);
					// 流的对拷
					byte[] buffer = new byte[1024];
					int len;
					while ((len = in.read(buffer)) > 0)
						out.write(buffer, 0, len);
					// 关流
					in.close();
					out.close();
					// 删除临时文件
					fileItem.delete();
				}
			}
			System.out.println(products);
			ProductsDao dao = new ProductsDao();
			boolean isok=dao.addProd(products);
			if(isok) {
				response.sendRedirect("proManager.jsp");
			}else {
				writer.print("<h3>添加商品失败！！！<h3>");
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public static void main(String[] args) {
		System.out.println("---------");
	}

}
