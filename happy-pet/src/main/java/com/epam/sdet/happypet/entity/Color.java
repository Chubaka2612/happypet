package com.epam.sdet.happypet.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "color")
public class Color extends Entity {

    @Column(name = "description", nullable = false)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Color color = (Color) o;
        return Objects.equals(description, color.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description);
    }
}
