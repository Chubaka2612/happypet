package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeRepository extends org.springframework.data.repository.Repository<Type, Long> {

    List<Type> findAll();

    Optional<Type> findById(Long typeId);
}
