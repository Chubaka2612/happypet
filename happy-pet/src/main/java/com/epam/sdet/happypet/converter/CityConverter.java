package com.epam.sdet.happypet.converter;

import com.epam.sdet.happypet.entity.City;
import com.epam.sdet.happypet.response.dto.CityResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CityConverter extends Converter {

    public CityResponseDto entityToResponseDto(City city) {
        CityResponseDto cityResponseDto = new CityResponseDto();
        super.convert(city, cityResponseDto);
        return cityResponseDto;
    }
}
