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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;
}
