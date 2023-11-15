package com.kesmarki.contactmanager.dto;

import com.kesmarki.contactmanager.entity.AddressType;

import java.util.List;

public class AddressDTO {
    public AddressDTO() {
    }

    public AddressDTO(Long id,AddressType addressType, String street, String city, List<ContactDTO> contacts) {
        this.id = id;
        this.addressType = addressType;
        this.street = street;
        this.city = city;
        this.contacts = contacts;
    }

    private Long id;
    private AddressType addressType;
    private String street;
    private String city;

    private List<ContactDTO> contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }
}
