package com.codegym.socialbook_be.user_pack.service.impl;

import com.codegym.socialbook_be.security_pack.security.userpincal.UserDetailService;
import com.codegym.socialbook_be.user_pack.model.FriendsRequest;
import com.codegym.socialbook_be.user_pack.model.Users;
import com.codegym.socialbook_be.user_pack.repository.IFriendRequestRepo;
import com.codegym.socialbook_be.user_pack.service.IFriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRequestImpl implements IFriendRequestService {
    @Autowired
    IFriendRequestRepo friendRequestRepo;

    @Autowired
    UserDetailService userDetailService;
    @Override
    public List<FriendsRequest> findAll() {
        return friendRequestRepo.findAll();
    }

    @Override
    public FriendsRequest save(FriendsRequest friendsRequest) {
        return friendRequestRepo.save(friendsRequest);
    }

    @Override
    public FriendsRequest findById(Long id) {
        return friendRequestRepo.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        friendRequestRepo.deleteById(id);
    }

    @Override
    public List<FriendsRequest> getFriendsRequestByIdReceiver(Long id) {
        return friendRequestRepo.getFriendsRequestByIdReceiver(id);
    }

    @Override
    public List<Long> getStranger(Long id) {
        return friendRequestRepo.getStranger(id);
    }
}
