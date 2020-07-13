package com.codegym.casestudy.service;

import com.codegym.casestudy.models.Tag;
import com.codegym.casestudy.models.User;

import java.util.List;

public interface ITagService {
    List<Tag> findAll();
    Tag findOne(Long id);
    Tag createUser(Tag tag);
    Tag delete(Long id);
}
