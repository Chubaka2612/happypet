package com.epam.sdet.happypet.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BreedResponseDto {

    private Long id;

    private String name;

    private Long typeId;

    private String type;

    public Long getId() {
        return id;
    }

    public BreedResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BreedResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public Long getTypeId() {
        return typeId;
    }

    public BreedResponseDto setTypeId(Long typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getType() {
        return type;
    }

    public BreedResponseDto setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreedResponseDto that = (BreedResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(typeId, that.typeId) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, typeId, type);
    }
}
