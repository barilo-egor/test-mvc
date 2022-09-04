package org.example.entities;

import org.example.enums.Mainland;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Location extends BasePersist{

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Mainland mainland;

    public Location() {
    }

    public Location(String name, Mainland mainland) {
        this.name = name;
        this.mainland = mainland;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && mainland == location.mainland;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, mainland);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", mainland=" + mainland +
                "} " + super.toString();
    }
}
