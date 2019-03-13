package org.fkit.hrm.dao.provider;

import static org.fkit.hrm.util.common.HrmConstants.DEPTTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Dept;;

/**
 * 部门动态SQL语句提供类
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年12月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DeptDynaSqlProvider
{
    // 分页动态查询
    public String selectWhitParam(final Map<String, Object> params)
    {
        String sql = new SQL()
        {
            {
                SELECT("*");
                FROM(DEPTTABLE);
                if (params.get("dept") != null)
                {
                    Dept dept = (Dept)params.get("dept");
                    if (dept.getName() != null && !dept.getName().equals(""))
                    {
                        WHERE("  name LIKE CONCAT ('%',#{dept.name},'%') ");
                    }
                }
            }
        }.toString();
        
        if (params.get("pageModel") != null)
        {
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }
        
        return sql;
    }
    
    // 动态查询总数量
    public String count(final Map<String, Object> params)
    {
        return new SQL()
        {
            {
                SELECT("count(*)");
                FROM(DEPTTABLE);
                if (params.get("dept") != null)
                {
                    Dept dept = (Dept)params.get("dept");
                    if (dept.getName() != null && !dept.getName().equals(""))
                    {
                        WHERE("  name LIKE CONCAT ('%',#{dept.name},'%') ");
                    }
                }
            }
        }.toString();
    }
    
    // 动态插入
    public String insertDept(final Dept dept)
    {
        
        return new SQL()
        {
            {
                INSERT_INTO(DEPTTABLE);
                if (dept.getName() != null && !dept.getName().equals(""))
                {
                    VALUES("name", "#{name}");
                }
                if (dept.getRemark() != null && !dept.getRemark().equals(""))
                {
                    VALUES("remark", "#{remark}");
                }
            }
        }.toString();
    }
    
    // 动态更新
    public String updateDept(final Dept dept)
    {
        
        return new SQL()
        {
            {
                UPDATE(DEPTTABLE);
                if (dept.getName() != null)
                {
                    SET(" name = #{name} ");
                }
                if (dept.getRemark() != null)
                {
                    SET(" remark = #{remark} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }
    
}
