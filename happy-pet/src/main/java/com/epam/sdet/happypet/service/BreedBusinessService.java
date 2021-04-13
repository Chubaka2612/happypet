package com.epam.sdet.happypet.service;

import com.epam.sdet.happypet.converter.BreedConverter;
import com.epam.sdet.happypet.model.Breed;
import com.epam.sdet.happypet.repository.BreedRepository;
import com.epam.sdet.happypet.response.dto.BreedResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreedBusinessService {

    @Autowired
    private BreedRepository breedDao;

    @Autowired
    private BreedConverter breedConverter;

    public List<BreedResponseDto> getAll() {
        List<Breed> breeds = breedDao.findAll();
        return breeds.stream().map(
                breed -> breedConverter.entityToResponseDto(breed))
                .collect(Collectors.toList());
    }
}
