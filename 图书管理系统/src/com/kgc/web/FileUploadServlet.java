package com.kgc.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传 后台
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年11月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8382832509729035231L;
	

	/**
	 * Constructor of the object.
	 */
	public FileUploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	    String fileSize = "";
        // 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        // E:/upload/data
         String savePath =
         this.getServletContext().getRealPath("/WEB-INF/upload");
        // 上传时生成的临时文件保存目录
         String tempPath =
         this.getServletContext().getRealPath("/WEB-INF/temp");

        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            // 创建临时目录
            tmpFile.mkdir();
        }
        // 消息提示
        String message = "";
        try {
            // 使用Apache文件上传组件处理文件上传步骤：
            // 1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
            factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
            // 设置上传时生成的临时文件的保存目录
            factory.setRepository(tmpFile);
            // 2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 监听文件上传进度
            upload.setProgressListener(new ProgressListener() {
                public void update(long pBytesRead, long pContentLength,
                        int arg2) {
                }
            });
            // 解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            // 3、判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                // 按照传统方式获取数据
                return;
            }
            // 设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
            upload.setFileSizeMax(1024 * 1024 * 5);
            // 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
            upload.setSizeMax(1024 * 1024 * 10);
            // 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                // 如果fileitem中封装的是普通输入项的数据
                //if (item.isFormField()) {
                    //String name = item.getFieldName();
                    // 解决普通输入项的数据的中文乱码问题
                    //String value = item.getString("UTF-8");
                    // value = new
            //  } else {// 如果fileitem中封装的是上传文件
                    // 得到上传的文件名称，
                    String filename = item.getName();
                    Long filesizeNum = (Long) item.getSize();

                    if (filesizeNum > 0) {
                        DecimalFormat df = new DecimalFormat("####.00");
                        float size = (float) filesizeNum / 1024;
                        fileSize = df.format(size);
                    }

                    if (filename == null || filename.trim().equals("")) {
                        continue;
                    }
                    // 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
                    // c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    // 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename
                            .lastIndexOf("\\") + 1);
                    // 得到上传文件的扩展名
                    String fileExtName = filename.substring(filename
                            .lastIndexOf(".") + 1);
                    // 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
                    // 获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    // 得到文件保存的名称
                    String saveFilename = makeFileName(filename);
                    // 得到文件的保存目录
                    String realSavePath = makePath(saveFilename, savePath);
                    // 创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(
                            realSavePath + "\\" + saveFilename);
                    // 创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    // 判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    // 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while ((len = in.read(buffer)) > 0) {
                        // 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath +
                        // "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    // 关闭输出流
                    out.close(); // 删除处理文件上传时生成的临时文件 //item.delete();
                                    // message = "文件上传成功！";
                    // 关闭输入流
                    in.close();
                    
                    String  href = realSavePath+"\\"+saveFilename;
                    StringBuilder resultHtml = new StringBuilder();
                    resultHtml.append(" <li id='file_SWFUpload_5_0' style='font-size: 16px;margin-left: 25px;padding: 5px;'> ");
                    resultHtml.append(" <span class='attch-name'>"+ filename);
                    resultHtml.append(" <span class='attch-size'>"
                                    + fileSize
                                    + "KB</span><span class='attch-state' style='color:#c1c1c1'>(完成)</span>");
                    resultHtml.append(" <a style='color: #178be2' target='_blank' href='"+href+"' class='attch-dload'>下载</a>");
                    resultHtml.append(" <a style='color: #178be2'  class='attch-delete'>删除</a>");
                    resultHtml.append(" </li>");
                    response.getWriter().write(resultHtml.toString());

                //}
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            request.setAttribute("message", "单个文件超出最大值！！！");
            return;
        } catch (FileUploadBase.SizeLimitExceededException e) {
            request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
            return;
        } catch (Exception e) {
            message = "文件上传失败！";
            request.setAttribute("message", "文件上传失败！");
        }

	}


	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
	}
	
	private String makeFileName(String filename) { // 2.jpg
		// 涓洪槻姝㈡枃浠惰鐩栫殑鐜拌薄鍙戠敓锛岃涓轰笂浼犳枃浠朵骇鐢熶竴涓敮涓�鐨勬枃浠跺悕
		return UUID.randomUUID().toString() + "_" + filename;
	}
	private String makePath(String filename, String savePath) {
	  //int dir1 = hashcode & 0xf; // 0--15
        //int dir2 = (hashcode & 0xf0) >> 4; // 0-15
        // 构造新的保存目录
        // String dir = savePath + "\\" + dir1 + "\\" + dir2; //upload\2\3
        // upload\3\5
        String dir = savePath;
        // File既可以代表文件也可以代表目录
        File file = new File(dir);
        // 如果目录不存在
        if (!file.exists()) {
            // 创建目录
            file.mkdirs();
        }
        return dir;
	}
}
