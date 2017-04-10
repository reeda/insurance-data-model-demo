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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InsuranceProvider {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;

    private String billingCode;

}
