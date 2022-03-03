package com.codegym.socialbook_be.user_pack.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private boolean isPublic;
    private String image;
    private Date time;

    @ManyToOne
    private Users users;
}
