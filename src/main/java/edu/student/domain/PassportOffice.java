package edu.student.domain;

import javax.persistence.*;

@Entity
@Table(name = "jc_passport_office")
public class PassportOffice {
    @Id
    @Column(name = "p_office_id")
    private Long passOfficeId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "p_office_area_id")
    private CountryArea countryArea;
    @Column(name = "p_office_name")
    private String passOfficeName;

    public Long getPassOfficeId() {
        return passOfficeId;
    }

    public void setPassOfficeId(Long passOfficeId) {
        this.passOfficeId = passOfficeId;
    }

    public CountryArea getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(CountryArea countryArea) {
        this.countryArea = countryArea;
    }

    public String getPassOfficeName() {
        return passOfficeName;
    }

    public void setPassOfficeName(String passOfficeName) {
        this.passOfficeName = passOfficeName;
    }
}
