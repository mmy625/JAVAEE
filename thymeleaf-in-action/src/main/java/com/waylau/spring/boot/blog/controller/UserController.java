package com.waylau.spring.boot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.waylau.spring.boot.blog.domain.User;
import com.waylau.spring.boot.blog.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserRepository userRepository;
    
    /**
     * 查询所有的用户 <一句话功能简述> <功能详细描述>
     * 
     * @param model
     * @return
     * @see [类、类#方法、类#成员]
     */
    @GetMapping
    public ModelAndView list(Model model)
    {
        model.addAttribute("userList", userRepository.listUser());
        model.addAttribute("title", "用户管理");
        
        return new ModelAndView("users/list", "userModel", model);
    }
    
    /**
     * 根据id查询用户 <一句话功能简述> <功能详细描述>
     * 
     * @param id
     * @param model
     * @return
     * @see [类、类#方法、类#成员]
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("user", userRepository.getUserById(id));
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }
    
    /**
     * 获取创建用户的页面 <一句话功能简述> <功能详细描述>
     * 
     * @param model
     * @return
     * @see [类、类#方法、类#成员]
     */
    @GetMapping("/form")
    public ModelAndView createFrom(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }
//    
    /**
     * 保存用户 <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user)
    {
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }
    
    /**
     * 删除用户 <一句话功能简述> <功能详细描述>
     * 
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    @GetMapping("{delete/{id}}")
    public ModelAndView delete(@PathVariable("id") Long id)
    {
        userRepository.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }
    
    /**
     * 获取修改用户的界面
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @param model
     * @return
     * @see [类、类#方法、类#成员]
     */
    @GetMapping("modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model)
    {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", "user");
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
    
}
