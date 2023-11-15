package com.kesmarki.contactmanager.controller;

import com.kesmarki.contactmanager.dto.RequestPersonDto;
import com.kesmarki.contactmanager.dto.ResponsePersonDto;
import com.kesmarki.contactmanager.entity.Person;
import com.kesmarki.contactmanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePersonDto> getPersonById(@PathVariable Long id) {
        ResponsePersonDto personById = personService.getPersonById(id);
        return ResponseEntity.ok().body(personById);
    }

    @PostMapping
    public ResponseEntity<Void> savePerson(@RequestBody RequestPersonDto person) {
        personService.savePerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody RequestPersonDto person) {
        personService.savePerson(id,person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
