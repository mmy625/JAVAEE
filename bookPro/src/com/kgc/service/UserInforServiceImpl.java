package com.kgc.service;

import com.kgc.dao.UserInforDao;
import com.kgc.dao.UserInforDaoImpl;
import com.kgc.entity.UserInfor;
import com.kgc.excepiton.LoginException;
import com.kgc.util.PageBean;

/**
 * 
 * <һ�仰���ܼ���> <������ϸ����>
 * 
 * @author ���� ����
 * @version [�汾��, 2018��11��12��]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
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
            throw new LoginException("�û������ڻ�������������֤");
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
