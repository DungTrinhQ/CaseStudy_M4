package com.codegym.casestudy.models;

import lombok.Data;

import javax.persistence.*;
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
    private Date dateOfWriting;
//    private Integer likes;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;
}
