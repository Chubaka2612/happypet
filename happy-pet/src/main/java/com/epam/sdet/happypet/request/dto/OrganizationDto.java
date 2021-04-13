package com.epam.sdet.happypet.request.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationDto implements Serializable {

    private String name;

    private String address;

    private String phoneNumber;

    private Long cityId;

    public OrganizationDto () {}

    public OrganizationDto(String name, String address, String phoneNumber, Long cityId) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public OrganizationDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrganizationDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrganizationDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Long getCityId() {
        return cityId;
    }

    public OrganizationDto setCityId(Long cityId) {
        this.cityId = cityId;
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
        OrganizationDto that = (OrganizationDto) o;
        return name.equals(that.name)
                && address.equals(that.address)
                && phoneNumber.equals(that.phoneNumber)
                && cityId.equals(that.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber, cityId);
    }
}
