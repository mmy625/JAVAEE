package me.gacl.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts2基于注解的Action配置
 * 
 */

@Results({@Result(name = "success", location = "/main.jsp"), @Result(name = "error", location = "/error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception = "java.lange.RuntimeException", result = "error")})
@ParentPackage("struts-default")
@Namespace("/")
public class LoginAction extends ActionSupport
{
    
    private static final long serialVersionUID = 2730268055700929183L;
    
    private String loginName;
    
    private String password;
    
    @Action("login") // 或者写成 @Action(value = "login")
    public String login()
        throws Exception
    {
        System.out.println("login************** ");
        
        if ("yjd".equals(loginName) && "yjd".equals(password))
        {
            return SUCCESS;
        }
        else
        {
            return ERROR;
        }
    }
    
    /**
     * 演示 <一句话功能简述> <功能详细描述>
     * 
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @Action(value = "add", results = {@Result(name = "success", location = "/index.jsp")})
    public String add()
        throws Exception
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("infor", "请求success");
        return SUCCESS;
    }
    
    /**
     * 演示 <一句话功能简述> <功能详细描述>
     * 
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @Action(value = "redirectJsp", results = {@Result(name = "success", type = "redirect", location = "/index.jsp")})
    public String redirect()
        throws Exception
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("infor", "请求success");
        return SUCCESS;
    }
    
    /**
     * action重定向 <一句话功能简述> <功能详细描述>
     * 
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @Action(value = "redirectAction", results = {
        @Result(name = "success", type = "redirect", location = "/login.action")})
    public String redirectAction()
        throws Exception
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("infor", "请求success");
        return SUCCESS;
    }
    
    /**
     * ajax测试 <一句话功能简述> <功能详细描述>
     * 
     * @see [类、类#方法、类#成员]
     */
    @Action(value = "ajax")
    public void ajax()
    {
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        String name = request.getParameter("name");
        
        System.out.println(name + " ***************** ");
        
        try
        {
            response.getWriter().print("1234");
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public String getLoginName()
    {
        return loginName;
    }
    
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
}