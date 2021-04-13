package com.epam.sdet.happypet.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationResponseDto {

    private String name;

    private String address;

    private String phoneNumber;

    private String city;

    public String getName() {
        return name;
    }

    public OrganizationResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrganizationResponseDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrganizationResponseDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OrganizationResponseDto setCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrganizationResponseDto that = (OrganizationResponseDto) o;
        return Objects.equals(name, that.name)
                && Objects.equals(address, that.address)
                && Objects.equals(phoneNumber, that.phoneNumber)
                && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber, city);
    }
}
