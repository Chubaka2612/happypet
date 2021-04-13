package com.epam.sdet.happypet.model;

import javax.persistence.*;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "city")
public class City extends Entity {

    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        City city = (City) o;
        return name.equals(city.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}