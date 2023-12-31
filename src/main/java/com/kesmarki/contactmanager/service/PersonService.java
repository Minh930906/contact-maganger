package com.kesmarki.contactmanager.service;

import com.kesmarki.contactmanager.dto.AddressDTO;
import com.kesmarki.contactmanager.dto.ContactDTO;
import com.kesmarki.contactmanager.dto.RequestPersonDto;
import com.kesmarki.contactmanager.dto.ResponsePersonDto;
import com.kesmarki.contactmanager.entity.Address;
import com.kesmarki.contactmanager.entity.Contact;
import com.kesmarki.contactmanager.entity.Person;
import com.kesmarki.contactmanager.exception.PersonNotFoundException;
import com.kesmarki.contactmanager.mapper.AddressMapper;
import com.kesmarki.contactmanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    public List<ResponsePersonDto> getAllPersons() {
        List<Person> personList = personRepository.findAll();
        List<ResponsePersonDto> responsePersonDtos = new ArrayList<>();
        for (Person person : personList){
            List<Address> addresses = addressService.getAddressesByPersonId(person.getId());
            List<AddressDTO> addressDTOList = AddressMapper.toDTOList(addresses);

            ResponsePersonDto responsePersonDto = new ResponsePersonDto();
            responsePersonDto.setId(person.getId());
            responsePersonDto.setName(person.getName());
            responsePersonDto.setAddresses(addressDTOList);
            responsePersonDtos.add(responsePersonDto);
        }
        return responsePersonDtos;
    }

    public ResponsePersonDto getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        List<Address> addresses = addressService.getAddressesByPersonId(id);
        List<AddressDTO> addressDTOList = AddressMapper.toDTOList(addresses);

        ResponsePersonDto responsePersonDto = new ResponsePersonDto();
        responsePersonDto.setId(person.getId());
        responsePersonDto.setName(person.getName());
        responsePersonDto.setAddresses(addressDTOList);


        return responsePersonDto;
    }

    public Person savePerson(RequestPersonDto requestPersonDto) {
        List<Address> addresses = new ArrayList<>();

        if (requestPersonDto.getAddresses() != null && !requestPersonDto.getAddresses().isEmpty()) {
            for (AddressDTO addressDTO : requestPersonDto.getAddresses()) {
                List<Contact> contacts = new ArrayList<>();
                if (addressDTO.getContacts() != null && !addressDTO.getContacts().isEmpty()) {

                    for (ContactDTO contactDTO : addressDTO.getContacts()) {
                        Contact contact = new Contact();
                        contact.setType(contactDTO.getType());
                        contact.setContactValue(contactDTO.getContactValue());
                        contacts.add(contact);
                    }
                }
                Address address = new Address();
                address.setType(addressDTO.getAddressType());
                address.setCity(addressDTO.getCity());
                address.setStreet(addressDTO.getStreet());
                address.setContacts(contacts);
                addresses.add(address);
            }
        }

        Person person = new Person();
        person.setName(requestPersonDto.getName());

        if (requestPersonDto.getAddresses() != null && !requestPersonDto.getAddresses().isEmpty()) {
            person.setAddresses(addresses);
        }

        person = personRepository.save(person);
        if (requestPersonDto.getAddresses() != null && !requestPersonDto.getAddresses().isEmpty()) {
            for (Address address : addresses) {
                address.setPerson(person);
                address = addressService.saveAddress(address);

                for (Contact contact : address.getContacts()) {
                    contact.setAddress(address);
                    contactService.saveContact(contact);
                }
            }
        }
        return person;
    }

    public Person savePerson(Long id, RequestPersonDto requestPersonDto) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        person.setName(requestPersonDto.getName());

        if (requestPersonDto.getAddresses() != null && !requestPersonDto.getAddresses().isEmpty()) {
            for (AddressDTO addressDTO : requestPersonDto.getAddresses()) {
                Address address = addressService.getAddressById(addressDTO.getId());
                address.setType(addressDTO.getAddressType());
                address.setCity(addressDTO.getCity());
                address.setStreet(addressDTO.getStreet());
                if (addressDTO.getContacts() != null && !addressDTO.getContacts().isEmpty()) {
                    for (ContactDTO contactDTO : addressDTO.getContacts()) {
                        Contact contact = contactService.getContactById(contactDTO.getId());
                        contact.setContactValue(contactDTO.getContactValue());
                        contact.setType(contactDTO.getType());
                    }
                }
                addressService.saveAddress(address);
            }
        }

        personRepository.save(person);
        return person;
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
        List<Address> addresses = addressService.getAddressesByPersonId(id);
        for (Address address : addresses) {
            addressService.deleteAddress(address.getId());
            for (Contact contact : address.getContacts()) {
                contactService.deleteContact(contact.getId());
            }
        }
    }
}