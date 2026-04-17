package com.example.demo.service.impl;

import com.example.demo.entity.Frontier;
import com.example.demo.repository.FrontierRepository;
import com.example.demo.service.FrontierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FrontierServiceImpl implements FrontierService {
    
    @Autowired
    private FrontierRepository frontierRepository;
    
    @Override
    public Frontier save(Frontier frontier) {
        frontier.setPublishTime(new Date());
        frontier.setUpdatedTime(new Date());
        frontier.setViews(0);
        return frontierRepository.save(frontier);
    }
    
    @Override
    public Frontier findById(Long id) {
        return frontierRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Frontier> findAll() {
        return frontierRepository.findAll();
    }
    
    @Override
    public List<Frontier> findByCategory(String category) {
        return frontierRepository.findByCategory(category);
    }
    
    @Override
    public List<Frontier> findTopByViews(int limit) {
        return frontierRepository.findTopByViews(limit);
    }
    
    @Override
    public Frontier update(Frontier frontier) {
        frontier.setUpdatedTime(new Date());
        return frontierRepository.save(frontier);
    }
    
    @Override
    public void delete(Long id) {
        frontierRepository.deleteById(id);
    }
    
    @Override
    public void incrementViews(Long id) {
        Frontier frontier = findById(id);
        if (frontier != null) {
            frontier.setViews(frontier.getViews() + 1);
            frontierRepository.save(frontier);
        }
    }
}
