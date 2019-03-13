package org.fkit.hrm.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.dao.provider.UserDynaSqlProvider;
import org.fkit.hrm.domain.User;
import static org.fkit.hrm.util.common.HrmConstants.USERTABLE;

/**
 * UserMapper接口
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年12月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface UserDao
{
    
    /**
     * 根据登录名和密码查询员工 <一句话功能简述> <功能详细描述>
     * 
     * @param loginname
     * @param password
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from " + USERTABLE + " where loginname = #{loginname} and password = #{password}")
    User selectByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password);
    
    /**
     * 根据id查询用户 <一句话功能简述> <功能详细描述>
     * 
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from " + USERTABLE + " where ID = #{id}")
    User selectById(Integer id);
    
    /**
     * 根据id删除用户 <一句话功能简述> <功能详细描述>
     * 
     * @param id
     * @see [类、类#方法、类#成员]
     */
    @Delete(" delete from " + USERTABLE + " where id = #{id} ")
    void deleteById(Integer id);
    
    /**
     * 动态修改用户 <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @see [类、类#方法、类#成员]
     */
    @SelectProvider(type = UserDynaSqlProvider.class, method = "updateUser")
    void update(User user);
    
    /**
     * 动态查询 <一句话功能简述> <功能详细描述>
     * 
     * @param params
     * @return
     * @see [类、类#方法、类#成员]
     */
    @SelectProvider(type = UserDynaSqlProvider.class, method = "selectWhitParam")
    List<User> selectByPage(Map<String, Object> params);
    
    /**
     * 根据参数查询用户总数 <一句话功能简述> <功能详细描述>
     * 
     * @param params
     * @return
     * @see [类、类#方法、类#成员]
     */
    @SelectProvider(type = UserDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);
    
    /**
     * 动态插入用户 <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @see [类、类#方法、类#成员]
     */
    @SelectProvider(type = UserDynaSqlProvider.class, method = "insertUser")
    void save(User user);
    
}
