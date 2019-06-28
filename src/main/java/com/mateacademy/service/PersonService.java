package com.mateacademy.service;

import com.mateacademy.entity.Person;

import java.util.List;

/** This interface contains methods which we have
 *  to realize for CRUD operations.
 */

public interface PersonService {

    void addPerson(Person person);

    void editPerson(Person person);

    int getId(Person person);

    void deletePerson(int personId);

    Person find(int personId) throws MyException;

    List<Person> findAll();
}

