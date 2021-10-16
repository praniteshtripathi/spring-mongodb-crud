package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
@Slf4j
public class PersonController {

    private final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.insertPersonData(person);
    }

    @GetMapping
    public Collection<Person> read() {
        return personService.getAllPersonInformation();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> readQueryUsingId(@PathVariable("id") String id) {
        return personService.getPersonInformationUsingId(id);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable String id, @RequestBody Person person ) {
        personService.updatePersonUsingId(id, person);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable("id") String id){
        personService.deletePersonUsingId(id);
    }
    @DeleteMapping
    public void delete(@RequestBody Person person){
        personService.delete(person);
        log.info("item deleted successfully");
    }

    @PostMapping(path = "/findByFNameAndLastNameAndAge")
    List<Person> findByFNameAndLastNameAndAge( @RequestBody Person person){
        return personService.findByFNameAndLastNameAndAge(person);
    }
    @PostMapping(path = "/findByFNameOrAgeGreaterThan")
    List<Person> findByFNameOrAgeGreaterThan( @RequestBody Person person){
        return personService.findByFNameOrAgeGreaterThan(person);
    }

}
