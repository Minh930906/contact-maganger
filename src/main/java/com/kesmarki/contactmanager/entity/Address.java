package com.kesmarki.contactmanager.entity;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table
public class Address {

    public Address() {
    }

    public Address(Long id, AddressType type, String street, String city, Person person, List<Contact> contacts) {
        this.id = id;
        this.type = type;
        this.street = street;
        this.city = city;
        this.person = person;
        this.contacts = contacts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private AddressType type;
    private String street;
    private String city;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
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

    public List<Contact> getContact() {
        return contacts;
    }

    public void setContacts(List<Contact> contact) {
        this.contacts = contact;
    }
}

