package com.kgc.service;

import com.kgc.entity.UserInfor;
import com.kgc.excepiton.LoginException;
import com.kgc.util.PageBean;

/**
 * �û���ҵ���߼��� <һ�仰���ܼ���> <������ϸ����>
 * 
 * @author ���� ����
 * @version [�汾��, 2018��11��12��]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
 */
public interface UserInforService
{
    /**
     * ��¼
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param user
     * @throws LoginException
     * @see [�ࡢ��#��������#��Ա]
     */
    public void login(UserInfor user)
        throws LoginException;
    
    /**
     * ��ҳ��ѯ <һ�仰���ܼ���> <������ϸ����>
     * 
     * @param pageBean
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public PageBean<UserInfor> getAllUserList(PageBean<UserInfor> pageBean);
    
    public int saveUser(UserInfor user);
}
