package com.epam.sdet.happypet.api.data.models.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimalResponse {

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

    public AnimalResponse() {
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBehavior() {
        return behavior;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Long getBreedId() {
        return breedId;
    }

    public String getBreed() {
        return breed;
    }

    public Long getCityId() {
        return cityId;
    }

    public String getCity() {
        return city;
    }

    public Long getColorId() {
        return colorId;
    }

    public String getColor() {
        return color;
    }

    public Long getHealthId() {
        return healthId;
    }

    public String getHealth() {
        return health;
    }

    public String getHistory() {
        return history;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public Long getCuratorId() {
        return curatorId;
    }

    public String getCuratorFirstName() {
        return curatorFirstName;
    }

    public String getCuratorPhoneNumber() {
        return curatorPhoneNumber;
    }

    public boolean isHasPassport() {
        return hasPassport;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public boolean isSterilized() {
        return isSterilized;
    }

    public Long getTypeId() {
        return typeId;
    }

    public String getType() {
        return type;
    }

    public Long getGenderId() {
        return genderId;
    }

    public String getGender() {
        return gender;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnimalResponse that = (AnimalResponse) o;
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