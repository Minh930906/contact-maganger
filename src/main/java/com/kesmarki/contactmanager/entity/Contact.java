package com.kesmarki.contactmanager.entity;


import jakarta.persistence.*;

@Entity
@Table
public class Contact {
    public Contact() {
    }

    public Contact(Long id, String type, String contactValue) {
        this.id = id;
        this.type = type;
        this.contactValue = contactValue;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String type;
    private String contactValue;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

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
