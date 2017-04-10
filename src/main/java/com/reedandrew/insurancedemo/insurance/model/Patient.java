package com.reedandrew.insurancedemo.insurance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *
 * @author reeda.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"first_name" , "middle_initial", "last_name"})})
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_initial")
    private String middleInitial;
    @Column(name = "last_name")
    private String lastName;

    private String phoneNumber;
    private Sex sex;
    private MaritalStatus maritalStatus;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Doctor primaryDoctor;


}
