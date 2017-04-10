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
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"name", "insurance_provider"})})
public class InsurancePlan {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;
    private InsurancePlanType type;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "insurance_provider")
    private InsuranceProvider insuranceProvider;
}
