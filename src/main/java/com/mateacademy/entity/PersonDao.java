package com.mateacademy.entity;

import java.util.List;
import java.util.Optional;

/** This interface contains methods which we have
 * to realize for CRUD operations.
 */

public interface PersonDao {

    void addPerson(Person person);

    void editPerson(Person person);

    int getId(Person person);

    void deletePerson(int personId);

    Optional<Person> find(int personId);

    List<Person> findAll();
}

