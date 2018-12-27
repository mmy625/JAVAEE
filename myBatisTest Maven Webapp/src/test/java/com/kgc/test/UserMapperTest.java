package com.kgc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kgc.dao.AddressMapper;
import com.kgc.dao.UserMapper;
import com.kgc.pojo.User;
import com.kgc.util.MyBatisUtil;

/**
 * 用户的单元测试 此单元测试 每页关闭资源 sqlSession <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月30日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class UserMapperTest
{
    private Logger logger = Logger.getLogger(UserMapperTest.class);
    
    @Before
    public void setUp()
        throws Exception
    {
    }
    
    @Test
    public void test()
    {
        String resource = "mybatis-config.xml";
        int count = 0;
        SqlSession sqlSession = null;
        try
        {
            // 1 获取mybatis-config.xml的输入流
            InputStream is = Resources.getResourceAsStream(resource);
            // 2 创建SqlSessionFactory对象，完成对配置文件的读取
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            // 3 创建sqlSession
            sqlSession = factory.openSession();
            // 4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
            count = sqlSession.selectOne("com.kgc.dao.UserMapper.count");
            // logger.debug("UserMapperTest count---> " + count);
            System.out.println(count);
        }
        catch (IOException e)
        {
            // logger.debug(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            if (sqlSession != null)
            {
                sqlSession.close();
            }
            
        }
    }
    
    @Test
    public void listUser()
    {
        String resource = "mybatis-config.xml";
        int count = 0;
        SqlSession sqlSession = null;
        try
        {
            // 1 获取mybatis-config.xml的输入流
            InputStream is = Resources.getResourceAsStream(resource);
            // 2 创建SqlSessionFactory对象，完成对配置文件的读取
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            // 3 创建sqlSession
            sqlSession = factory.openSession();
            // 4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
            Map map = new HashMap<String, String>();
            map.put("userPassword", "1234567");
            map.put("gender", "1");
            
            List list = sqlSession.selectList("com.kgc.dao.UserMapper.getUserList", map);
            System.out.println(list);
            // logger.debug("UserMapperTest listUser---> " + list);
        }
        catch (IOException e)
        {
            // logger.debug(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            if (sqlSession != null)
            {
                sqlSession.close();
            }
            
        }
    }
    
    @Test
    public void saveUser()
    {
        //
        String resource = "mybatis-config.xml";
        int count = 0;
        SqlSession sqlSession = null;
        try
        {
            // 1 获取mybatis-config.xml的输入流
            InputStream is = Resources.getResourceAsStream(resource);
            // 2 创建SqlSessionFactory对象，完成对配置文件的读取
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            // 3 创建sqlSession
            sqlSession = factory.openSession();
            // 4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
            User user = new User();
            user.setUserName("mmy");
            
            count = sqlSession.insert("com.kgc.dao.UserMapper.saveUser", user);
            sqlSession.commit();
            System.out.println(count);
            // logger.debug("UserMapperTest listUser---> " + list);
        }
        catch (IOException e)
        {
            // logger.debug(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            if (sqlSession != null)
            {
                sqlSession.close();
            }
            
        }
    }
    
    @Test
    public void getUserListForMapper()
    {
        //
        String resource = "mybatis-config.xml";
        int count = 0;
        SqlSession sqlSession = null;
        try
        {
            // 1 获取mybatis-config.xml的输入流
            InputStream is = Resources.getResourceAsStream(resource);
            // 2 创建SqlSessionFactory对象，完成对配置文件的读取
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            // 3 创建sqlSession
            sqlSession = factory.openSession();
            // 4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
            User user = new User();
            user.setGender(1);
            user.setUserName("系统管理员");
            List list = sqlSession.getMapper(UserMapper.class).getUserList(user);
            System.out.println(list);
            // logger.debug("UserMapperTest listUser---> " + list);
        }
        catch (IOException e)
        {
            // logger.debug(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            if (sqlSession != null)
            {
                sqlSession.close();
            }
            
        }
    }
    
    /**
     * 通过MyBatisUtil工具类进行查询操作 <一句话功能简述> <功能详细描述>
     * 
     * @see [类、类#方法、类#成员]
     */
    @Test
    public void getUserById()
    {
        SqlSession session = MyBatisUtil.createSqlSession();
        User user = session.selectOne("com.kgc.dao.UserMapper.getUserById", 2);
        System.out.println(user);
        MyBatisUtil.closeSqlSession(session);
    }
    
    /**
     * 调用sqlSession.getMapper(Mapper.class)执行DAO接口方法来实现对数据的查询操作 <一句话功能简述> <功能详细描述>
     * 
     * @see [类、类#方法、类#成员]
     */
    @Test
    public void getCountMapper()
    {
        SqlSession session = null;
        int count = 0;
        
        session = MyBatisUtil.createSqlSession();
        // count = session.getMapper(UserMapper.class).count();
        // System.out.println(count);
        //
        User u = new User();
        u.setUserName("系统管理员111");
        u.setGender(1);
        // List list = session.getMapper(UserMapper.class).getUserList(u);
        // System.out.println(list);
        count = session.getMapper(UserMapper.class).saveUser(u);
        session.commit();
        System.out.println("save:" + count);
    }
    
    @Test
    public void listUserLikeName()
    {
        SqlSession session = null;
        
        session = MyBatisUtil.createSqlSession();
        User u = new User();
        u.setUserName("管");
        
        List list = session.getMapper(UserMapper.class).listUserLikeName(u);
        System.out.println("save:" + list);
    }
    
    @Test
    public void listUserResultMap()
    {
        SqlSession session = null;
        
        session = MyBatisUtil.createSqlSession();
        
        List list = session.getMapper(UserMapper.class).listUserResultMap();
        System.out.println("result:" + list);
    }
    
    @Test
    public void getUserByIdForCommon()
    {
        SqlSession session = null;
        
        session = MyBatisUtil.createSqlSession();
        
        User user = session.getMapper(UserMapper.class).getUserByIdForCommon(5);
        System.out.println("result:" + user);
    }
    
    @Test
    public void getUserListByRoleId()
    {
        SqlSession session = null;
        
        session = MyBatisUtil.createSqlSession();
        List list = session.getMapper(UserMapper.class).getUserListByRoleId(3);
        System.out.println(list);
    }
    
    @Test
    public void getAddressListByUserId()
    {
        SqlSession session = null;
        
        session = MyBatisUtil.createSqlSession();
        User user = session.getMapper(UserMapper.class).getAddressListByUserId(1);
        System.out.println(user.getAddressList());
    }
    
    @Test
    public void listUserByRoleIdAndUserName()
    {
        
        SqlSession session = null;
        session = MyBatisUtil.createSqlSession();
        User user = new User();
        user.setUserRole(3);
        // user.setUserName("燕");
        List list = session.getMapper(UserMapper.class).listUserByRoleIdAndUserName(user);
        System.out.println(list.size());
        
    }
    
    @Test
    public void modifyUser()
    {
        SqlSession session = null;
        session = MyBatisUtil.createSqlSession();
        User user = session.getMapper(UserMapper.class).getUserByIdForCommon(5);
        user.setUserName("韩路彪哥");
        session.getMapper(UserMapper.class).modifyUser(user);
        session.commit();
        
    }
    
    @Test
    public void selectUserByListId()
    {
        SqlSession session = null;
        session = MyBatisUtil.createSqlSession();
        List list = new ArrayList();
        // list.add(5);
        // list.add(8);
        // list.add(10);
        
        List userList = session.getMapper(UserMapper.class).selectUserByListId(list);
        System.out.println(userList.size());
    }
    
    @Test
    public void selectUserByArrayId()
    {
        SqlSession session = null;
        session = MyBatisUtil.createSqlSession();
        int[] ids = {5, 8, 10};
        List userList = session.getMapper(UserMapper.class).selectUserByArrayId(ids);
        System.out.println(userList.size());
    }
    
    @Test
    public void getUserByIdForOneTwoMany()
    {
        SqlSession session = null;
        session = MyBatisUtil.createSqlSession();
        
        User user = session.getMapper(UserMapper.class).getUserByIdForOneTwoMany(5);
        System.out.println(user.getAddressList());
    }
    
    /**
     * 分页插件的使用 ，pom.xml文件中引入pagehelper，还需要在config文件中配置分页插件 <一句话功能简述> <功能详细描述>
     * 
     * @see [类、类#方法、类#成员]
     */
    @Test
    public void listUsrePageHelper()
    {
        
        PageHelper.startPage(2, 10);
        Page p = (Page)MyBatisUtil.createSqlSession().getMapper(UserMapper.class).listUserPageHelper();
        logger.debug(p.getPageNum());
        logger.debug(p.getTotal());
        logger.debug(p.get(0));
    }
    
}
