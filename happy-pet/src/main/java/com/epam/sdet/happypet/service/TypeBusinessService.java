package com.epam.sdet.happypet.service;

import com.epam.sdet.happypet.converter.TypeConverter;
import com.epam.sdet.happypet.model.Type;
import com.epam.sdet.happypet.repository.TypeRepository;
import com.epam.sdet.happypet.response.dto.TypeResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeBusinessService {

    @Autowired
    private TypeRepository typeDao;

    @Autowired
    private TypeConverter typeConverter;

    public List<TypeResponseDto> getAll() {
        List<Type> types = typeDao.findAll();
        return types.stream().map(
                type -> typeConverter.entityToResponseDto(type))
                .collect(Collectors.toList());
    }
}