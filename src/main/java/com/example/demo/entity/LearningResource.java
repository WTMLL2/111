package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "learning_resource")
@Data
public class LearningResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private String type; // 视频、文档、图片等
    private String url;
    private String coverImage;
    private Long uploaderId;
    private String category;
    private Integer views;
    private Integer downloads;
    private Double rating;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
}
