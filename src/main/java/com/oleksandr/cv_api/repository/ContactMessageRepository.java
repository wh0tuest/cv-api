package com.oleksandr.cv_api.repository;
import com.oleksandr.cv_api.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}
