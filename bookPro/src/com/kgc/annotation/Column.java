package com.kgc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年11月10日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Retention(RetentionPolicy.RUNTIME) //生命周期
@Target(ElementType.FIELD)//作用于属性
public @interface Column
{
    public String columnName();//列的名字
    
    public boolean isPrimaryKEY() default false;//是否是主键
    
    public boolean isAuto() default true; //默认是自增
    
    
    
}
