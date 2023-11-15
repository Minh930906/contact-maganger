package com.kesmarki.contactmanager.mapper;

import com.kesmarki.contactmanager.dto.AddressDTO;
import com.kesmarki.contactmanager.entity.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper {

    public static AddressDTO toDTO(Address entity) {
        AddressDTO dto = new AddressDTO();
        dto.setId(entity.getId());
        dto.setAddressType(entity.getType());
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setContacts(ContactMapper.toDTOList(entity.getContacts()));
        return dto;
    }

    public static Address toEntity(AddressDTO dto) {
        Address entity = new Address();
        entity.setId(dto.getId());
        entity.setType(dto.getAddressType());
        entity.setStreet(dto.getStreet());
        entity.setCity(dto.getCity());
        entity.setContacts(ContactMapper.toEntityList(dto.getContacts()));
        return entity;
    }

    public static List<AddressDTO> toDTOList(List<Address> entityList) {
        return entityList.stream()
                .map(AddressMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Address> toEntityList(List<AddressDTO> dtoList) {
        return dtoList.stream()
                .map(AddressMapper::toEntity)
                .collect(Collectors.toList());
    }
}

