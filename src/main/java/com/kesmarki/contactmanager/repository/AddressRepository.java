package com.kesmarki.contactmanager.repository;

import com.kesmarki.contactmanager.entity.Address;
import com.kesmarki.contactmanager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
