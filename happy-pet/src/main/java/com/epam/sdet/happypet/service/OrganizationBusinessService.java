package com.epam.sdet.happypet.service;

import com.epam.sdet.happypet.converter.OrganizationConverter;
import com.epam.sdet.happypet.exception.CreateException;
import com.epam.sdet.happypet.exception.DeleteException;
import com.epam.sdet.happypet.exception.NotFoundException;
import com.epam.sdet.happypet.entity.Organization;
import com.epam.sdet.happypet.repository.AnimalRepository;
import com.epam.sdet.happypet.repository.CuratorRepository;
import com.epam.sdet.happypet.repository.OrganizationRepository;
import com.epam.sdet.happypet.request.dto.OrganizationDto;
import com.epam.sdet.happypet.response.dto.OrganizationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationBusinessService {

    @Autowired
    private OrganizationRepository organizationDao;

    @Autowired
    private AnimalRepository animalDao;

    @Autowired
    private CuratorRepository curatorDao;

    @Autowired
    private OrganizationConverter organizationConverter;

    @Transactional
    public OrganizationResponseDto addOrganization(OrganizationDto organizationDto) {
        Organization organization = organizationDao.findByPhoneNumber(organizationDto.getPhoneNumber());
        if (!Objects.isNull(organization)) {
            throw new CreateException("Organization with such phone already exists");
        }
        organization = organizationDao.save(organizationConverter.dtoToEntity(organizationDto));
        OrganizationResponseDto organizationResponseDto = organizationConverter.entityToResponseDto(organization);
        return organizationResponseDto;
    }

    public OrganizationResponseDto getById(Long organizationId) {
        Optional<Organization> organization = organizationDao.findById(organizationId);
        if (!organization.isPresent()) {
            throw new NotFoundException("Can't find organizations with id: " + organizationId);
        }
        OrganizationResponseDto organizationResponseDto = organizationConverter.entityToResponseDto(organization.get());
        return organizationResponseDto;
    }

    public List<OrganizationResponseDto> getAllByCityId(Long cityId, Integer limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        List<Organization> organizations = organizationDao.findAllByCityId(cityId, pageRequest);
        return organizations.stream().map(
                organization -> organizationConverter.entityToResponseDto(organization)
                        .setCity(organization.getCity().getName()))
                .collect(Collectors.toList());
    }

    public List<OrganizationResponseDto> getAll(Specification specification, Pageable pageable)  {
        Page<Organization> organizations = organizationDao.findAll(specification, pageable);
        return organizations.getContent().stream().map(
                organization -> organizationConverter.entityToResponseDto(organization)
                        .setCity(organization.getCity().getName()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long organizationId) {
        Optional<Organization> organizationToDelete = organizationDao.findById(organizationId);
        if (organizationToDelete.isPresent()) {
            if (!animalDao.findAllByOrganizationId(organizationId).isEmpty()
                    || !curatorDao.findAllByOrganizationId(organizationId).isEmpty()) {
                throw new DeleteException("Organization can't be deleted, because it still has some animals and curator associated");
            }
            organizationDao.delete(organizationToDelete.get());
        }
    }
}