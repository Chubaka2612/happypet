package com.epam.sdet.happypet.converter;

import com.epam.sdet.happypet.entity.Animal;
import com.epam.sdet.happypet.repository.*;
import com.epam.sdet.happypet.response.dto.AnimalResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalConverter extends Converter {

    @Autowired
    private AnimalRepository animalDao;

    @Autowired
    private BreedRepository breedDao;

    @Autowired
    private CityRepository cityDao;

    @Autowired
    private ColorRepository colorDao;

    @Autowired
    private OrganizationRepository organizationDao;

    @Autowired
    private CuratorRepository curatorDao;

    @Autowired
    private TypeRepository typeDao;

    @Autowired
    private GenderRepository genderDao;

    @Autowired
    private HealthRepository healthDao;

    public AnimalResponseDto entityToResponseDto(Animal animal) {
        AnimalResponseDto animalResponseDto = new AnimalResponseDto();
        super.convert(animal, animalResponseDto);
        animalResponseDto.setBreedId(animal.getBreed().getId())
                .setBreed(breedDao.findById(animal.getBreed().getId()).get().getName())
                .setCityId(animal.getCity().getId())
                .setCity(cityDao.findById(animal.getCity().getId()).get().getName())
                .setCityId(animal.getCity().getId())
                .setColor(colorDao.findById(animal.getColor().getId()).get().getDescription())
                .setHealthId(animal.getHealth().getId())
                .setHealth(healthDao.findById(animal.getHealth().getId()).get().getDescription())
                .setTypeId(animal.getType().getId())
                .setType(typeDao.findById(animal.getType().getId()).get().getName())
                .setGenderId(animal.getGender().getId())
                .setGender(genderDao.findById(animal.getGender().getId()).get().getName())
                .setOrganizationId(animal.getOrganization().getId())
                .setOrganizationName(organizationDao.findById(animal.getOrganization().getId()).get().getName())
                .setCuratorId(animal.getCurator().getId())
                .setCuratorFirstName(curatorDao.findById(animal.getCurator().getId()).get().getFirstName())
                .setCuratorPhoneNumber(curatorDao.findById(animal.getCurator().getId()).get().getPhoneNumber());
        return animalResponseDto;
    }
}