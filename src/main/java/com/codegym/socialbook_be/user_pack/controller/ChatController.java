//package com.codegym.socialbook_be.user_pack.controller;
//
//import com.codegym.socialbook_be.security_pack.service.IUserService;
//import com.codegym.socialbook_be.user_pack.model.*;
//import com.codegym.socialbook_be.user_pack.service.IRoomChatService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class ChatController<IMessengerService> {
//    private String userNameFriend;
//    private Long idRomChat;
//    RoomChat roomChat;
//    @Autowired
//     SimpMessagingTemplate simpMessagingTemplate;
//
//    @Autowired
//    com.codegym.socialbook_be.user_pack.service.IMessengerService messengerService;
//
//    @Autowired
//    IRoomChatService roomChatService;
//
//    @Autowired
//    private IUserService userService;
//
//    @MessageMapping("/chat.newUser")
//    public void greeting(@Payload Messenger messenger) {
//        Users user = userService.findByUsername(messenger.getName()).get();
//        MessengerEntity messengerEntity = new MessengerEntity();
//        messengerEntity.setUsers(user);
//        messengerEntity.setRoomChat(roomChat);
//        messengerEntity.setMessenger(messenger.getMessage());
//
//        messengerService.save(messengerEntity);
//        simpMessagingTemplate.convertAndSend("/topic/public/" + this.idRomChat, messenger.getName() + " : " + messenger.getMessage());
//    }
//
//    @MessageMapping("/chatVsUser")
//    public UserSocket chatVsUser(@Payload UserSocket user) {
//        this.userNameFriend = user.getUserNameFriend();
//        roomChat = roomChatService.findRoomChat(user.getName(), user.getUserNameFriend());
//        this.idRomChat = roomChat.getId();
//        System.out.println("------------------------------");
//        System.out.println(user);
//        System.out.println("------------------------------");
//        return user;
//    }
//
//
//
//}
