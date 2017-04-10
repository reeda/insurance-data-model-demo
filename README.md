# insurance-data-model-demo
Data Model Demo Program for Seattle U SEGR 5250
https://desolate-ridge-32865.herokuapp.com/

A demo application created for Seattle U SEGR 5250 - Data Modeling
Goal was to create a data model for an insurance claim. 
UI was not the main goal so there are many known issues.

Data are in tables:

### Patient
 + id
 + first name
 + middle initial
 + last name
 + phone
 + sex
 + marital status
 + primary doctor (Doctor.id)

### Doctor
 + id
 + first name
 + last name
 + phone number

### Insurance Claim
 + id
 + patient (Patient.id)
 + primaryInsurance (Insurance.id)
 + secondaryInsurance (Insurance.id)

### Insurance
 + id
 + patient (Patient.id)
 + insurance plan (Insurance Plan.id)
 + employer (Employer.id)

### Insurance Plan
 + id
 + name
 + type (PPO, EPO, etc.)
 + insurance provider (Insurance Provider.id)

### Insurance Provider
 + id
 + name
 + billing code

### Employer
 + id
 + name
