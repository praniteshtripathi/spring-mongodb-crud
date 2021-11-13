package com.example.demo.dao;

import com.example.demo.model.Employee;
import com.example.demo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    @Query(value="{'_id' : ?0}", delete = true)
    public void deleteByCustomParam(String id);

    @Query("{'fname' : ?0 , 'lname' : ?1,'age': { $gt: ?2 }}")
    public List<Person> findByFNameAndLastNameAndAge(String fname,String lname,int age);

   // @Query("{'fname' : ?0 ,$or:['age': { $gt: ?1 }] }")
    @Query("{'$or':[ {'lname':?1}, {'age':{ $gt: ?2 },'fname' : ?0  } ]}")
    public List<Person> findByFNameOrAgeGreaterThan(String fname,String lname,int age);
}
