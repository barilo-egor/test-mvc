package org.example.entities;

import org.example.enums.Mainland;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.Objects;

@Entity
public class Location extends BasePersist {

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Mainland mainland;

    @Column
    private Date introductionDate;

    public Location() {
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

    public Date getIntroductionDate() {
        return introductionDate;
    }

    public void setIntroductionDate(Date introductionDate) {
        this.introductionDate = introductionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && mainland == location.mainland && Objects.equals(introductionDate, location.introductionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, mainland, introductionDate);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", mainland=" + mainland +
                ", introductionDate=" + introductionDate +
                "} " + super.toString();
    }
}
