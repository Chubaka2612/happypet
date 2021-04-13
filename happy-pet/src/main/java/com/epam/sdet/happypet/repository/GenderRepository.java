package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.model.Gender;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderRepository extends org.springframework.data.repository.Repository<Gender, Long> {

    List<Gender> findAll();

    Gender findById(Long genderId);
}