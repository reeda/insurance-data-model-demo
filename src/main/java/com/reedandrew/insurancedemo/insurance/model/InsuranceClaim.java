package com.reedandrew.insurancedemo.insurance.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author reeda.
 */
@Data
@Entity
public class InsuranceClaim {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private InsurancePlan primaryInsurance;

    @ManyToOne
    private InsurancePlan secondaryInsurance;
}
