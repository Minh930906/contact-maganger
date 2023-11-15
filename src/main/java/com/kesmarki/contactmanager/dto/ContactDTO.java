package com.kesmarki.contactmanager.dto;

public class ContactDTO {
    public ContactDTO() {
    }

    public ContactDTO(Long id, String type, String contactValue) {
        this.id = id;
        this.type = type;
        this.contactValue = contactValue;
    }

    private Long id;
    private String type;
    private String contactValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }
}
