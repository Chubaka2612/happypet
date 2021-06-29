package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.entity.Gender;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenderRepository extends org.springframework.data.repository.Repository<Gender, Long> {

    List<Gender> findAll();

    Optional<Gender> findById(Long genderId);
}