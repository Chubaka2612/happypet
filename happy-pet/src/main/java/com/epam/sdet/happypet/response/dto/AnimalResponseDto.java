package com.epam.sdet.happypet.response.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimalResponseDto {

    private Long id;

    private String avatarUrl;

    private String name;

    private String behavior;

    private boolean isBooked;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private Long breedId;

    private String breed;

    private Long cityId;

    private String city;

    private Long colorId;

    private String color;

    private Long healthId;

    private String health;

    private String history;

    private Long ownerId;

    private Long curatorId;

    private String curatorFirstName;

    private String curatorPhoneNumber;

    private boolean hasPassport;

    private boolean isVaccinated;

    private boolean isSterilized;

    private Long typeId;

    private String type;

    private Long genderId;

    private String gender;

    private Long organizationId;

    private String organizationName;

    private String age;

    public AnimalResponseDto() {
    }

    public boolean isBooked() {
        return isBooked;
    }

    public AnimalResponseDto setBooked(boolean booked) {
        isBooked = booked;
        return this;
    }

    public AnimalResponseDto setAge(Date birthday) {
        Period period = Period.between(birthday.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), LocalDate.now());
        age =  period.getYears() + " years " +  period.getMonths() + " months" ;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public AnimalResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getBehavior() {
        return behavior;
    }

    public AnimalResponseDto setBehavior(String behavior) {
        this.behavior = behavior;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public AnimalResponseDto setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Long getBreedId() {
        return breedId;
    }

    public AnimalResponseDto setBreedId(Long breedId) {
        this.breedId = breedId;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public AnimalResponseDto setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public Long getCityId() {
        return cityId;
    }

    public AnimalResponseDto setCityId(Long cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AnimalResponseDto setCity(String city) {
        this.city = city;
        return this;
    }

    public Long getColorId() {
        return colorId;
    }

    public AnimalResponseDto setColorId(Long colorId) {
        this.colorId = colorId;
        return this;
    }

    public String getColor() {
        return color;
    }

    public AnimalResponseDto setColor(String color) {
        this.color = color;
        return this;
    }

    public Long getHealthId() {
        return healthId;
    }

    public AnimalResponseDto setHealthId(Long healthId) {
        this.healthId = healthId;
        return this;
    }

    public String getHealth() {
        return health;
    }

    public AnimalResponseDto setHealth(String health) {
        this.health = health;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public AnimalResponseDto setHistory(String history) {
        this.history = history;
        return this;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public AnimalResponseDto setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Long getCuratorId() {
        return curatorId;
    }

    public AnimalResponseDto setCuratorId(Long curatorId) {
        this.curatorId = curatorId;
        return this;
    }

    public String getCuratorFirstName() {
        return curatorFirstName;
    }

    public AnimalResponseDto setCuratorFirstName(String curatorFirstName) {
        this.curatorFirstName = curatorFirstName;
        return this;
    }

    public String getCuratorPhoneNumber() {
        return curatorPhoneNumber;
    }

    public AnimalResponseDto setCuratorPhoneNumber(String curatorPhoneNumber) {
        this.curatorPhoneNumber = curatorPhoneNumber;
        return this;
    }

    public boolean isHasPassport() {
        return hasPassport;
    }

    public AnimalResponseDto setHasPassport(boolean hasPassport) {
        this.hasPassport = hasPassport;
        return this;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public AnimalResponseDto setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
        return this;
    }

    public boolean isSterilized() {
        return isSterilized;
    }

    public AnimalResponseDto setSterilized(boolean sterilized) {
        isSterilized = sterilized;
        return this;
    }

    public Long getTypeId() {
        return typeId;
    }

    public AnimalResponseDto setTypeId(Long typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getType() {
        return type;
    }

    public AnimalResponseDto setType(String type) {
        this.type = type;
        return this;
    }

    public Long getGenderId() {
        return genderId;
    }

    public AnimalResponseDto setGenderId(Long genderId) {
        this.genderId = genderId;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public AnimalResponseDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public AnimalResponseDto setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public AnimalResponseDto setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public AnimalResponseDto setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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
        AnimalResponseDto that = (AnimalResponseDto) o;
        return breedId == that.breedId
                && cityId == that.cityId
                && colorId == that.colorId
                && healthId == that.healthId
                && typeId == that.typeId
                && genderId == that.genderId
                && name.equals(that.name)
                && birthday.equals(that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, breedId, cityId, colorId, healthId, typeId, genderId);
    }
}
