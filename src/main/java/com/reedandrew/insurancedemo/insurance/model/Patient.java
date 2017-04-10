package com.reedandrew.insurancedemo.insurance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *
 * @author reeda.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String middleInitial;
    private String lastName;
    private String phoneNumber;
    private Sex sex;
    private MaritalStatus maritalStatus;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Doctor primaryDoctor;


}
