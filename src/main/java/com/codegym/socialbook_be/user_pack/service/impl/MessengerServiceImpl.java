package com.codegym.socialbook_be.user_pack.service.impl;



import com.codegym.socialbook_be.user_pack.model.MessengerEntity;
import com.codegym.socialbook_be.user_pack.repository.IMessengerRepo;
import com.codegym.socialbook_be.user_pack.service.IMessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessengerServiceImpl implements IMessengerService {
    @Autowired
    IMessengerRepo iMessengerRepo;

    @Override
    public void save(MessengerEntity messengerEntity) {
        iMessengerRepo.save(messengerEntity);
    }

    @Override
    public Iterable<MessengerEntity> findAllByRoomChatId(Long id) {
        return iMessengerRepo.findAllByRoomChatId(id);
    }
}
