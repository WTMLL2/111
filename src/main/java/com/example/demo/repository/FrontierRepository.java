package com.example.demo.repository;

import com.example.demo.entity.Frontier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FrontierRepository extends JpaRepository<Frontier, Long> {
    List<Frontier> findByCategory(String category);
    
    @Query("SELECT f FROM Frontier f ORDER BY f.views DESC LIMIT :limit")
    List<Frontier> findTopByViews(@Param("limit") int limit);
}
