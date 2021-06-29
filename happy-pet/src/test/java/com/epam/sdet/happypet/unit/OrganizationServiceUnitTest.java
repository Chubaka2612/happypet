package com.epam.sdet.happypet.unit;

import com.epam.sdet.happypet.core.AbstractUnitTest;
import com.epam.sdet.happypet.entity.Animal;
import com.epam.sdet.happypet.entity.Organization;
import com.epam.sdet.happypet.exception.CreateException;
import com.epam.sdet.happypet.exception.DeleteException;
import com.epam.sdet.happypet.exception.NotFoundException;
import com.epam.sdet.happypet.repository.AnimalRepository;
import com.epam.sdet.happypet.repository.CuratorRepository;
import com.epam.sdet.happypet.repository.OrganizationRepository;
import com.epam.sdet.happypet.request.dto.OrganizationDto;
import com.epam.sdet.happypet.response.dto.OrganizationResponseDto;
import com.epam.sdet.happypet.service.OrganizationBusinessService;
import com.epam.sdet.happypet.util.TestDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;

import java.util.*;
import java.util.stream.Collectors;

public class OrganizationServiceUnitTest extends AbstractUnitTest {

    @Autowired
    private OrganizationBusinessService organizationService;

    @MockBean
    private OrganizationRepository organizationDao;

    @MockBean
    private AnimalRepository animalDao;

    @MockBean
    private CuratorRepository curatorDao;

    @Test
    void whenAddOrganizationWithExistingPhone_thenCreateExceptionIsExpected() {
        Organization testOrganization = TestDataFactory.getStubOrganizationOne();
        OrganizationDto testOrganizationDto = TestDataFactory.getStubOrganizationOneDto();

        Mockito
                .when(organizationDao.findByPhoneNumber(ArgumentMatchers.anyString()))
                .thenReturn(testOrganization);

        Assertions.assertThrows(CreateException.class,
                () -> organizationService.addOrganization(testOrganizationDto));
    }

    @Test
    void whenGetOrganizationByExistingId_thenOrganizationResponseDtoIsReturned() {
        Organization testOrganization = TestDataFactory.getStubOrganizationOne();
        OrganizationResponseDto testOrganizationResponseDto = TestDataFactory.getStubOrganizationOneResponseDto();
        Mockito
                .when(organizationDao.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.ofNullable(testOrganization));
        OrganizationResponseDto organizationResponseDto = organizationService.getById(ENTITY_STUB_ID);

        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(organizationResponseDto.getAddress(), testOrganization.getAddress());
                    Assertions.assertEquals(organizationResponseDto.getName(), testOrganization.getName());
                    Assertions.assertEquals(organizationResponseDto.getPhoneNumber(), testOrganization.getPhoneNumber());
                    Assertions.assertEquals(organizationResponseDto.getCity(), testOrganization.getCity().getName());
                }
        );
    }

    @Test
    void whenGetOrganizationsByCityId_thenListOfOrganizationResponseDtoIsReturned() {
        Organization testOrganizationOne = TestDataFactory.getStubOrganizationOne();
        Organization testOrganizationTwo = TestDataFactory.getStubOrganizationTwo();

        List<Organization> testOrganizations = new ArrayList<>();
        testOrganizations.add(testOrganizationOne);
        testOrganizations.add(testOrganizationTwo);
        Mockito
                .when(organizationDao.findAllByCityId(ArgumentMatchers.any(), Mockito.any(Pageable.class)))
                .thenReturn(testOrganizations);
        List<OrganizationResponseDto> listOrganizationResponseDto = organizationService.getAllByCityId(ENTITY_STUB_ID, DEFAULT_LIMIT);
        Assertions.assertEquals(testOrganizations.size(), listOrganizationResponseDto.size());
        Map<String, Organization> organizationsMap = testOrganizations.stream()
                .collect(Collectors.toMap(organization -> organization.getName(), organization -> organization));
        listOrganizationResponseDto.forEach(responseDto -> Assertions.assertAll(
                () -> {
                    Organization expectedOrganization = organizationsMap.get(responseDto.getName());
                    Assertions.assertEquals(responseDto.getAddress(), expectedOrganization.getAddress());
                    Assertions.assertEquals(responseDto.getPhoneNumber(), expectedOrganization.getPhoneNumber());
                }
        ));
    }

    @Test
    void whenGetOrganizationByNotExistingId_thenNotFoundExceptionIsExpected() {
        Mockito
                .when(organizationDao.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class,
                () -> organizationService.getById(ArgumentMatchers.any()));
    }

    @Test
    void whenDeleteOrganizationWithAssignedAnimal_thenDeleteExceptionIsExpected() {
        Organization testOrganizationOne = TestDataFactory.getStubOrganizationOne();
        List<Animal> testAnimal = new ArrayList<>();
        testAnimal.add(TestDataFactory.getStubAnimal());
        Mockito
                .when(organizationDao.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.ofNullable(testOrganizationOne));
        Mockito
                .when(animalDao.findAllByOrganizationId(ArgumentMatchers.any()))
                .thenReturn(testAnimal);
        Assertions.assertThrows(DeleteException.class,
                () -> organizationService.delete(ArgumentMatchers.any()));
    }

    @Test
    void whenDeleteOrganizationWithNoAssignedAnimalAndCurator_thenOrganizationIsDelete() {
        Organization testOrganizationOne = TestDataFactory.getStubOrganizationOne();
        Mockito
                .when(organizationDao.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.ofNullable(testOrganizationOne));
        Mockito
                .when(animalDao.findAllByOrganizationId(ArgumentMatchers.any()))
                .thenReturn(Collections.emptyList());
        Mockito
                .when(curatorDao.findAllByOrganizationId(ArgumentMatchers.any()))
                .thenReturn(Collections.emptyList());
        organizationService.delete(testOrganizationOne.getId());
        Mockito.verify(organizationDao, Mockito.times(1))
                .delete(testOrganizationOne);
    }
}
