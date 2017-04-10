package com.reedandrew.insurancedemo.insurance.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author reeda.
 */
@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String middleInitial;
    private String lastName;
    private String phoneNumber;
    private Sex sex;
    private MaritalStatus maritalStatus;

    private Doctor primaryDoctor;


}
