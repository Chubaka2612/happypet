package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.entity.Color;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColorRepository extends org.springframework.data.repository.Repository<Color, Long> {

        List<Color> findAll();

        Optional<Color> findById(Long colorId);
}
