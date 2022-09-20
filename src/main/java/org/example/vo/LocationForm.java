package org.example.vo;

import org.example.enums.Mainland;

import java.util.Date;
import java.util.Objects;

public class LocationForm {

    private Integer id;

    private String name;

    private Mainland mainland;

    private String introductionDate;

    public LocationForm() {
    }

    public LocationForm(Integer id, String name, Mainland mainland, String introductionDate) {
        this.id = id;
        this.name = name;
        this.mainland = mainland;
        this.introductionDate = introductionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mainland getMainland() {
        return mainland;
    }

    public void setMainland(Mainland mainland) {
        this.mainland = mainland;
    }

    public String getIntroductionDate() {
        return introductionDate;
    }

    public void setIntroductionDate(String introductionDate) {
        this.introductionDate = introductionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationForm that = (LocationForm) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && mainland == that.mainland && Objects.equals(introductionDate, that.introductionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mainland, introductionDate);
    }

    @Override
    public String toString() {
        return "LocationForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mainland=" + mainland +
                ", introductionDate='" + introductionDate + '\'' +
                '}';
    }
}
