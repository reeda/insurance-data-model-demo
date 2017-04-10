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
public class InsuranceClaim {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Patient patient;

    private InsurancePlan primaryInsurance;
    private InsurancePlan secondaryInsurance;
}
