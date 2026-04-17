package com.example.demo.controller;

import com.example.demo.entity.LearningResource;
import com.example.demo.service.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/resource")
public class LearningResourceController {
    
    @Autowired
    private LearningResourceService resourceService;
    
    @GetMapping("/list")
    public String list(Model model) {
        List<LearningResource> resources = resourceService.findAll();
        model.addAttribute("resources", resources);
        return "resource/list";
    }
    
    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("resource", new LearningResource());
        return "resource/add";
    }
    
    @PostMapping("/add")
    public String add(LearningResource resource) {
        resourceService.save(resource);
        return "redirect:/resource/list";
    }
    
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        LearningResource resource = resourceService.findById(id);
        resourceService.incrementViews(id);
        model.addAttribute("resource", resource);
        return "resource/detail";
    }
    
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        LearningResource resource = resourceService.findById(id);
        model.addAttribute("resource", resource);
        return "resource/edit";
    }
    
    @PostMapping("/edit")
    public String edit(LearningResource resource) {
        resourceService.update(resource);
        return "redirect:/resource/list";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        resourceService.delete(id);
        return "redirect:/resource/list";
    }
    
    @GetMapping("/category/{category}")
    public String byCategory(@PathVariable String category, Model model) {
        List<LearningResource> resources = resourceService.findByCategory(category);
        model.addAttribute("resources", resources);
        model.addAttribute("category", category);
        return "resource/list";
    }
    
    @GetMapping("/top/views")
    public String topViews(Model model) {
        List<LearningResource> resources = resourceService.findTopByViews(10);
        model.addAttribute("resources", resources);
        model.addAttribute("title", "热门资源");
        return "resource/list";
    }
    
    @GetMapping("/top/rating")
    public String topRating(Model model) {
        List<LearningResource> resources = resourceService.findTopByRating(10);
        model.addAttribute("resources", resources);
        model.addAttribute("title", "高评分资源");
        return "resource/list";
    }
}
