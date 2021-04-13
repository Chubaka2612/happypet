package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.exception.DeleteException;
import com.epam.sdet.happypet.model.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Long> , JpaSpecificationExecutor<Organization> {

    Organization findByPhoneNumber(String phoneNumber);

    List<Organization> findAllByCityId(Long cityId, Pageable pageable);

    Optional<Organization> findById(Long id);

    Page<Organization> findAll(Specification specification, Pageable pageable);

    //TODO: Move to general
    @Modifying
    @Query("UPDATE #{#entityName} e SET e.isDeleted = true " +
            "WHERE e.id = ?#{#entity.id} AND e.isDeleted = false")
    int deleteByEntity(Organization entity);

    default void delete(Organization entity) {
        int updatedRows = deleteByEntity(entity);
        if (updatedRows == 0) {
            throw new DeleteException("Not found or already deleted");
        }
    }
}