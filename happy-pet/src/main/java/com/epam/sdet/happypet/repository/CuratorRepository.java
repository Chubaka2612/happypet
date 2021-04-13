package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.model.Curator;
import com.epam.sdet.happypet.model.Organization;
import com.epam.sdet.happypet.model.Owner;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuratorRepository extends PagingAndSortingRepository<Curator, Long> {

    Optional<Curator> findById(Long id);

    Owner findByLastName(String lastName);

    Owner findByPhoneNumber(String phoneNumber);

    List<Curator> findAll();

    List<Curator> findAllByOrganizationId(Long id);
}
