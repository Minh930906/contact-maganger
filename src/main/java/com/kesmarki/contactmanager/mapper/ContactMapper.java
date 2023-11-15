package com.kesmarki.contactmanager.mapper;

import com.kesmarki.contactmanager.dto.ContactDTO;
import com.kesmarki.contactmanager.entity.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class ContactMapper {
    public static ContactDTO toDTO(Contact entity) {
        ContactDTO dto = new ContactDTO();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setContactValue(entity.getContactValue());
        return dto;
    }

    public static Contact toEntity(ContactDTO dto) {
        Contact entity = new Contact();
        entity.setId(dto.getId());
        entity.setType(dto.getType());
        entity.setContactValue(dto.getContactValue());
        return entity;
    }
    public static List<ContactDTO> toDTOList(List<Contact> entityList) {
        return entityList.stream()
                .map(ContactMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Contact> toEntityList(List<ContactDTO> dtoList) {
        return dtoList.stream()
                .map(ContactMapper::toEntity)
                .collect(Collectors.toList());
    }
}
