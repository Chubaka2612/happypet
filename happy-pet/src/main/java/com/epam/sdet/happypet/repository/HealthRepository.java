package com.epam.sdet.happypet.repository;


import com.epam.sdet.happypet.model.Health;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthRepository extends org.springframework.data.repository.Repository<Health, Long> {

    Health findById(Long healthId);

    List<Health> findAll();
}
