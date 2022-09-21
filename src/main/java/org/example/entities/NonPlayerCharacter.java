package org.example.entities;

import org.example.enums.Fraction;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class NonPlayerCharacter extends BasePersist{

    @Column
    private String name;

    @Column
    private boolean eliteStatus;

    @Enumerated(EnumType.STRING)
    private Fraction fraction;

    @OneToOne
    private Location location;

    public NonPlayerCharacter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEliteStatus() {
        return eliteStatus;
    }

    public void setEliteStatus(boolean eliteStatus) {
        this.eliteStatus = eliteStatus;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NonPlayerCharacter that = (NonPlayerCharacter) o;
        return eliteStatus == that.eliteStatus && Objects.equals(name, that.name) && fraction == that.fraction && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, eliteStatus, fraction, location);
    }

    @Override
    public String toString() {
        return "NonPlayerCharacter{" +
                "name='" + name + '\'' +
                ", isItElite=" + eliteStatus +
                ", fraction=" + fraction +
                ", location=" + location +
                "} " + super.toString();
    }
}
