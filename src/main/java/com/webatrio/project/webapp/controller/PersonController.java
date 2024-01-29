package com.webatrio.project.webapp.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webatrio.project.webapp.dto.PersonDTO;
import com.webatrio.project.webapp.entity.Person;
import com.webatrio.project.webapp.service.PersonService;

@RestController 
@RequestMapping("/persons")
public class PersonController {
	
    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        try {
            Person nouvellePerson = personService.savePersonne(person);
            return ResponseEntity.ok(nouvellePerson);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/by-company/{companyName}", method = RequestMethod.GET)
    public List<Person> getPeopleByCompany(@PathVariable String companyName) {
        List<Person> people = personService.getPeopleByCompanyName(companyName);
        return people;
    }
    
    @GetMapping
    public List<Object> getAllPersonsDetails() {
        return personService.getAllPersonsDetails();
    }
}
