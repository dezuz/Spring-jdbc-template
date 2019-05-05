package com.mateacademy.entity;

import com.mateacademy.configuration.InjectRandomInt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


/** This class contains fields for mySQL table, also
 *  it contains getters, setters, constructors for
 *  mySQL table also it contains redefined toString method
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    @InjectRandomInt
    private Integer value;

    @Override
    public String toString() {
        return "Person Id:- " + getId() + " First Name:- " + getFirstName() + " Last Name:- " +
                getLastName() + " Age:- " + getAge() + " Value:- " + getValue();
    }
}

