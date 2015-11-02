package com.konceptsandcode.basicdatabinding;

public class StudentModel {
    private String firstName;
    private String lastName;
    private int grade;

    public StudentModel(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /*
        As the value of the grade would be set to the text view using setText,
         it should be converted to a String
     */
    public String getGrade() {
        return String.valueOf(grade);
    }
}
