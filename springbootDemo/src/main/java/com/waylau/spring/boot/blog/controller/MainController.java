package com.waylau.spring.boot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器.
 * 
 * @since 1.0.0 2017年7月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Controller
public class MainController
{
    
//    @Autowired
//    UserService userService;
    
    @GetMapping("/")
    public String root()
    {
        return "redirect:/index";
    }
    
    @GetMapping("/index")
    public String index()
    {
        return "index";
    }
    
    /**
     * 跳转到login.jsp <一句话功能简述> <功能详细描述>
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    
    /**
     * 跳转到注册页面 <一句话功能简述> <功能详细描述>
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    @GetMapping("/register")
    public String register()
    {
        return "register";
    }
    
//    /**
//     * 注册用户 <一句话功能简述> <功能详细描述>
//     * 
//     * @param user
//     * @return
//     * @see [类、类#方法、类#成员]
//     */
//    @PostMapping("/register")
//    public String registerUser(User user)
//    {
//        userService.registerUser(user);
//        return "redirect:/login";
//    }
//    
//    
//    
//    
//    @GetMapping("/login-error")
//    public String loginError(Model model)
//    {
//        model.addAttribute("loginError", true);
//        model.addAttribute("errorMsg", "登录失败，用户名或者密码错误！");
//        return "login";
//    }
//    
//    @PostMapping("/from")
//    public String upload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file)
//    {
//        return "register";
//    }
    
}
