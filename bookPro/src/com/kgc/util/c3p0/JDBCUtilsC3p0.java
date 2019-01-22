package com.kgc.util.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ����c3p0���ӳ� <һ�仰���ܼ���> <������ϸ����>
 * 
 * @author ���� ����
 * @version [�汾��, 2018��11��12��]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
 */
public class JDBCUtilsC3p0
{
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(JDBCUtilsC3p0.class.getName());
    
    // ͨ����ʶ����������Ӧ���ӳ�
    static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
    
    /**
     * 
     * <һ�仰���ܼ���> <������ϸ����>
     * 
     * @return
     * @see [�ࡢ��#��������#��Ա]
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
            // throw new MyError("���ݿ����ӳ���!", e);
        }
        return null;
    }
    
    /**
     *  �ͷ����ӻ����ӳ�
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param conn
     * @param pst
     * @param rs
     * @see [�ࡢ��#��������#��Ա]
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
                // throw new MyError("���ݿ����ӹرճ���!", e);
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
                // throw new MyError("���ݿ����ӹرճ���!", e);
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
                // throw new MyError("���ݿ����ӹرճ���!", e);
            }
        }
    }
}
