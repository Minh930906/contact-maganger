package com.kesmarki.contactmanager.dto;

import java.util.List;

public class ResponsePersonDto {
    public ResponsePersonDto() {
    }

    public ResponsePersonDto(Long id, String name, List<AddressDTO> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    Long id;
    private String name;
    private List<AddressDTO> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}
