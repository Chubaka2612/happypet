package com.epam.sdet.happypet.unit;

import com.epam.sdet.happypet.converter.OwnerConverter;
import com.epam.sdet.happypet.core.AbstractUnitTest;
import com.epam.sdet.happypet.entity.Animal;
import com.epam.sdet.happypet.entity.Owner;
import com.epam.sdet.happypet.exception.NotFoundException;
import com.epam.sdet.happypet.exception.UpdateException;
import com.epam.sdet.happypet.repository.AnimalRepository;
import com.epam.sdet.happypet.repository.OwnerRepository;
import com.epam.sdet.happypet.request.dto.OwnerDto;
import com.epam.sdet.happypet.service.AnimalBusinessService;
import com.epam.sdet.happypet.util.TestDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

public class AnimalServiceUnitTest extends AbstractUnitTest {

    @Autowired
    private AnimalBusinessService animalService;

    @MockBean
    private AnimalRepository animalDao;

    @MockBean
    private OwnerRepository ownerDao;

    @Spy
    private OwnerConverter ownerConverter;

    @Test
    void whenBookAnimalByNotExistingId_thenNotFoundExceptionIsExpected() {
        OwnerDto testOwnerDto = TestDataFactory.getStubOwnerDto();
        Mockito
                .when(animalDao.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class,
                () -> animalService.bookById(ArgumentMatchers.any(), testOwnerDto));
    }

    @Test
    void whenBookAlreadyBookedAnimal_thenUpdateExceptionIsExpected() {
        OwnerDto testOwnerDto = TestDataFactory.getStubOwnerDto();
        Animal testAnimal = TestDataFactory.getStubAnimal();
        testAnimal.setBooked(true);
        Mockito
                .when(animalDao.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(testAnimal));
        Assertions.assertThrows(UpdateException.class,
                () -> animalService.bookById(testAnimal.getId(),testOwnerDto));
    }

    @Test
    void whenBookAnimalWithExistingOwner_thenAnimalIsBooked() {
        OwnerDto testOwnerDto = TestDataFactory.getStubOwnerDto();
        Owner testOwner = TestDataFactory.getStubOwner();
        Animal testAnimal = TestDataFactory.getStubAnimal();
        Mockito
                .when(animalDao.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(testAnimal));
        Mockito.when(ownerDao.findByPhoneNumber(ArgumentMatchers.any()))
                .thenReturn(testOwner);

        animalService.bookById(testAnimal.getId(), testOwnerDto);

        Assertions.assertTrue(testAnimal.isBooked());
        Assertions.assertEquals(testAnimal.getOwner().getFirstName(), testOwner.getFirstName());
        Mockito.verify(animalDao, Mockito.times(1))
                .save(testAnimal);
    }

    @Test
    void whenBookAnimalWithNewOwner_thenNewOwnerIsSaved() {
        OwnerDto testOwnerDto = TestDataFactory.getStubOwnerDto();
        Animal testAnimal = TestDataFactory.getStubAnimal();
        Mockito
                .when(animalDao.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(testAnimal));
        Mockito.when(ownerDao.findByPhoneNumber(ArgumentMatchers.any()))
                .thenReturn(null);
        animalService.bookById(testAnimal.getId(), testOwnerDto);
        Mockito.verify(ownerDao, Mockito.times(1))
                .save(ArgumentMatchers.any(Owner.class));
    }
}
