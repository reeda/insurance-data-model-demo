package com.reedandrew.insurancedemo.insurance.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author reeda.
 */
@Data
@Entity
public class InsurancePlan {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private InsurancePlanType type;

    @ManyToOne
    private InsuranceProvider insuranceProvider;

}
