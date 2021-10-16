package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class PersonDao {

    private final PersonRepository personRepository;

    public PersonDao(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person insertPersonData(Person person) {
        return personRepository.insert(person);
    }

    public Collection<Person> getAllPersonInformation() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonInformationById(String id) {
        return personRepository.findById(id);
    }

    public void delete(Person person ){
        personRepository.deleteByCustomParam(person.getId());
    }

    public Person updatePersonUsingId(String id, Person person) {
        Optional<Person> findPersonQuery = personRepository.findById(id);
        Person personValues = findPersonQuery.get();
        personValues.setId(person.getId());
        personValues.setFname(person.getFname());
        personValues.setLname(person.getLname());
        personValues.setAge(person.getAge());
        personValues.setSalary(person.getSalary());
        return personRepository.save(personValues);
    }

    public void deletePersonUsingId(String id) {
        try {
            personRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    public List<Person> findByFNameAndLastNameAndAge(Person person){
        return personRepository.findByFNameAndLastNameAndAge(person.getFname(),person.getLname(),person.getAge());
    }
    public List<Person> findByFNameOrAgeGreaterThan(Person person){
        return personRepository.findByFNameOrAgeGreaterThan(person.getFname(),person.getLname(),person.getAge());
    }

}
