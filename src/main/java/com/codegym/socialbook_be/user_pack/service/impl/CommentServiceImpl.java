package com.codegym.socialbook_be.user_pack.service.impl;

import com.codegym.socialbook_be.security_pack.security.userpincal.UserDetailService;
import com.codegym.socialbook_be.user_pack.model.Comment;
import com.codegym.socialbook_be.user_pack.repository.ICommentRepo;
import com.codegym.socialbook_be.user_pack.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentRepo commentRepo;
    @Autowired
    UserDetailService userDetailService;

    @Override
    public List<Comment> getCommentByPostId(Long id) {
        return commentRepo.getCommentByPostId(id);
    }

    @Override
    public Comment save(Comment comment) {
        comment.setUsers(userDetailService.getCurrentUser());
        return commentRepo.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        commentRepo.deleteById(id);
    }
}
