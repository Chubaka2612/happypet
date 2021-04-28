package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.entity.Curator;
import com.epam.sdet.happypet.entity.Owner;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuratorRepository extends PagingAndSortingRepository<Curator, Long> {

    List<Curator> findAllByOrganizationId(Long id);
}
