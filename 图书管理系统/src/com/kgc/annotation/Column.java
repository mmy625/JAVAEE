package com.kgc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * <һ�仰���ܼ���>
 * <������ϸ����>
 * 
 * @author  ���� ����
 * @version  [�汾��, 2018��11��10��]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
@Retention(RetentionPolicy.RUNTIME) //��������
@Target(ElementType.FIELD)//����������
public @interface Column
{
    public String columnName();//�е�����
    
    public boolean isPrimaryKEY() default false;//�Ƿ�������
    
    public boolean isAuto() default true; //Ĭ��������
    
    
    
}
