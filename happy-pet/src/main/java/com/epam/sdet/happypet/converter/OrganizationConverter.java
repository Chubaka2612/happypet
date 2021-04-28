package com.epam.sdet.happypet.converter;

import com.epam.sdet.happypet.entity.Organization;
import com.epam.sdet.happypet.repository.CityRepository;
import com.epam.sdet.happypet.request.dto.OrganizationDto;
import com.epam.sdet.happypet.response.dto.OrganizationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationConverter extends Converter {

    @Autowired
    private CityRepository cityDao;

    public Organization dtoToEntity(OrganizationDto organizationDto) {
        Organization organization = new Organization();
        super.convert(organizationDto, organization);
        organization.setCity(cityDao.findById(organizationDto.getCityId()).get());
        return organization;
    }

    public OrganizationResponseDto entityToResponseDto(Organization organization) {
        OrganizationResponseDto organizationResponseDto = new OrganizationResponseDto();
        super.convert(organization, organizationResponseDto);
        organizationResponseDto.setCity(organization.getCity().getName());
        return organizationResponseDto;
    }
}