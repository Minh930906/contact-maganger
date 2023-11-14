package com.kesmarki.contactmanager.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class Person {
    public Person() {
    }

    public Person(Long id, String name, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses;

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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}

