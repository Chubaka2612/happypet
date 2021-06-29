package com.epam.sdet.happypet.integration.db;

import com.epam.sdet.happypet.core.AbstractDbTest;
import com.epam.sdet.happypet.entity.Animal;
import com.epam.sdet.happypet.entity.Owner;
import com.epam.sdet.happypet.repository.AnimalRepository;
import com.epam.sdet.happypet.repository.OwnerRepository;
import com.epam.sdet.happypet.request.dto.OwnerDto;
import com.epam.sdet.happypet.service.AnimalBusinessService;
import com.epam.sdet.happypet.util.TestDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AnimalServiceIntegrationDbTest extends AbstractDbTest {

    @Autowired
    private AnimalBusinessService animalService;

    @Autowired
    private AnimalRepository animalDao;

    @Autowired
    private OwnerRepository ownerDao;

    @Test
    void whenAnimalIsBookedByNewOwner_thenOwnerIsCreatedInDbAndAnimalMarkedAsBooked() {
        long existingAnimalId = 1L;

        OwnerDto testOwnerDto = TestDataFactory.getStubOwnerDto();

        animalService.bookById(existingAnimalId, testOwnerDto);

        Owner actualOwner = ownerDao.findByPhoneNumber(testOwnerDto.getPhoneNumber());
        Assertions.assertAll(
                () -> {
                    Assertions.assertTrue(actualOwner.getId() != null);
                    Assertions.assertEquals(testOwnerDto.getFirstName(), actualOwner.getFirstName());
                    Assertions.assertEquals(testOwnerDto.getLastName(), actualOwner.getLastName());
                }
        );

        Optional<Animal> actualAnimal = animalDao.findById(existingAnimalId);
        Assertions.assertAll(
                () -> {
                    Assertions.assertTrue(actualAnimal.get().isBooked());
                    Assertions.assertEquals(actualOwner.getFirstName(), actualAnimal.get().getOwner().getFirstName());
                }
        );
    }
}