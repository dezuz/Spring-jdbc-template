package com.mateacademy.entity;

import com.mateacademy.configuration.AppConfiguration;
import com.mateacademy.service.PersonService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

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

        Assert.assertNotNull(personService.find(49));
    }

    @Test
    public void editPersonTest() {
        Serhij.setFirstName("Serhij - Updated").setLastName("Hurko - Updated").setAge(20);

        personService.editPerson(Serhij, 50);

        Assert.assertEquals(personService.find(50).getFirstName(),"Serhij - Updated");
    }

    @Test
    public void deletePersonTest() {
        personService.deletePerson(49);
    }

    @Test
    public void findPersonTest() {
        Person testPerson = personService.find(50);

        Assert.assertEquals(testPerson.getFirstName(), "Vasilios");
    }

    @Test
    public void findAllPersonTest() {
        List<Person> personList = personService.findAll();

        Assert.assertEquals(personList.get(0).getLastName(), "Lyahovsky");
        Assert.assertEquals(personList.get(1).getLastName(), "Hurko");
        Assert.assertEquals(personList.get(2).getLastName(), "Zhovtani");
    }

    @After
    public void closeContext() {
        context.close();
    }
}
