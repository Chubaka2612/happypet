package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.model.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends org.springframework.data.repository.Repository<Type, Long> {

    List<Type> findAll();

    Type findById(Long typeId);
}
