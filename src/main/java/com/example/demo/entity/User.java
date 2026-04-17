package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String password;
    private String email;
    private String name;
    private String role; // admin, teacher, student
    private String major; // 专业
    private String avatar;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
}
