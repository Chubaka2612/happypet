package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByPhoneNumber(String phoneNumber);

    List<Owner> findAll();
}
