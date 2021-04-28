package com.epam.sdet.happypet.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "type")
public class Type extends Entity {

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
        Type type = (Type) o;
        return name.equals(type.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

}
