package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "user_activity")
@Data
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private String activityType; // upload, download, view, comment, like
    private Long resourceId;
    private String content;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityTime;
}
