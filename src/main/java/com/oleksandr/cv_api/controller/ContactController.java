package com.oleksandr.cv_api.controller;

import com.oleksandr.cv_api.dto.ContactRequest;
import com.oleksandr.cv_api.dto.ContactResponse;
import com.oleksandr.cv_api.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/api/contact")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactResponse sendMessage(@Valid @RequestBody ContactRequest request) {
        return contactService.saveContactMessage(request);
    }
}