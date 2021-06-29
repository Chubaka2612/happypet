package com.epam.sdet.happypet.entity;

import javax.persistence.*;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "breed")
public class Breed extends Entity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Breed breed = (Breed) o;
        return Objects.equals(super.getId(), breed.getId());
    }
}
