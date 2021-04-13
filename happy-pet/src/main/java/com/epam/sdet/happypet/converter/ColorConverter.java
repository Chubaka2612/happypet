package com.epam.sdet.happypet.converter;

import com.epam.sdet.happypet.model.Color;
import com.epam.sdet.happypet.response.dto.ColorResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ColorConverter extends Converter {

    public ColorResponseDto entityToResponseDto(Color color) {
        ColorResponseDto colorResponseDto = new ColorResponseDto();
        super.convert(color, colorResponseDto);
        return colorResponseDto;
    }
}
