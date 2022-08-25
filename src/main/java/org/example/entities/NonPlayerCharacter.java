package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.example.enums.Fraction;

import java.util.Objects;

public class NonPlayerCharacter extends BasePersist{

    @Column
    private String name;

    @Column
    private boolean isItElite;

    @Column
    private Fraction fraction;

    @ManyToOne
    private Location location;

    public NonPlayerCharacter() {
    }

    public NonPlayerCharacter(String name, boolean isItElite, Fraction fraction) {
        this.name = name;
        this.isItElite = isItElite;
        this.fraction = fraction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isItElite() {
        return isItElite;
    }

    public void setItElite(boolean itElite) {
        isItElite = itElite;
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
        return isItElite == that.isItElite && Objects.equals(name, that.name) && fraction == that.fraction && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, isItElite, fraction, location);
    }

    @Override
    public String toString() {
        return "NonPlayerCharacter{" +
                "name='" + name + '\'' +
                ", isItElite=" + isItElite +
                ", fraction=" + fraction +
                ", location=" + location +
                "} " + super.toString();
    }
}
