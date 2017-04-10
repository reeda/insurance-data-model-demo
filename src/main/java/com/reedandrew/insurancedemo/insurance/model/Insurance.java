package com.reedandrew.insurancedemo.insurance.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author reeda.
 */
@Data
@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private InsurancePlan insurancePlan;
    private Patient patient;
    private Employer employer;

}
