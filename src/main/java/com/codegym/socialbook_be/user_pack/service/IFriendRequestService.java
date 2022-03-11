package com.codegym.socialbook_be.user_pack.service;

import com.codegym.socialbook_be.user_pack.model.FriendsRequest;
import com.codegym.socialbook_be.user_pack.model.Users;

import java.util.List;

public interface IFriendRequestService {
    List<FriendsRequest> findAll();

    FriendsRequest save(FriendsRequest friendsRequest);

    FriendsRequest findById(Long id);

    void deleteById(Long id);

    List<FriendsRequest> getFriendsRequestByIdReceiver(Long id);


    List<Long> getStranger(Long id);
}
