package com.example.demo.service;

import com.example.demo.entity.UserActivity;

import java.util.List;

public interface UserActivityService {
    UserActivity save(UserActivity activity);
    List<UserActivity> findByUserId(Long userId);
    List<UserActivity> findByResourceId(Long resourceId);
    List<UserActivity> findByActivityType(String activityType);
    List<UserActivity> findAll();
    void delete(Long id);
}
