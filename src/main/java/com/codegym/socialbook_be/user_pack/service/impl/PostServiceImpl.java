package com.codegym.socialbook_be.user_pack.service.impl;

import com.codegym.socialbook_be.user_pack.model.Post;
import com.codegym.socialbook_be.user_pack.repository.IPostRepository;
import com.codegym.socialbook_be.user_pack.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAllShortByTime();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }
}
