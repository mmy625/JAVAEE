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
 * <һ�仰���ܼ���>
 * <������ϸ����>
 * 
 * @author  ���� ����
 * @version  [�汾��, 2018��11��23��]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
public class BaseUtilDao<T>
{
    /**
     * 
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param t
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public int save(T t)
    {
        return 0;
    }
    
    /**
     * 
     * <ɾ��> <������ϸ����>
     * 
     * @param t
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public int delete(T t)
    {
        return 0;
    }
    
    /**
     * �޸� <һ�仰���ܼ���> <������ϸ����>
     * 
     * @param t
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public int update(T t)
    {
        return 0;
    }
    
    /**
     * 
     * <��ѯ�������� ���߶������> <������ϸ����>
     * 
     * @param clasz ��Ҫ��װ�Ķ�������
     * @param sql ��ѯ��sql���
     * @param list ��������
     * @return
     * @see [�ࡢ��#��������#��Ա]
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
     * �������� ��ѯ�ܵļ�¼�� <һ�仰���ܼ���> <������ϸ����>
     * 
     * @param sql
     * @param list
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public int getCount(String sql, List params)
    {
        
        List list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0; //���ص�Ӱ������� 
        
        
        
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
