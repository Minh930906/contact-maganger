package com.kesmarki.contactmanager.repository;

import com.kesmarki.contactmanager.entity.Address;
import com.kesmarki.contactmanager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByPersonId(Long personId);
}
