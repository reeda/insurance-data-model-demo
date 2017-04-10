package com.reedandrew.insurancedemo.insurance.model;

/**
 * @author reeda.
 */
public enum MaritalStatus {

    MARRIED("Married"), SINGLE("Single"), WIDOWED("Widowed");

    private String presentationString;

    MaritalStatus(String presentationString) {
        this.presentationString = presentationString;
    }

    public String getPresentationString() {
        return presentationString;
    }

    public static MaritalStatus fromPresentatinoString(String s) {
        for (MaritalStatus maritalStatus : MaritalStatus.values()) {
            if (maritalStatus.getPresentationString().equalsIgnoreCase(s)) {
                return maritalStatus;
            }
        }
        return SINGLE;
    }
}
