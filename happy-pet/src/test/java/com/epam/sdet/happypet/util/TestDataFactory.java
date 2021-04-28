package com.epam.sdet.happypet.util;

import com.epam.sdet.happypet.entity.*;
import com.epam.sdet.happypet.request.dto.OrganizationDto;
import com.epam.sdet.happypet.request.dto.OwnerDto;
import com.epam.sdet.happypet.response.dto.OrganizationResponseDto;

import java.util.Date;

public class TestDataFactory {

    public static Organization getStubOrganizationOne() {
        return Builder.build(Organization.class)
                .with(s -> s.setId(1L))
                .with(s -> s.setName("Test organization 1"))
                .with(s -> s.setCity(getStubCity()))
                .with(s -> s.setAddress("Test street 23"))
                .with(s -> s.setPhoneNumber("+380 11 111 11 11"))
                .get();
    }

    public static Organization getStubOrganizationTwo() {
        return Builder.build(Organization.class)
                .with(s -> s.setId(2L))
                .with(s -> s.setName("Test organization 2"))
                .with(s -> s.setCity(getStubCity()))
                .with(s -> s.setAddress("Test street 33"))
                .with(s -> s.setPhoneNumber("+380 22 222 22 22"))
                .get();
    }

    public static OrganizationDto getStubOrganizationOneDto() {
        return Builder.build(OrganizationDto.class)
                .with(s -> s.setName("Test organization"))
                .with(s -> s.setCityId(1L))
                .with(s -> s.setAddress("Test street 23"))
                .with(s -> s.setPhoneNumber("+380 11 111 11 11"))
                .get();
    }

    public static OrganizationResponseDto getStubOrganizationOneResponseDto() {
        return Builder.build(OrganizationResponseDto.class)
                .with(s -> s.setName("Test organization"))
                .with(s -> s.setCity("Test city"))
                .with(s -> s.setAddress("Test street 23"))
                .with(s -> s.setPhoneNumber("+380 11 111 11 11"))
                .get();
    }

    public static City getStubCity() {
        return Builder.build(City.class)
                .with(c -> c.setId(1L))
                .with(c -> c.setName("Test city"))
                .get();
    }

    public static Breed getStubBreed() {
        return Builder.build(Breed.class)
                .with(c -> c.setId(1L))
                .with(c -> c.setName("Test breed"))
                .get();
    }

    public static Color getStubColor() {
        return Builder.build(Color.class)
                .with(c -> c.setId(1L))
                .with(c -> c.setDescription("Test color"))
                .get();
    }

    public static Gender getStubGender() {
        return Builder.build(Gender.class)
                .with(c -> c.setId(1L))
                .with(c -> c.setName("male"))
                .get();
    }

    public static Health getStubHealth() {
        return Builder.build(Health.class)
                .with(c -> c.setId(1L))
                .with(c -> c.setDescription("Test health"))
                .get();
    }

    public static Curator getStubCurator() {
        return Builder.build(Curator.class)
                .with(c -> c.setId(1L))
                .with(c -> c.setPhoneNumber("+380 11 111 11 22"))
                .with(c -> c.setFirstName("Test name"))
                .with(c -> c.setLastName("Test surname"))
                .with(c -> c.setOrganization(getStubOrganizationOne()))
                .get();
    }

    public static OwnerDto getStubOwnerDto() {
        return Builder.build(OwnerDto.class)
                .with(c -> c.setPhoneNumber("+380 11 111 22 22"))
                .with(c -> c.setFirstName("Test name"))
                .with(c -> c.setLastName("Test surname"))
                .get();
    }

    public static Owner getStubOwner() {
        return Builder.build(Owner.class)
                .with(c -> c.setId(1L))
                .with(c -> c.setPhoneNumber("+380 11 111 22 22"))
                .with(c -> c.setFirstName("Test name"))
                .with(c -> c.setLastName("Test surname"))
                .get();
    }

    public static Type getType() {
        return Builder.build(Type.class)
                .with(c -> c.setId(1L))
                .with(c -> c.setName("cat"))
                .get();
    }

    public static Animal getStubAnimal() {
        return Builder.build(Animal.class)
                .with(a -> a.setId(1L))
                .with(a -> a.setName("Test name"))
                .with(a -> a.setCity(getStubCity()))
                .with(a -> a.setBooked(false))
                .with(a -> a.setBehavior("Test behavior"))
                .with(a -> a.setBirthday(new Date()))
                .with(a -> a.setBreed(getStubBreed()))
                .with(a -> a.setColor(getStubColor()))
                .with(a -> a.setGender(getStubGender()))
                .with(a -> a.setHasPassport(false))
                .with(a -> a.setHealth(getStubHealth()))
                .with(a -> a.setHistory("Test history"))
                .with(a -> a.setOrganization(getStubOrganizationOne()))
                .with(a -> a.setCurator(getStubCurator()))
                .with(a -> a.setSterilized(true))
                .with(a -> a.setVaccinated(false))
                .with(a -> a.setType(getType()))
                .get();
    }
}
