package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.model.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends PagingAndSortingRepository<Animal, Long>, JpaSpecificationExecutor<Animal> {

    Optional<Animal> findById(Long id);

    List<Animal> findAllByOrganizationId(Long id);

    Page<Animal> findAll(Specification specification, Pageable pageable);
}