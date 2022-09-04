package org.example.vo;

import org.example.enums.Fraction;
import java.util.Objects;

public class NpcForm {

    private Integer id;

    private String name;

    private boolean eliteStatus;

    private Fraction fraction;

    private Integer locationId;

    public NpcForm() {
    }

    public NpcForm(Integer id, String name, boolean eliteStatus, Fraction fraction, Integer locationId) {
        this.id = id;
        this.name = name;
        this.eliteStatus = eliteStatus;
        this.fraction = fraction;
        this.locationId = locationId;
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

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NpcForm that = (NpcForm) o;
        return eliteStatus == that.eliteStatus && Objects.equals(id, that.id) && Objects.equals(name, that.name) &&
                fraction == that.fraction && Objects.equals(locationId, that.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, eliteStatus, fraction, locationId);
    }

    @Override
    public String toString() {
        return "NpcForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eliteStatus=" + eliteStatus +
                ", fraction=" + fraction +
                ", locationId=" + locationId +
                '}';
    }
}
