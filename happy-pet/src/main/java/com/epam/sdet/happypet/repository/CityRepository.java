package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.entity.City;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    List<City> findAll();

    Optional<City> findById(Long cityId);
}
