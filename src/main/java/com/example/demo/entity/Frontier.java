package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "frontier")
@Data
public class Frontier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String content;
    private String link;
    private String category;
    private Integer views;
    private Long authorId;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
}
