package com.mateacademy.entity;

import com.mateacademy.configuration.AppConfiguration;
import com.mateacademy.service.PersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonDaoImplTest {
    private AbstractApplicationContext context;
    private PersonService personService;
    private Person Serhij;
    private Person Vasilios;
    private Person Lesya;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        personService = (PersonService) context.getBean("personService");

        Serhij = new Person();
        Vasilios = new Person();
        Lesya = new Person();

        Serhij.setAge(18).setFirstName("Serhij").setLastName("Hurko");
        Vasilios.setAge(19).setFirstName("Vasilios").setLastName("Lyahovsky");
        Lesya.setAge(19).setFirstName("Lesya").setLastName("Zhovtani");
    }

    @Test
    public void addPersonTest() {
        personService.addPerson(Serhij);
        personService.addPerson(Vasilios);
        personService.addPerson(Lesya);

        assertNotNull(personService.find(73));
    }

    @Test
    public void editPersonTest() {
        Serhij.setFirstName("Serhij - Updated").setLastName("Hurko - Updated").setAge(20);

        personService.editPerson(Serhij, 50);

        assertEquals(personService.find(50).getFirstName(),"Serhij - Updated");
    }

    @Test
    public void getIdTest() {
        int id = personService.getId(Serhij);

        assertEquals( personService.find(id).getFirstName(), "Serhij");
    }

    @Test
    public void deletePersonTest() {
        personService.deletePerson(49);

        assertNotNull(personService.find(49));
    }

    @Test
    public void findPersonTest() {
        Person testPerson = personService.find(50);

        assertEquals(testPerson.getFirstName(), "Serhij - Updated");
    }

    @Test
    public void findAllPersonTest() {
        List<Person> personList = personService.findAll();

        assertEquals(personList.get(0).getLastName(), "Lyahovsky");
        assertEquals(personList.get(1).getLastName(), "Hurko");
        assertEquals(personList.get(2).getLastName(), "Zhovtani");
    }

    @After
    public void closeContext() {
        context.close();
    }
}
