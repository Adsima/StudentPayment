package edu.student.domain;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class Person {
    private String surName;
    private String givename;
    private String patronymic;
    private LocalDate dateOfBirth;

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivename() {
        return givename;
    }

    public void setGivename(String givename) {
        this.givename = givename;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
