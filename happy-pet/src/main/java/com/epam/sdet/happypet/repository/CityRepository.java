package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.model.City;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends org.springframework.data.repository.Repository<City, Long>  {

    List<City> findAll();

    Optional<City> findById(Long cityId);
}
