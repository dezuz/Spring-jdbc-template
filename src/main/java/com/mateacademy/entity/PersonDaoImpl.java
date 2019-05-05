package com.mateacademy.entity;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/** This class marked with @Repository annotation,
 * It allows the component scanning to find and
 * configure the respected DAO.
 * @Autowired JdbcTemplate to access to a persistence resource.
 */
@Repository
@Qualifier("personDao")
public class PersonDaoImpl implements PersonDao{
    private final static Logger LOGGER = Logger.getLogger(PersonDaoImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final static String INSERT = "INSERT INTO persons (first_name, last_name, age) VALUES (?, ?, ?)";
    private final static String UPDATE = "UPDATE persons SET first_name = ? , last_name = ? , age = ? WHERE id = ?";
    private final static String DELETE = "DELETE from persons WHERE id = ?";
    private final static String SELECT = "SELECT * FROM persons where id = ?";
    private final static String SELECT_ALL = "SELECT * FROM persons";

    public void addPerson(Person person) {
        jdbcTemplate.update(INSERT, person.getFirstName(), person.getLastName(), person.getAge());
        LOGGER.info("Person Added!!");
    }

    public void editPerson(Person person, int personId) {
        jdbcTemplate.update(UPDATE, person.getFirstName(), person.getLastName(), person.getAge(), personId);
        LOGGER.info("Person Updated!!");
    }

    public void deletePerson(int personId) {
        jdbcTemplate.update(DELETE, personId);
        LOGGER.info("Person Deleted!!");
    }

    public Person find(int personId) {
        Person person = (Person) jdbcTemplate.queryForObject(SELECT,
                new Object[] { personId }, new BeanPropertyRowMapper(Person.class));

        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper(Person.class));
        return persons;
    }
}
