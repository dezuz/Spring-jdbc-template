package com.mateacademy.service;

import com.mateacademy.entity.Person;

import java.util.List;
import java.util.Optional;

/** This interface contains methods which we have
 *  to realize for CRUD operations.
 */

public interface PersonService {

    void addPerson(Person person);

    void editPerson(Person person, int personId);

    void deletePerson(int personId);

    Person find(int personId);

    List<Person> findAll();
}

