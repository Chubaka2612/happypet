package com.epam.sdet.happypet.repository;


import com.epam.sdet.happypet.entity.Breed;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BreedRepository  extends org.springframework.data.repository.Repository<Breed, Long> {

    Optional<Breed> findById(Long breedId);

    List<Breed> findAll();
}
