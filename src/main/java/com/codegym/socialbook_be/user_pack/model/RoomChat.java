package com.codegym.socialbook_be.user_pack.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roomchat")
@Data
public class RoomChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userFriend;
}
