package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "emp")
public class Employee {
    @Id
    private String empId;
    @Field(name = "name")
    private String name;
    @Field(name="age")
    private int age;
    @Field(name = "emp_salary")
    private double salary;

}
