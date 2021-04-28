package com.epam.sdet.happypet.repository;


import com.epam.sdet.happypet.entity.Health;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HealthRepository extends org.springframework.data.repository.Repository<Health, Long> {

    Optional<Health> findById(Long healthId);

    List<Health> findAll();
}
