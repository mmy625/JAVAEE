package com.waylau.spring.boot.blog.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.waylau.spring.boot.blog.domain.User;

public interface UserMapper
{
    /**
     * 
     * <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    @InsertProvider(type = UserDynaSqlProvider.class, method = "insertWhitParamSql")
    int saveUser(User user);
    
    /**
     * 根据id删除 <一句话功能简述> <功能详细描述>
     * 
     * @param id
     * @see [类、类#方法、类#成员]
     */
    @Delete("delete from t_user where id = #{id}")
    void deleteUserById(Long id);
    
    /**
     * 根据id获取用户 <一句话功能简述> <功能详细描述>
     * 
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User getUserById(Long id);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from t_user")
    List<User> listUser();
    
    
    @UpdateProvider(type=UserDynaSqlProvider.class,method="updateWhitParamSql")
    void updateUser(User user);

}
