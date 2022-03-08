package com.codegym.socialbook_be.user_pack.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date time;
    private String image;
    @ManyToOne
    private Users users;

    @ManyToOne
    private Post post;
}
