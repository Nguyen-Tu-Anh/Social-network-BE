package com.codegym.socialbook_be.user_pack.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class MessengerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String messenger;

    @ManyToOne
    private Users users;

    @ManyToOne
    private RoomChat roomChat;
}
