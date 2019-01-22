package com.kgc.test;

import org.junit.Test;

import com.kgc.util.druid.JdbcConnectionPool;

/**
 * 阿里连接池Druid 测试 
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年11月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DruidTest
{
    @Test
    public void getConnection()
    {
        System.out.println(JdbcConnectionPool.getConnection());
    }
}
