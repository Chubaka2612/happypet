package com.epam.sdet.happypet.integration.controllers;

import com.epam.sdet.happypet.controller.OrganizationController;
import com.epam.sdet.happypet.core.AbstractApiTest;
import com.epam.sdet.happypet.exception.GlobalExceptionHandler;
import com.epam.sdet.happypet.repository.CityRepository;
import com.epam.sdet.happypet.request.dto.OrganizationDto;
import com.epam.sdet.happypet.response.dto.OrganizationResponseDto;
import com.epam.sdet.happypet.response.wrapper.ItemResponse;
import com.epam.sdet.happypet.service.OrganizationBusinessService;
import com.epam.sdet.happypet.util.Builder;
import com.epam.sdet.happypet.util.TestDataFactory;
import com.epam.sdet.happypet.validator.OrganizationValidator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.HttpServletResponse;

import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest(OrganizationController.class)
@ContextConfiguration(classes = {OrganizationController.class, OrganizationValidator.class, GlobalExceptionHandler.class})
public class OrganizationControllerIntegrationApiTest extends AbstractApiTest {

    private static final String ORGANIZATION_URL = "/api/happy_pet/organizations";
    private static final String NOT_FOUND_MESSAGE = "Resource was not found";
    private static final String ALL_FIELDS_ARE_INVALID_MESSAGE =  "Invalid values: field: name, value: ''{0}'', message: Organization name is not valid; " +
            "field: address, value: ''{1}'', message: Organization address is not valid; " +
            "field: phoneNumber, value: ''{2}'', message: Organization phone number is not valid; " +
            "field: cityId, value: ''{3}'', message: City was not found; ";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private OrganizationBusinessService organizationService;

    @MockBean
    private CityRepository cityDao;


    @Test
    void whenValidOrganizationDtoIsProvidedOnPostOrganization_thenOrganizationIsCreated() throws Exception {

        OrganizationDto testOrganizationDto = TestDataFactory.getStubOrganizationOneDto();
        OrganizationResponseDto organizationResponseDto = TestDataFactory.getStubOrganizationOneResponseDto();

        Mockito.when(organizationService.addOrganization(testOrganizationDto))
                .thenReturn(organizationResponseDto);
        //validator
        Mockito.when(cityDao.findById(ArgumentMatchers.any()))
                .thenReturn(ArgumentMatchers.any());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(ORGANIZATION_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(testOrganizationDto)))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpServletResponse.SC_CREATED, response.getStatus());

        String body = response.getContentAsString();
        ItemResponse<OrganizationResponseDto> actualOrganizationResponseDto =
                mapper.readValue(body, new TypeReference<ItemResponse<OrganizationResponseDto>>() {});

        Assertions.assertAll( () -> {
                    assertEquals(testOrganizationDto.getName(), actualOrganizationResponseDto.getItem().getName());
                    assertEquals(testOrganizationDto.getAddress(), actualOrganizationResponseDto.getItem().getAddress());
                    assertEquals(testOrganizationDto.getPhoneNumber(), actualOrganizationResponseDto.getItem().getPhoneNumber());
                }
        );
    }

    @Test
    void whenInvalidOrganizationDtoIsProvidedOnPostOrganization_thenBadRequestIsExpected() throws Exception {
        String oneCharString = "T";
        long invalidId = 1L;
        String emptyString = StringUtils.EMPTY;
        OrganizationDto testOrganizationDto =
                Builder.build(OrganizationDto.class)
                        .with(s -> s.setName(oneCharString))
                        .with(s -> s.setCityId(invalidId))
                        .with(s -> s.setAddress(emptyString))
                        .with(s -> s.setPhoneNumber(emptyString))
                        .get();

        OrganizationResponseDto organizationResponseDto = TestDataFactory.getStubOrganizationOneResponseDto();

        Mockito.when(organizationService.addOrganization(testOrganizationDto))
                .thenReturn(organizationResponseDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(ORGANIZATION_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(testOrganizationDto)))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpServletResponse.SC_BAD_REQUEST, response.getStatus());
        assertTrue(response.getContentAsString().contains(
                MessageFormat.format(ALL_FIELDS_ARE_INVALID_MESSAGE, oneCharString, emptyString, emptyString, invalidId)));
    }

    @Test
    void whenGetOrganizationWithNotExistingId_thenBadRequestIsExpected() throws Exception {
        long nonExistingId = 123L;
        Mockito.when(organizationService.getById(nonExistingId))
                .thenReturn(null);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(ORGANIZATION_URL + "/"
                + nonExistingId))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpServletResponse.SC_NOT_FOUND, response.getStatus());

        String body = response.getContentAsString();
        Assertions.assertTrue(body.contains(NOT_FOUND_MESSAGE));
    }
}