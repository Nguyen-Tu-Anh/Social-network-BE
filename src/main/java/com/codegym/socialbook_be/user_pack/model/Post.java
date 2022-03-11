package com.codegym.socialbook_be.user_pack.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private boolean isPublic;
    private String image;
    private LocalDateTime time;
    @ManyToOne
    private Users users;
}
