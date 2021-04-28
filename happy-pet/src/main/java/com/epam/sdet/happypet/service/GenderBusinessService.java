package com.epam.sdet.happypet.service;

import com.epam.sdet.happypet.converter.GenderConverter;
import com.epam.sdet.happypet.entity.Gender;
import com.epam.sdet.happypet.repository.GenderRepository;
import com.epam.sdet.happypet.response.dto.GenderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenderBusinessService {

    @Autowired
    private GenderRepository genderDao;

    @Autowired
    private GenderConverter genderConverter;

    public List<GenderResponseDto> getAll() {
        List<Gender> genders = genderDao.findAll();
        return genders.stream().map(
                gender -> genderConverter.entityToResponseDto(gender))
                .collect(Collectors.toList());
    }
}