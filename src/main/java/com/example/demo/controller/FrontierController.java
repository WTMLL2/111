package com.example.demo.controller;

import com.example.demo.entity.Frontier;
import com.example.demo.service.FrontierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/frontier")
public class FrontierController {
    
    @Autowired
    private FrontierService frontierService;
    
    @GetMapping("/list")
    public String list(Model model) {
        List<Frontier> frontiers = frontierService.findAll();
        model.addAttribute("frontiers", frontiers);
        return "frontier/list";
    }
    
    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("frontier", new Frontier());
        return "frontier/add";
    }
    
    @PostMapping("/add")
    public String add(Frontier frontier) {
        frontierService.save(frontier);
        return "redirect:/frontier/list";
    }
    
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Frontier frontier = frontierService.findById(id);
        frontierService.incrementViews(id);
        model.addAttribute("frontier", frontier);
        return "frontier/detail";
    }
    
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        Frontier frontier = frontierService.findById(id);
        model.addAttribute("frontier", frontier);
        return "frontier/edit";
    }
    
    @PostMapping("/edit")
    public String edit(Frontier frontier) {
        frontierService.update(frontier);
        return "redirect:/frontier/list";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        frontierService.delete(id);
        return "redirect:/frontier/list";
    }
    
    @GetMapping("/category/{category}")
    public String byCategory(@PathVariable String category, Model model) {
        List<Frontier> frontiers = frontierService.findByCategory(category);
        model.addAttribute("frontiers", frontiers);
        model.addAttribute("category", category);
        return "frontier/list";
    }
    
    @GetMapping("/top/views")
    public String topViews(Model model) {
        List<Frontier> frontiers = frontierService.findTopByViews(10);
        model.addAttribute("frontiers", frontiers);
        model.addAttribute("title", "热门前沿技术");
        return "frontier/list";
    }
}
