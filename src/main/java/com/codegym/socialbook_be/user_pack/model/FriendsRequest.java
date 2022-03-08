package com.codegym.socialbook_be.user_pack.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FriendsRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String status;

    @ManyToOne
    private Users sender;

    @ManyToOne
    private Users receiver;
}
