package com.codegym.casestudy.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String keyWord;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs;
//    @ManyToMany(cascade = CascadeType.ALL)
////    @JoinTable(name = "blog_tag")
//    private List<Blog> blogs;
}
