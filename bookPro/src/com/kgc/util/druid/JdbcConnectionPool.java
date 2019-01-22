package com.kgc.util.druid;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.kgc.util.JDBCUtils;
import com.kgc.util.c3p0.JDBCUtilsC3p0;

/**
 * 阿里连接池 Druid <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月22日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JdbcConnectionPool
{
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(JDBCUtilsC3p0.class.getName());
    
    private static ThreadLocal connectionThreadLocal = new ThreadLocal();
    
    private static DruidDataSource druidDataSource = null;
    
    static
    {
        // static块中加载驱动 把jdbc_druid.properties文件中的属性值加载到 资源文件Properties中
        Properties properties = loadPropertiesFile(SysConstants.JDBC_CONF_FILE);
        try
        {
            druidDataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
        }
        catch (Exception e)
        {
            logger.error("[JDBC Exception] --> "
                + "Failed to configured the Druid DataSource, the exceprion message is:" + e.getMessage());
        }
    }
    
    /**
     * 获得连接对象
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Connection getConnection()
    {
        Connection connection = (Connection)connectionThreadLocal.get();
        try
        {
            if (null == connection)
            {
                connection = druidDataSource.getConnection();
                connectionThreadLocal.set(connection);
            }
        }
        catch (SQLException e)
        {
            logger.error(
                "[JDBC Exception] --> " + "Failed to create a connection, the exceprion message is:" + e.getMessage());
        }
        return connection;
    }
    
    /**
     * 关闭连接
     * <一句话功能简述>
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    public static void closeConnection()
    {
        Connection connection = (Connection)connectionThreadLocal.get();
        if (null != connection)
        {
            try
            {
                connection.close();
                connectionThreadLocal.remove();
            }
            catch (SQLException e)
            {
                logger.error("[JDBC Exception] --> "
                    + "Failed to close the DruidPooledConnection, the exceprion message is:" + e.getMessage());
            }
        }
    }
    
    public static void startTransaction()
    {
        Connection conn = (Connection)connectionThreadLocal.get();
        
        try
        {
            if (conn == null)
            {
                conn = getConnection();
                connectionThreadLocal.set(conn);
            }
            conn.setAutoCommit(false);
        }
        catch (Exception e)
        {
            logger.error("[JDBC Exception] --> " + "Failed to start the transaction, the exceprion message is:"
                + e.getMessage());
        }
    }
    
    public static void commit()
    {
        try
        {
            Connection conn = (Connection)connectionThreadLocal.get();
            if (null != conn)
            {
                conn.commit();
            }
        }
        catch (Exception e)
        {
            logger.error("[JDBC Exception] --> " + "Failed to commit the transaction, the exceprion message is:"
                + e.getMessage());
        }
    }
    
    public static void rollback()
    {
        try
        {
            Connection conn = (Connection)connectionThreadLocal.get();
            if (conn != null)
            {
                conn.rollback();
                connectionThreadLocal.remove();
            }
        }
        catch (Exception e)
        {
            logger.error("[JDBC Exception] --> " + "Failed to rollback the transaction, the exceprion message is:"
                + e.getMessage());
        }
    }
    
    /**
     * 加载配置文件 <一句话功能简述> <功能详细描述>
     * 
     * @param fullFile
     * @return
     * @see [类、类#方法、类#成员]
     */
    private static Properties loadPropertiesFile(String fullFile)
    {
        if (null == fullFile || fullFile.equals(""))
        {
            throw new IllegalArgumentException("Properties file path can not be null" + fullFile);
        }
        Properties prop = new Properties();
        try
        {
            InputStream in = JDBCUtils.class.getResourceAsStream(fullFile);
            prop.load(in);
        }
        catch (IOException e)
        {
            logger.error("[Properties Exception] --> " + "Can not load jdbc properties, the exceprion message is:"
                + e.getMessage());
        }
        return prop;
    }
}
