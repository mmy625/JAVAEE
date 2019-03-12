package com.waylau.spring.boot.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waylau.spring.boot.blog.domain.User;
import com.waylau.spring.boot.blog.repository.UserMapper;

/**
 * user控制器
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2019年2月20日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
public class UserController
{
    
    @Autowired
    UserMapper userMapper;
    
    /**
     * 请求list
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/")
    public String index()
    {
        return "redirect:/list";
    }
    
    /**
     * 请求数据 并跳转到视图页面 显示数据
     * <一句话功能简述>
     * <功能详细描述>
     * @param model
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/list")
    public String list(Model model)
    {
        List<User> users = userMapper.listUser();
        System.out.println(users);
        model.addAttribute("users", users);
        return "user/list";
    }
    
    @RequestMapping("/toAdd")
    public String toAdd()
    {
        return "user/userAdd";
    }
    
    @RequestMapping("/add")
    public String add(User user)
    {
        userMapper.saveUser(user);
        return "redirect:/list";
    }
    
    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id)
    {
         User user=userMapper.getUserById(id);
         model.addAttribute("user", user);
        return "user/userEdit";
    }
    
    @RequestMapping("/edit")
    public String edit(User user)
    {
        userMapper.updateUser(user);
        return "redirect:/list";
    }
    
    @RequestMapping("/delete")
    public String delete(Long id)
    {
         userMapper.deleteUserById(id);
        return "redirect:/list";
    }
}
