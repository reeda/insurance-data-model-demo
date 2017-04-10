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
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"insurance_plan" , "patient", "employer"})})
public class Insurance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "insurance_plan")
    private InsurancePlan insurancePlan;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employer")
    private Employer employer;

}
