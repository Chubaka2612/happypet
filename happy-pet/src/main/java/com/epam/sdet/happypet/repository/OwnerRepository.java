package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.model.Owner;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends PagingAndSortingRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    Owner findByPhoneNumber(String phoneNumber);

    List<Owner> findAll();
}
