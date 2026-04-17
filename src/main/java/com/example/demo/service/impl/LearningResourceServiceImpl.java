package com.example.demo.service.impl;

import com.example.demo.entity.LearningResource;
import com.example.demo.repository.LearningResourceRepository;
import com.example.demo.service.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LearningResourceServiceImpl implements LearningResourceService {
    
    @Autowired
    private LearningResourceRepository resourceRepository;
    
    @Override
    public LearningResource save(LearningResource resource) {
        resource.setUploadTime(new Date());
        resource.setUpdatedTime(new Date());
        resource.setViews(0);
        resource.setDownloads(0);
        resource.setRating(0.0);
        return resourceRepository.save(resource);
    }
    
    @Override
    public LearningResource findById(Long id) {
        return resourceRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<LearningResource> findAll() {
        return resourceRepository.findAll();
    }
    
    @Override
    public List<LearningResource> findByCategory(String category) {
        return resourceRepository.findByCategory(category);
    }
    
    @Override
    public List<LearningResource> findByUploaderId(Long uploaderId) {
        return resourceRepository.findByUploaderId(uploaderId);
    }
    
    @Override
    public List<LearningResource> findTopByViews(int limit) {
        return resourceRepository.findTopByViews(limit);
    }
    
    @Override
    public List<LearningResource> findTopByRating(int limit) {
        return resourceRepository.findTopByRating(limit);
    }
    
    @Override
    public LearningResource update(LearningResource resource) {
        resource.setUpdatedTime(new Date());
        return resourceRepository.save(resource);
    }
    
    @Override
    public void delete(Long id) {
        resourceRepository.deleteById(id);
    }
    
    @Override
    public void incrementViews(Long id) {
        LearningResource resource = findById(id);
        if (resource != null) {
            resource.setViews(resource.getViews() + 1);
            resourceRepository.save(resource);
        }
    }
    
    @Override
    public void incrementDownloads(Long id) {
        LearningResource resource = findById(id);
        if (resource != null) {
            resource.setDownloads(resource.getDownloads() + 1);
            resourceRepository.save(resource);
        }
    }
}
