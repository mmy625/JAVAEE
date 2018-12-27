package com.kgc.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kgc.annotation.Column;
import com.kgc.util.c3p0.JDBCUtilsC3p0;
/**
 * 
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年11月23日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class BaseUtilDao<T>
{
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param t
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int save(T t)
    {
        return 0;
    }
    
    /**
     * 
     * <删除> <功能详细描述>
     * 
     * @param t
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int delete(T t)
    {
        return 0;
    }
    
    /**
     * 修改 <一句话功能简述> <功能详细描述>
     * 
     * @param t
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int update(T t)
    {
        return 0;
    }
    
    /**
     * 
     * <查询单个对象 或者多个对象> <功能详细描述>
     * 
     * @param clasz 需要封装的对象类型
     * @param sql 查询的sql语句
     * @param list 参数集合
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<T> getAllList(Class clasz, String sql, List params)
    {
        
        List list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            con = JDBCUtilsC3p0.getConnection();
            ps = con.prepareStatement(sql);
            if (params != null && params.size() != 0)
            {
                for (int i = 0; i < params.size(); i++)
                {
                    ps.setObject(i + 1, params.get(i));
                }
            }
            rs = ps.executeQuery();
            Field[] fs = clasz.getDeclaredFields();
            while (rs.next())
            {
                Object obj = clasz.newInstance();
                for (int i = 0; i < fs.length; i++)
                {
                    Field field = fs[i];
                    Object annotationClumn = field.getDeclaredAnnotation(Column.class);
                    if (annotationClumn != null)
                    {
                        String columnName = ((Column)annotationClumn).columnName();
                        Object columnValue = rs.getObject(columnName);
                        field.setAccessible(true);
                        
                        field.set(obj, columnValue);
                        
                    }
                }
                
                list.add(obj);
                
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtilsC3p0.close(con, ps, rs);
        }
        
        return list;
    }
    
    /**
     * 根据条件 查询总的记录数 <一句话功能简述> <功能详细描述>
     * 
     * @param sql
     * @param list
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int getCount(String sql, List params)
    {
        
        List list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0; //返回的影响的行数 
        
        
        
        try
        {
            con = JDBCUtilsC3p0.getConnection();
            ps = con.prepareStatement(sql);
            if (params != null && params.size() != 0)
            {
                for (int i = 0; i < params.size(); i++)
                {
                    ps.setObject(i + 1, params.get(i));
                }
            }
            rs = ps.executeQuery();
            if (rs.next())
            {
                
                count = rs.getInt(1);
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtilsC3p0.close(con, ps, rs);
        }
        return count;
    }
}
