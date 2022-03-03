package com.codegym.socialbook_be.user_pack.controller;

import com.codegym.socialbook_be.security_pack.service.IUserService;
import com.codegym.socialbook_be.user_pack.model.Post;
import com.codegym.socialbook_be.user_pack.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    IPostService postService;
    @Autowired
    IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        post.setTime(date);
        post.setPublic(true);
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> findAll() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Post> edit(@RequestBody Post post, @PathVariable Long id) {
        post.setId(id);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        post.setTime(date);
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.deleteById(id);
    }

}
