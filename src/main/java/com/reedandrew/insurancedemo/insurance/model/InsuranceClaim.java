package com.reedandrew.insurancedemo.insurance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author reeda.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class InsuranceClaim {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Insurance primaryInsurance;
    
    @ManyToOne
    private Insurance secondaryInsurance;
}
