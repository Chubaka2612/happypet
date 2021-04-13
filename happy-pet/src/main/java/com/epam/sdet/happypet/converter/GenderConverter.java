package com.epam.sdet.happypet.converter;

import com.epam.sdet.happypet.model.Gender;
import com.epam.sdet.happypet.response.dto.GenderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class GenderConverter extends Converter {

    public GenderResponseDto entityToResponseDto(Gender gender) {
       GenderResponseDto genderResponseDto = new GenderResponseDto();
        super.convert(gender, genderResponseDto);
        return genderResponseDto;
    }
}
