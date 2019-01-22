package com.kgc.util.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 配置c3p0连接池 <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月12日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JDBCUtilsC3p0
{
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(JDBCUtilsC3p0.class.getName());
    
    // 通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
    
    /**
     * 
     * <一句话功能简述> <功能详细描述>
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Connection getConnection()
    {
        try
        {
            return dataSource.getConnection();
            
        }
        catch (Exception e)
        {
            logger.error("Exception in C3p0Utils!", e);
            // throw new MyError("数据库连接出错!", e);
        }
        return null;
    }
    
    /**
     *  释放连接回连接池
     * <一句话功能简述>
     * <功能详细描述>
     * @param conn
     * @param pst
     * @param rs
     * @see [类、类#方法、类#成员]
     */
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs)
    {
        if (rs != null)
        {
            try
            {
                rs.close();
            }
            catch (SQLException e)
            {
                logger.error("Exception in C3p0Utils!", e);
                // throw new MyError("数据库连接关闭出错!", e);
            }
        }
        if (pst != null)
        {
            try
            {
                pst.close();
            }
            catch (SQLException e)
            {
                logger.error("Exception in C3p0Utils!", e);
                // throw new MyError("数据库连接关闭出错!", e);
            }
        }
        
        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                logger.error("Exception in C3p0Utils!", e);
                // throw new MyError("数据库连接关闭出错!", e);
            }
        }
    }
}
