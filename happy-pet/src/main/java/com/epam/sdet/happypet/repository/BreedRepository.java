package com.epam.sdet.happypet.repository;


import com.epam.sdet.happypet.model.Breed;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreedRepository  extends org.springframework.data.repository.Repository<Breed, Long> {

    Breed findById(Long breedId);

    List<Breed> findAll();
}
