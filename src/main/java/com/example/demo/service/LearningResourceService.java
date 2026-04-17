package com.example.demo.service;

import com.example.demo.entity.LearningResource;

import java.util.List;

public interface LearningResourceService {
    LearningResource save(LearningResource resource);
    LearningResource findById(Long id);
    List<LearningResource> findAll();
    List<LearningResource> findByCategory(String category);
    List<LearningResource> findByUploaderId(Long uploaderId);
    List<LearningResource> findTopByViews(int limit);
    List<LearningResource> findTopByRating(int limit);
    LearningResource update(LearningResource resource);
    void delete(Long id);
    void incrementViews(Long id);
    void incrementDownloads(Long id);
}
