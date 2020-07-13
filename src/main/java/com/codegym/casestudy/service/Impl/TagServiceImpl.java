package com.codegym.casestudy.service.Impl;

import com.codegym.casestudy.models.Tag;
import com.codegym.casestudy.repositories.ITagRepository;
import com.codegym.casestudy.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagServiceImpl implements ITagService {
    @Autowired
    private ITagRepository tagRepository;
    @Override
    public List<Tag> findAll() {
        return (List<Tag>) tagRepository.findAll();
    }

    @Override
    public Tag findOne(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag createUser(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag delete(Long id) {
        Tag tag = tagRepository.findById(id).orElse(null);
        tagRepository.delete(tag);
        return tag;
    }
}
