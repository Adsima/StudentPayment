package edu.student.domain;

import javax.persistence.*;

@Entity
@Table(name = "jc_register_office")
public class RegisterOffice {
    @Id
    @Column(name = "r_office_id")
    private Long regOfficeId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "r_office_area_id")
    private CountryArea countryArea;
    @Column(name = "r_office_name")
    private String regOfficeName;

    public Long getRegOfficeId() {
        return regOfficeId;
    }

    public void setRegOfficeId(Long regOfficeId) {
        this.regOfficeId = regOfficeId;
    }

    public CountryArea getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(CountryArea countryArea) {
        this.countryArea = countryArea;
    }

    public String getRegOfficeName() {
        return regOfficeName;
    }

    public void setRegOfficeName(String regOfficeName) {
        this.regOfficeName = regOfficeName;
    }
}
