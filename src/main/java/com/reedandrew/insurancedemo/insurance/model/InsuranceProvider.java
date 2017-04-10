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
public class InsuranceProvider {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private String address;
    private String billingCode;
}
