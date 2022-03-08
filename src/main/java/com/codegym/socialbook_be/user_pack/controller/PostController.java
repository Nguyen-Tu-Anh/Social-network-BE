package com.codegym.socialbook_be.user_pack.controller;

import com.codegym.socialbook_be.security_pack.dto.response.ResponseMessage;
import com.codegym.socialbook_be.security_pack.security.userpincal.UserDetailService;
import com.codegym.socialbook_be.security_pack.service.IUserService;
import com.codegym.socialbook_be.user_pack.dto.PostDto;
import com.codegym.socialbook_be.user_pack.model.Comment;
import com.codegym.socialbook_be.user_pack.model.Likes;
import com.codegym.socialbook_be.user_pack.model.Post;
import com.codegym.socialbook_be.user_pack.model.Users;
import com.codegym.socialbook_be.user_pack.service.ICommentService;
import com.codegym.socialbook_be.user_pack.service.ILikeService;
import com.codegym.socialbook_be.user_pack.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    IPostService postService;
    @Autowired
    IUserService userService;

    @Autowired
    ILikeService likeService;

    @Autowired
    ICommentService commentService;

    @Autowired
    UserDetailService userDetailService;

    @PostMapping("/create")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        post.setTime(date);
        post.setPublic(true);
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @GetMapping("")
    public List<PostDto> findAll() {
        List<Post> posts = postService.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        Users user = userDetailService.getCurrentUser();
        List<Likes> likesList = likeService.findAll();

        for (Post post : posts) {
            PostDto postDto = new PostDto(post.getId(), post.getContent(), post.isPublic(), post.getImage(), post.getTime(), true, post.getUsers());
            for (Likes like : likesList) {
                if (Objects.equals(like.getUsers().getId(), user.getId()) && Objects.equals(like.getPost().getId(), post.getId())) {
                    postDto.setStatus(false);
                }
            }
            postDtos.add(postDto);
        }
        return postDtos;
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

    @PostMapping(value = "/{idUsers}/like")
    public ResponseEntity<?> likePost(@PathVariable Long idUsers, @RequestBody Post post) {
        List<Likes> likesList = likeService.findAll();
        for (Likes like : likesList) {
            if (Objects.equals(like.getUsers().getId(), idUsers) && Objects.equals(like.getPost().getId(), post.getId())) {
                likeService.deleteById(like.getId());
                return new ResponseEntity<>(new ResponseMessage("dislike"), HttpStatus.OK);
            }
        }
        Likes like = new Likes(userService.findById(idUsers).get(), post);
        likeService.save(like);
        return new ResponseEntity<>(new ResponseMessage("like"), HttpStatus.OK);
    }

    @GetMapping("/getLikeNumber")
    public ResponseEntity<List<Long>> likeNumber() {
        List<PostDto> postDtoList = findAll();
        List<Long> listLike = new ArrayList<>();
        for (PostDto postDto : postDtoList) {
            listLike.add(likeService.getLikeNumber(postDto.getId()));
        }
        return new ResponseEntity<>(listLike, HttpStatus.OK);
    }

    @GetMapping("/comments")
    public ResponseEntity<?> findAllComment() {
        List<PostDto> postList = findAll();
        List<List<Comment>> comments = new ArrayList<>();
        for (PostDto post: postList) {
            comments.add(commentService.getCommentByPostId(post.getId()));
        }

        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/{id}/createComment")
    public ResponseEntity<?> createComment(@RequestBody Comment comment, @PathVariable Long id) {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        comment.setTime(date);
        comment.setPost(postService.findById(id).get());
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.OK);
    }
}
