package com.kgc.service;

import com.kgc.dao.UserInforDao;
import com.kgc.dao.UserInforDaoImpl;
import com.kgc.entity.UserInfor;
import com.kgc.excepiton.LoginException;
import com.kgc.util.PageBean;

/**
 * 
 * <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年11月12日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class UserInforServiceImpl implements UserInforService
{
    
    UserInforDao uid = new UserInforDaoImpl();
    
    @Override
    public void login(UserInfor user)
        throws LoginException
    {
        UserInfor userInfor = uid.login(user);
        if (userInfor == null)
        {
            throw new LoginException("用户不存在或者密码错误，请查证");
        }
    }
    
    @Override
    public PageBean<UserInfor> getAllUserList(PageBean<UserInfor> pageBean)
    {
        int totalRecord = uid.getCount(pageBean.getT());
        pageBean.setTotalRecord(totalRecord);
        
        return uid.getAllUserList(pageBean);
    }

    @Override
    public int saveUser(UserInfor user)
    {
//         uid.save(user);
//        adminDao.save(admin);
        return 0;
    }
    
}
