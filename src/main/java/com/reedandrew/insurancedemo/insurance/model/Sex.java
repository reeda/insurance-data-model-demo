package com.reedandrew.insurancedemo.insurance.model;

/**
 * @author reeda.
 */
public enum Sex {

    MALE("Male"), FEMALE("Female"), OTHER("Other"), WONT_DISCLOSE("I'd rather not say");

    private String presentationString;

    Sex(String presentationString) {
        this.presentationString = presentationString;
    }

    public String getPresentationString() {
        return presentationString;
    }

    public static Sex fromPresentatinoString(String s) {
        for (Sex sex : Sex.values()) {
            if (sex.getPresentationString().equalsIgnoreCase(s)) {
                return sex;
            }
        }
        return OTHER;
    }
}
