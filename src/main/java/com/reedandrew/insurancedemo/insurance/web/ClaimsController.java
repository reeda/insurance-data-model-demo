package com.reedandrew.insurancedemo.insurance.web;

import com.google.common.collect.Lists;
import com.reedandrew.insurancedemo.insurance.model.*;
import com.reedandrew.insurancedemo.insurance.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Map;
import java.util.Optional;

/**
 * @author reeda.
 */
@Controller
public class ClaimsController {

    private PatientRepository patientRepository;
    private InsuranceRepository insuranceRepository;
    private InsuranceClaimRepository insuranceClaimRepository;
    private DoctorRepository doctorRepository;
    private InsuranceProviderRepository insuranceProviderRepository;
    private InsurancePlanRepository insurancePlanRepository;
    private EmployerRepository employerRepository;

    @RequestMapping(path = "/claims", method = RequestMethod.POST)
    public String addClaim(@RequestParam Map<String,String> allRequestParams) {

        Doctor primaryDoctor = getOrCreateDoctor(allRequestParams);

        Patient patient = getOrCreatePatient(allRequestParams, primaryDoctor);

        patientRepository.save(patient);

        Optional<Insurance> primaryInsurance = buildInsurance("prim", allRequestParams, patient);
        primaryInsurance.ifPresent(insurance -> insuranceRepository.save(insurance));

        Optional<Insurance> secondaryInsurance = buildInsurance("sec", allRequestParams, patient);
        secondaryInsurance.ifPresent(insurance -> insuranceRepository.save(insurance));

        InsuranceClaim insuranceClaim = InsuranceClaim.builder()
                .primaryInsurance(primaryInsurance.orElse(null))
                .secondaryInsurance(secondaryInsurance.orElse(null))
                .patient(patient)
                .build();

        insuranceClaimRepository.save(insuranceClaim);

        return "redirect:claims";
    }

    private Patient getOrCreatePatient(Map<String, String> allRequestParams, Doctor primaryDoctor) {

        String firstName = allRequestParams.get("first_name");
        String middleInitial = allRequestParams.get("middle_initial");
        String lastName = allRequestParams.get("last_name");

        Patient patient = patientRepository.findByFirstNameAndMiddleInitialAndLastName(firstName, middleInitial, lastName);

        if (patient == null) {
            patient = Patient.builder()
                    .firstName(allRequestParams.get("first_name"))
                    .middleInitial(allRequestParams.get("middle_initial"))
                    .lastName(allRequestParams.get("last_name"))
                    .sex(Sex.fromPresentatinoString(allRequestParams.get("sex")))
                    .maritalStatus(MaritalStatus.fromPresentatinoString(allRequestParams.get("marital_status")))
                    .primaryDoctor(primaryDoctor)
                    .build();
        }

        return patient;
    }

    private Doctor getOrCreateDoctor(Map<String, String> allRequestParams) {

        String firstName = allRequestParams.get("doc_first_name");
        String lastName = allRequestParams.get("doc_last_name");

        Doctor primaryDoctor = doctorRepository.findByFirstNameAndLastName(firstName, lastName);

        if (primaryDoctor == null) {
            primaryDoctor = Doctor.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .phoneNumber(allRequestParams.get("doc_phone_number"))
                    .build();
        }

        doctorRepository.save(primaryDoctor);

        return primaryDoctor;
    }

    private Optional<Insurance> buildInsurance(String prefix, Map<String,String> allRequestParams, Patient patient) {

        if (StringUtils.isEmpty(allRequestParams.get(prefix + "_company"))) {
            return Optional.empty();
        }

        InsuranceProvider provider = getOrCreateInsuranceProvider(allRequestParams, prefix);

        InsurancePlan plan = getOrCreateInsurancePlan(allRequestParams, prefix, provider);

        Employer employer = getOrCreateEmployer(allRequestParams, prefix);

        Insurance insurance = insuranceRepository.findByPatientAndEmployerAndInsurancePlan(patient, employer, plan);

        if (insurance == null) {
            insurance = Insurance.builder()
                    .insurancePlan(plan)
                    .patient(patient)
                    .employer(employer)
                    .build();
        }

        return Optional.of(insurance);
    }

    private Employer getOrCreateEmployer(Map<String, String> allRequestParams, String prefix) {

        String name = allRequestParams.get(prefix + "_employer");

        Employer employer = employerRepository.findByName(name);

        if (employer == null) {
            employer = Employer.builder()
                    .name(name)
                    .build();
        }

        employerRepository.save(employer);

        return employer;
    }

    private InsurancePlan getOrCreateInsurancePlan(Map<String, String> allRequestParams, String prefix, InsuranceProvider provider) {

        String planName = allRequestParams.get(prefix + "_plan_name");

        InsurancePlan plan = insurancePlanRepository.findByNameAndInsuranceProvider(planName, provider);

        if (plan == null) {
            plan = InsurancePlan.builder()
                    .name(planName)
                    .insuranceProvider(provider)
                    .type(InsurancePlanType.valueOf(allRequestParams.get(prefix + "_plan_type")))
                    .build();
        }

        insurancePlanRepository.save(plan);

        return plan;

    }

    private InsuranceProvider getOrCreateInsuranceProvider(Map<String, String> allRequestParams, String prefix) {

        String companyName = allRequestParams.get(prefix + "_company");

        InsuranceProvider provider = insuranceProviderRepository.findByName(companyName);

        if (provider == null) {
            provider = InsuranceProvider.builder()
                    .name(companyName)
                    .billingCode(allRequestParams.get(prefix + "billing_code"))
                    .build();
        }

        insuranceProviderRepository.save(provider);

        return provider;
    }

    @RequestMapping(path = "/claims", method = RequestMethod.GET)
    public String getClaims(Model model) {

        model.addAttribute("claims", Lists.newArrayList(insuranceClaimRepository.findAll()));
        return "claims";
    }

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    public void setInsuranceRepository(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Autowired
    public void setInsuranceClaimRepository(InsuranceClaimRepository insuranceClaimRepository) {
        this.insuranceClaimRepository = insuranceClaimRepository;
    }

    @Autowired
    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Autowired
    public void setInsuranceProviderRepository(InsuranceProviderRepository insuranceProviderRepository) {
        this.insuranceProviderRepository = insuranceProviderRepository;
    }

    @Autowired
    public void setInsurancePlanRepository(InsurancePlanRepository insurancePlanRepository) {
        this.insurancePlanRepository = insurancePlanRepository;
    }

    @Autowired
    public void setEmployerRepository(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }
}
