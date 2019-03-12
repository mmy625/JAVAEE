package com.waylau.spring.boot.blog.repository;

import org.apache.ibatis.jdbc.SQL;

import com.waylau.spring.boot.blog.domain.User;

/**
 * 
 * <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2019年2月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class UserDynaSqlProvider
{
    
    public String insertWhitParamSql(User user)
    {
        return new SQL()
        {
            {
                INSERT_INTO("t_user");
                System.out.println(user);
                if (user.getUserName() != null && !"".equals(user.getUserName()))
                {
                    VALUES("userName", "#{userName}");
                }
                if (user.getPassword() != null && !"".equals(user.getPassword()))
                {
                    VALUES("password", "#{password}");
                }
                if (user.getAge() != 0)
                {
                    VALUES("age", "#{age}");
                }
                
                
            }
            
        }.toString();
    }
    
    /**
     * 修改用户 动态sql
     * <一句话功能简述>
     * <功能详细描述>
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    public String updateWhitParamSql(User user)
    {
        return new SQL()
        {
            {
                System.out.println(user);
                UPDATE("t_user");
                if (user.getUserName() != null && !"".equals(user.getUserName()))
                {
                    SET("userName=#{userName}");
                }
                if (user.getPassword() != null && !"".equals(user.getPassword()))
                {
                    SET("password=#{password}");
                }
                if(user.getAge() != 0)
                {
                    SET("age=#{age}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
