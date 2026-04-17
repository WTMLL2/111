package com.example.demo.repository;

import com.example.demo.entity.LearningResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LearningResourceRepository extends JpaRepository<LearningResource, Long> {
    List<LearningResource> findByCategory(String category);
    List<LearningResource> findByUploaderId(Long uploaderId);
    
    @Query("SELECT l FROM LearningResource l ORDER BY l.views DESC LIMIT :limit")
    List<LearningResource> findTopByViews(@Param("limit") int limit);
    
    @Query("SELECT l FROM LearningResource l ORDER BY l.rating DESC LIMIT :limit")
    List<LearningResource> findTopByRating(@Param("limit") int limit);
}
