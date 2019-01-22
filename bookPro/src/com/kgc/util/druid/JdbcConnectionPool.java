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
 * �������ӳ� Druid <һ�仰���ܼ���> <������ϸ����>
 * 
 * @author ���� ����
 * @version [�汾��, 2018��11��22��]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
 */
public class JdbcConnectionPool
{
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(JDBCUtilsC3p0.class.getName());
    
    private static ThreadLocal connectionThreadLocal = new ThreadLocal();
    
    private static DruidDataSource druidDataSource = null;
    
    static
    {
        // static���м������� ��jdbc_druid.properties�ļ��е�����ֵ���ص� ��Դ�ļ�Properties��
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
     * ������Ӷ���
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @return
     * @see [�ࡢ��#��������#��Ա]
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
     * �ر�����
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @see [�ࡢ��#��������#��Ա]
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
     * ���������ļ� <һ�仰���ܼ���> <������ϸ����>
     * 
     * @param fullFile
     * @return
     * @see [�ࡢ��#��������#��Ա]
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
