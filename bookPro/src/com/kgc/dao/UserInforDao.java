package com.kgc.dao;

import com.kgc.entity.UserInfor;
import com.kgc.util.PageBean;

/**
 * 用户的持久层 <一句话功能简述> <功能详细描述>
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年12月1日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface UserInforDao
{
    /**
     * 
     * <登录> <功能详细描述>
     * 
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    public UserInfor login(UserInfor user);
    /**
     * 根据条件查询,并返回组装好的分页对象
     * <一句话功能简述>
     * <功能详细描述>
     * @param pageBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    public PageBean<UserInfor> getAllUserList(PageBean pageBean);
    
    /**
     * 根据条件查询 得到总的记录数
     * <一句话功能简述>
     * <功能详细描述>
     * @param userInfor
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int getCount(UserInfor userInfor);
    
    /**
     * 
     * <注册> <功能详细描述>
     * 
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int regist(UserInfor user);
}
