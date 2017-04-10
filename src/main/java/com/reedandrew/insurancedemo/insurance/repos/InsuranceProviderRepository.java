package com.reedandrew.insurancedemo.insurance.repos;

import com.reedandrew.insurancedemo.insurance.model.InsuranceProvider;
import org.springframework.data.repository.CrudRepository;

/**
 * @author reeda.
 */
public interface InsuranceProviderRepository extends CrudRepository<InsuranceProvider, Integer> {
}
