package com.kgc.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis 工具类 <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月27日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MyBatisUtil
{
    private static SqlSessionFactory factory;
    
    static
    {// 在静态代码块下，factory只会被创建一次
        System.out.println("static factory===============");
        try
        {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * 提供static方法 根据factory 创建 会话对象 SQLSession <一句话功能简述> <功能详细描述>
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static SqlSession createSqlSession()
    {
        return factory.openSession(false);// true 为自动提交事务
    }
    
    /**
     * 关闭会话 <一句话功能简述> <功能详细描述>
     * 
     * @param sqlSession
     * @see [类、类#方法、类#成员]
     */
    public static void closeSqlSession(SqlSession sqlSession)
    {
        if (null != sqlSession)
        {
            sqlSession.close();
        }
    }
    
}
