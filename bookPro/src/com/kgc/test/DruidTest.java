package com.kgc.test;

import org.junit.Test;

import com.kgc.util.druid.JdbcConnectionPool;

/**
 * �������ӳ�Druid ���� 
 * <һ�仰���ܼ���>
 * <������ϸ����>
 * 
 * @author  ���� ����
 * @version  [�汾��, 2018��11��22��]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
public class DruidTest
{
    @Test
    public void getConnection()
    {
        System.out.println(JdbcConnectionPool.getConnection());
    }
}
