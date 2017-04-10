package com.reedandrew.insurancedemo.insurance.repos;

import com.reedandrew.insurancedemo.insurance.model.InsuranceClaim;
import org.springframework.data.repository.CrudRepository;

/**
 * @author reeda.
 */
public interface InsuranceClaimRepository extends CrudRepository<InsuranceClaim, Integer> {
}
