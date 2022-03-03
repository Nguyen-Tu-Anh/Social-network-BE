package com.codegym.socialbook_be.user_pack.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private Users users;

    @ManyToOne
    private Post post;
}
