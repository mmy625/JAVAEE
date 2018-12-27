package com.kgc.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kgc.dao.AddressMapper;
import com.kgc.dao.RoleMapper;
import com.kgc.pojo.Address;
import com.kgc.pojo.Role;
import com.kgc.pojo.User;
import com.kgc.util.MyBatisUtil;

public class AddressMapperTest
{
    
    private Logger logger = Logger.getLogger(AddressMapperTest.class);
    
    SqlSession sqlSession;
    
    @Before
    public void openSession()
    {
        sqlSession = MyBatisUtil.createSqlSession();
    }
    
    @Test
    public void listAddressByUserId()
    {
        
        List list = sqlSession.getMapper(AddressMapper.class).listAddressByUserId(5);
        System.out.println("list :" + list);
    }
    
    @Test
    public void selectWithParam()
    {
        Address address = new Address();
        address.setId(6);
        address.setContact("王国强");
        address.setPostCode("100061");
        List list = sqlSession.getMapper(AddressMapper.class).selectWithParam(address);
        System.out.println("list :" + list);
    }
    
    @Test
    public void selectWithParamLike()
    {
        Address address = new Address();
        address.setAddressDesc("44");
        List list = sqlSession.getMapper(AddressMapper.class).selectWithParam(address);
        System.out.println("list :" + list);
    }
    
    
    @Test
    public void insertAddress()
    {
        
        Address address = new Address();
        address.setContact("董方轮");
        address.setPostCode("100061");
        address.setModifyDate(new Date());
        address.setUserId(5);
        address.setAddressDesc("成都市武侯区");
        
        sqlSession.getMapper(AddressMapper.class).insertAddress(address);
        sqlSession.commit();
    }
    
    @After
    public void closeResouce()
    {
        if (sqlSession != null)
        {
            sqlSession.close();
        }
    }
    
}
