package com.codegym.casestudy.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "LONGTEXT",nullable = false)
    private String content;
    private Timestamp postTime;
//    private Integer likes;
    public Blog() {
        this.postTime = new Timestamp(System.currentTimeMillis());
    }

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

}
