package com.epam.sdet.happypet.service;

import com.epam.sdet.happypet.converter.ColorConverter;
import com.epam.sdet.happypet.model.Color;
import com.epam.sdet.happypet.repository.ColorRepository;
import com.epam.sdet.happypet.response.dto.ColorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorBusinessService {

    @Autowired
    private ColorRepository colorDao;

    @Autowired
    private ColorConverter colorConverter;

    public List<ColorResponseDto> getAll() {
        List<Color> colors = colorDao.findAll();
        return colors.stream().map(
                color -> colorConverter.entityToResponseDto(color))
                .collect(Collectors.toList());
    }
}
