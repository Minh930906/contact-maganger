package com.kesmarki.contactmanager.repository;

import com.kesmarki.contactmanager.entity.Contact;
import com.kesmarki.contactmanager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
