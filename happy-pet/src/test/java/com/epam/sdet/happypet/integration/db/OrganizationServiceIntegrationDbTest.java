package com.epam.sdet.happypet.integration.db;

import com.epam.sdet.happypet.core.AbstractDbTest;
import com.epam.sdet.happypet.entity.Organization;
import com.epam.sdet.happypet.exception.CreateException;
import com.epam.sdet.happypet.exception.DeleteException;
import com.epam.sdet.happypet.repository.CityRepository;
import com.epam.sdet.happypet.repository.OrganizationRepository;
import com.epam.sdet.happypet.request.dto.OrganizationDto;
import com.epam.sdet.happypet.service.OrganizationBusinessService;
import com.epam.sdet.happypet.util.Builder;
import com.epam.sdet.happypet.util.TestDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class OrganizationServiceIntegrationDbTest extends AbstractDbTest {

    private static final String EXISTING_PHONE = "+380 93 408 09 36";

    @Autowired
    private OrganizationBusinessService organizationService;

    @Autowired
    private OrganizationRepository organizationDao;

    @Autowired
    private CityRepository cityDao;

    @Test
    void whenValidOrganizationIsProvided_thenOrganizationIsCreatedInDb() {
        OrganizationDto testOrganizationDto = TestDataFactory.getStubOrganizationOneDto();
        organizationService.addOrganization(testOrganizationDto);

        Organization actualOrganization = organizationDao.findByPhoneNumber(testOrganizationDto.getPhoneNumber());
        Assertions.assertAll(
                () ->
                {
                    Assertions.assertTrue(actualOrganization.getId() != null);
                    Assertions.assertEquals(testOrganizationDto.getAddress(), actualOrganization.getAddress());
                    Assertions.assertEquals(testOrganizationDto.getName(), actualOrganization.getName());
                    Assertions.assertEquals(testOrganizationDto.getCityId(), actualOrganization.getCity().getId());
                }
        );
    }

    @Test
    void whenOrganizationWithExistingPhoneIsProvided_thenCreateExceptionIsExpectedAndOrganizationIsNotCreatedInDb() {

        OrganizationDto testOrganizationDto =
                Builder.build(OrganizationDto.class)
                        .with(s -> s.setName("Test organization"))
                        .with(s -> s.setCityId(1L))
                        .with(s -> s.setAddress("Test street 23"))
                        .with(s -> s.setPhoneNumber(EXISTING_PHONE))
                        .get();
        Assertions.assertThrows(CreateException.class,
                () -> organizationService.addOrganization(testOrganizationDto));
        Organization existingOrganization = organizationDao.findByPhoneNumber(EXISTING_PHONE);
        Assertions.assertNotEquals(testOrganizationDto.getName(), existingOrganization.getName());
    }

    @Test
    void whenOrganizationWithNoAssignmentsIsDeleted_thenOrganizationIsMarkedAsDeletedInDb() {
        Organization testOrganization =
                Builder.build(Organization.class)
                        .with(s -> s.setName("Test organization"))
                        .with(s -> s.setCity(cityDao.findById(1L).get()))
                        .with(s -> s.setAddress("Test street 23"))
                        .with(s -> s.setPhoneNumber("+380 93 408 09 66"))
                        .get();
        Organization expectedOrganization = organizationDao.save(testOrganization);

        organizationService.delete(expectedOrganization.getId());

        Optional<Organization> actualOrganization = organizationDao.findById(expectedOrganization.getId());
        Assertions.assertTrue(actualOrganization.get().isDeleted());
    }

    @Test
    void whenOrganizationWithAssignmentsIsDeleted_thenDeleteExceptionIsExpectedAndOrganizationIsNotMarkedAsDeletedInDb() {
        Organization presentOrganization = organizationDao.findByPhoneNumber(EXISTING_PHONE);

        Assertions.assertThrows(DeleteException.class,
                () -> organizationService.delete(presentOrganization.getId()));

        Optional<Organization> actualOrganization = organizationDao.findById(presentOrganization.getId());
        Assertions.assertFalse(actualOrganization.get().isDeleted());
    }
}