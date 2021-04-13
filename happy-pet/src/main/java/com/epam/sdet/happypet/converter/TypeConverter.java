package com.epam.sdet.happypet.converter;

import com.epam.sdet.happypet.model.Type;
import com.epam.sdet.happypet.response.dto.TypeResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TypeConverter extends Converter {

    public TypeResponseDto entityToResponseDto(Type type) {
        TypeResponseDto typeResponseDto = new TypeResponseDto();
        super.convert(type, typeResponseDto);
        return typeResponseDto;
    }
}