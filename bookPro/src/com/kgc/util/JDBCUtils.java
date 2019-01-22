package com.kgc.util;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * JDBC工具类 <功能详细描述> 关于在web环境中读取配置文件的问题，请参考下面两篇文章
 * 
 * https://www.cnblogs.com/LZL-student/p/6013859.html
 * 
 * https://www.cnblogs.com/nanyangke-cjz/p/7124043.html
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月12日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JDBCUtils
{
    static String className;
    
    static String userName;
    
    static String userPassword;
    
    static String url;
    
    static Properties prop;
    static
    {
        /**
         * 使用类路径的读取方式 / : 斜杠表示classpath的根目录
         * 
         * 在java项目下，classpath的根目录从bin目录开始
         * 
         * 在web项目下，classpath的根目录从WEB-INF/classes目录开始
         */
        InputStream in = JDBCUtils.class.getResourceAsStream("/jdbc.properties");
        prop = new Properties();
        try
        {
            prop.load(in);
            className = prop.getProperty("className");
            userName = prop.getProperty("userName");
            userPassword = prop.getProperty("userPassword");
            url = prop.getProperty("url");
            
            Class.forName(className);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * 获得连接
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @throws SQLException
     * @see [类、类#方法、类#成员]
     */
    public static java.sql.Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, userName, userPassword);
    }
}
