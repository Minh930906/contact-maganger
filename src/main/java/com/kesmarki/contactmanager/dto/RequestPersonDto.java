package com.kesmarki.contactmanager.dto;

import java.util.List;

public class RequestPersonDto {
    public RequestPersonDto() {
    }

    public RequestPersonDto(String name, List<AddressDTO> addresses) {
        this.name = name;
        this.addresses = addresses;
    }

    private String name;
    private List<AddressDTO> addresses;

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
        if (addresses.size() <= 2) {
            this.addresses=addresses;
        } else {
            throw new IllegalStateException("A person can have at most two addresses.");
        }
    }
}
