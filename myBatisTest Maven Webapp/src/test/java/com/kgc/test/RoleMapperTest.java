package com.kgc.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.kgc.dao.RoleMapper;
import com.kgc.pojo.Role;
import com.kgc.pojo.User;
import com.kgc.util.MyBatisUtil;

public class RoleMapperTest
{
    
    private Logger logger = Logger.getLogger(RoleMapperTest.class);
    
    SqlSession sqlSession;
    
    @Before
    public void openSession()
    {
        sqlSession = MyBatisUtil.createSqlSession();
    }
    
    @Test
    public void listRoleForMap()
    {
        Map map = new HashMap<String, Object>();
        map.put("roleName", "系统管理员");
        
        List list = sqlSession.getMapper(RoleMapper.class).listRoleForMap(map);
        System.out.println("Map :" + list);
    }
    
    @Test
    public void listRoleForAnnotation()
    {
        
        List list = sqlSession.getMapper(RoleMapper.class).listRoleForAnnotation("系统管理员", "SMBMS_ADMIN");
        System.out.println("Annotation :" + list);
    }
    
    @Test
    public void listRoleForJavaBean()
    {
        Role role = new Role();
        role.setRoleName("系统管理员");
        role.setRoleCode("SMBMS_ADMIN");
        List list = sqlSession.getMapper(RoleMapper.class).listRoleForJavaBean(role);
        System.out.println("Annotation :" + list);
    }
    
    @Test
    public void listRole()
    {
        List list = sqlSession.getMapper(RoleMapper.class).listRole();
        System.out.println("Annotation :" + list);
    }
    
    @Test
    public void listUserByRoleIdForLazy()
    {
        // 输出一条sql语句
        List<User> list = sqlSession.getMapper(RoleMapper.class).listUserByRoleIdForLazy(3);
        
        for (int i = 0; i < list.size(); i++)
        {// 不执行下面的语句，即不会查询role表
            list.get(i).getRole();
        }
    }
    
    @Test
    public void listUserByRoleIdForEanger()
    {
        List<User> list = sqlSession.getMapper(RoleMapper.class).listUserByRoleIdForEanger(3);
        // 输出2条sql语句
    }
    
    /**
     * 分页插件的使用 ，pom.xml文件中引入pagehelper，还需要在config文件中配置分页插件 <一句话功能简述> <功能详细描述>
     * 
     * @see [类、类#方法、类#成员]
     */
    @Test
    public void listRolePageHelper()
    {
        
        PageHelper.startPage(1, 3);
        List<Role> list = sqlSession.getMapper(RoleMapper.class).listRole();
        System.out.println(list);
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
