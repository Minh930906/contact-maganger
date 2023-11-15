package com.kesmarki.contactmanager.service;

import com.kesmarki.contactmanager.entity.Contact;
import com.kesmarki.contactmanager.exception.ContactNotFoundException;
import com.kesmarki.contactmanager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
    }

    public List<Contact> getContactByAddressId(Long id) {
        return contactRepository.findAllByAddressId(id);
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}