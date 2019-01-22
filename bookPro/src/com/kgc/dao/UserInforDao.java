package com.kgc.dao;

import com.kgc.entity.UserInfor;
import com.kgc.util.PageBean;

/**
 * �û��ĳ־ò� <һ�仰���ܼ���> <������ϸ����>
 * <һ�仰���ܼ���>
 * <������ϸ����>
 * 
 * @author  ���� ����
 * @version  [�汾��, 2018��12��1��]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
public interface UserInforDao
{
    /**
     * 
     * <��¼> <������ϸ����>
     * 
     * @param user
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public UserInfor login(UserInfor user);
    /**
     * ����������ѯ,��������װ�õķ�ҳ����
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param pageBean
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public PageBean<UserInfor> getAllUserList(PageBean pageBean);
    
    /**
     * ����������ѯ �õ��ܵļ�¼��
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param userInfor
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public int getCount(UserInfor userInfor);
    
    /**
     * 
     * <ע��> <������ϸ����>
     * 
     * @param user
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public int regist(UserInfor user);
}
