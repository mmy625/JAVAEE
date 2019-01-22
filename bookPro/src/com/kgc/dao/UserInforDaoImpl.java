package com.kgc.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.kgc.annotation.Column;
import com.kgc.annotation.Table;
import com.kgc.entity.UserInfor;
import com.kgc.util.PageBean;

public class UserInforDaoImpl implements UserInforDao
{
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserInforDaoImpl.class.getName());
    
    BaseUtilDao bud = new BaseUtilDao();
    
    @Override
    public UserInfor login(UserInfor user)
    {
        String sql = "select * from tb_userInfor where user_name = ? and password = ?";
        // ��user_name ��password ��Ҫ�Ĳ������뵽params����ȥ
        List params = new ArrayList();
        params.add(user.getUserName());
        params.add(user.getPassword());
        
        // ����utilDao�Ĳ�ѯ���� �����Ҫ���û���������ǵ�������Ҳ�����������棬 �˴�ֻ��Ҫ����һ����������list.get(0) ��һ�����󼴿�
        List<UserInfor> list = bud.getAllList(UserInfor.class, sql, params);
        
        if (list != null && list.size() > 0)
        {
            return list.get(0);
        }
        else
        {
            return null;
        }
        
    }
    
    @Override
    public int regist(UserInfor user)
    {
        return bud.save(user);
    }
    
    @Override
    public PageBean<UserInfor> getAllUserList(PageBean pageBean)
    {
        StringBuffer sql = new StringBuffer("select * from ");
        sql.append(UserInfor.class.getAnnotation(Table.class).tableName());
        sql.append(" where 1 = 1 ");
        Object obj = pageBean.getT();
        List params = new ArrayList();
        if (obj != null)
        {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++)
            {
                Field field = fields[i];
                field.setAccessible(true);
                Column column = field.getDeclaredAnnotation(Column.class);
                try
                {
                    if ((column != null && field.get(obj) != null && !column.isPrimaryKEY())
                        && !"".equals(field.get(obj)))
                    {
                        sql.append(" and ").append(column.columnName()).append("  like ? ");
                        params.add(field.get(obj));
                    }
                }
                catch (IllegalArgumentException | IllegalAccessException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        sql.append(" limit ").append(pageBean.getStartIndex()).append(",").append(pageBean.getPageSize());
        System.out.println(sql);
        List<UserInfor> list = bud.getAllList(UserInfor.class, sql.toString(), params);
        pageBean.setList(list);
        
        return pageBean;
    }
    
    @Override
    public int getCount(UserInfor userInfor)
    {
        List params = new ArrayList();
        StringBuffer sql = new StringBuffer("select count(*) from ");
        sql.append(UserInfor.class.getAnnotation(Table.class).tableName());
        sql.append(" where 1 = 1 ");
        
        if (userInfor != null)
        {
            Field[] fields = userInfor.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++)
            {
                Field field = fields[i];
                field.setAccessible(true);
                Column column = field.getDeclaredAnnotation(Column.class);
                try
                {
                    if ((column != null && field.get(userInfor) != null && !column.isPrimaryKEY())
                        && !"".equals(field.get(userInfor)))
                    {
                        sql.append(" and ").append(column.columnName()).append("  like ? ");
                        params.add(field.get(userInfor));
                    }
                }
                catch (IllegalArgumentException | IllegalAccessException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        return bud.getCount(sql.toString(), params);
    }
    
}
