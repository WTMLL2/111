package com.example.demo.controller;

import com.example.demo.entity.UserActivity;
import com.example.demo.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/activity")
public class UserActivityController {
    
    @Autowired
    private UserActivityService activityService;
    
    @GetMapping("/list")
    public String list(Model model) {
        List<UserActivity> activities = activityService.findAll();
        model.addAttribute("activities", activities);
        return "activity/list";
    }
    
    @GetMapping("/user/{userId}")
    public String userActivities(@PathVariable Long userId, Model model) {
        List<UserActivity> activities = activityService.findByUserId(userId);
        model.addAttribute("activities", activities);
        model.addAttribute("userId", userId);
        return "activity/list";
    }
    
    @GetMapping("/resource/{resourceId}")
    public String resourceActivities(@PathVariable Long resourceId, Model model) {
        List<UserActivity> activities = activityService.findByResourceId(resourceId);
        model.addAttribute("activities", activities);
        model.addAttribute("resourceId", resourceId);
        return "activity/list";
    }
    
    @GetMapping("/type/{type}")
    public String typeActivities(@PathVariable String type, Model model) {
        List<UserActivity> activities = activityService.findByActivityType(type);
        model.addAttribute("activities", activities);
        model.addAttribute("type", type);
        return "activity/list";
    }
    
    @PostMapping("/add")
    @ResponseBody
    public String add(UserActivity activity) {
        activityService.save(activity);
        return "success";
    }
}
