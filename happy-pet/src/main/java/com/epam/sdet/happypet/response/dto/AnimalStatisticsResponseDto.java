package com.epam.sdet.happypet.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimalStatisticsResponseDto {

    private int total;

    private int inHomeBooked;

    private int inShelters;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getInHomeBooked() {
        return inHomeBooked;
    }

    public AnimalStatisticsResponseDto setInHomeBooked(int inHomeBooked) {
        this.inHomeBooked = inHomeBooked;
        return this;
    }

    public int getInShelters() {
        return inShelters;
    }

    public AnimalStatisticsResponseDto setInShelters(int inShelters) {
        this.inShelters = inShelters;
        return this;
    }

    public AnimalStatisticsResponseDto() {
    }
}
