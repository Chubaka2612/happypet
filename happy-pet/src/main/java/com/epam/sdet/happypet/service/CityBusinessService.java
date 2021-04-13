package com.epam.sdet.happypet.service;

import com.epam.sdet.happypet.converter.CityConverter;
import com.epam.sdet.happypet.exception.NotFoundException;
import com.epam.sdet.happypet.model.City;
import com.epam.sdet.happypet.repository.CityRepository;
import com.epam.sdet.happypet.response.dto.CityResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityBusinessService {

    @Autowired
    private CityRepository cityDao;

    @Autowired
    private CityConverter cityConverter;

    public List<CityResponseDto> getAll() {
        List<City> cities = cityDao.findAll();
        return cities.stream().map(
                city -> cityConverter.entityToResponseDto(city))
                .collect(Collectors.toList());
    }

    public CityResponseDto findById(Long cityId) {
        Optional<City> city = cityDao.findById(cityId);
        if (!city.isPresent()) {
            throw new NotFoundException("Can't find city with id: " + cityId);
        }
        CityResponseDto cityResponseDto = cityConverter.entityToResponseDto(city.get());
        return cityResponseDto;
    }
}
