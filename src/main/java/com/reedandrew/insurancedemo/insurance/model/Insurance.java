package com.reedandrew.insurancedemo.insurance.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author reeda.
 */
@Data
@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private InsurancePlan insurancePlan;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Employer employer;

}
