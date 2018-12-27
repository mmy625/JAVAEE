package com.kgc.service;

import com.kgc.entity.UserInfor;
import com.kgc.excepiton.LoginException;
import com.kgc.util.PageBean;

/**
 * 用户的业务逻辑层 <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月12日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface UserInforService
{
    /**
     * 登录
     * <一句话功能简述>
     * <功能详细描述>
     * @param user
     * @throws LoginException
     * @see [类、类#方法、类#成员]
     */
    public void login(UserInfor user)
        throws LoginException;
    
    /**
     * 分页查询 <一句话功能简述> <功能详细描述>
     * 
     * @param pageBean
     * @return
     * @see [类、类#方法、类#成员]
     */
    public PageBean<UserInfor> getAllUserList(PageBean<UserInfor> pageBean);
    
    public int saveUser(UserInfor user);
}
