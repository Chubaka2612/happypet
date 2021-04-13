package com.epam.sdet.happypet.repository;

import com.epam.sdet.happypet.model.Color;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends org.springframework.data.repository.Repository<Color, Long> {

        List<Color> findAll();

        Color findById(Long colorId);
}
