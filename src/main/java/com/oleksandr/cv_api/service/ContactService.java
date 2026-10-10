package com.oleksandr.cv_api.service;

import com.oleksandr.cv_api.dto.ContactRequest;
import com.oleksandr.cv_api.dto.ContactResponse;
import com.oleksandr.cv_api.model.ContactMessage;
import com.oleksandr.cv_api.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service 
public class ContactService {
    
    private final ContactMessageRepository contactMessageRepository;

    public ContactService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    @Transactional
    public ContactResponse saveContactMessage(ContactRequest contactRequest) {
        ContactMessage contactMessage = new ContactMessage(
        contactRequest.name().trim(),
        contactRequest.email().trim(),
        contactRequest.message().trim());

        ContactMessage savedContactMessage = contactMessageRepository.save(contactMessage);
        return new ContactResponse(savedContactMessage.getId(), "received");
    }
}
