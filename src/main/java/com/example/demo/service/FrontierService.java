package com.example.demo.service;

import com.example.demo.entity.Frontier;

import java.util.List;

public interface FrontierService {
    Frontier save(Frontier frontier);
    Frontier findById(Long id);
    List<Frontier> findAll();
    List<Frontier> findByCategory(String category);
    List<Frontier> findTopByViews(int limit);
    Frontier update(Frontier frontier);
    void delete(Long id);
    void incrementViews(Long id);
}
