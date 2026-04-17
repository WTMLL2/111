package com.example.demo.service.impl;

import com.example.demo.entity.UserActivity;
import com.example.demo.repository.UserActivityRepository;
import com.example.demo.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserActivityServiceImpl implements UserActivityService {
    
    @Autowired
    private UserActivityRepository activityRepository;
    
    @Override
    public UserActivity save(UserActivity activity) {
        activity.setActivityTime(new Date());
        return activityRepository.save(activity);
    }
    
    @Override
    public List<UserActivity> findByUserId(Long userId) {
        return activityRepository.findByUserId(userId);
    }
    
    @Override
    public List<UserActivity> findByResourceId(Long resourceId) {
        return activityRepository.findByResourceId(resourceId);
    }
    
    @Override
    public List<UserActivity> findByActivityType(String activityType) {
        return activityRepository.findByActivityType(activityType);
    }
    
    @Override
    public List<UserActivity> findAll() {
        return activityRepository.findAll();
    }
    
    @Override
    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
}
