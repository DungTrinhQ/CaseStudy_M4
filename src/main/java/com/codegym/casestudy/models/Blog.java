package com.codegym.casestudy.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private String author;
    private Timestamp dateOfWriting;
//    private Integer likes;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "blog_tag")
    private List<Tag> tags;
}
