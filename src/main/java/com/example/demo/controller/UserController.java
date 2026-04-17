package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }
    
    @PostMapping("/register")
    public String register(User user) {
        userService.register(user);
        return "redirect:/user/login";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/";
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "user/login";
        }
    }
    
    @GetMapping("/list")
    public String list(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/list";
    }
    
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }
    
    @PostMapping("/edit")
    public String edit(User user) {
        userService.update(user);
        return "redirect:/user/list";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/user/list";
    }
}
