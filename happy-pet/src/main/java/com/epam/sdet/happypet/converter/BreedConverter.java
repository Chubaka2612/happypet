package com.epam.sdet.happypet.converter;

import com.epam.sdet.happypet.model.Breed;
import com.epam.sdet.happypet.repository.TypeRepository;
import com.epam.sdet.happypet.response.dto.BreedResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BreedConverter extends Converter {

    @Autowired
    private TypeRepository typeDao;

    public BreedResponseDto entityToResponseDto(Breed breed) {
        BreedResponseDto breedResponseDto = new BreedResponseDto();
        super.convert(breed, breedResponseDto);
        breedResponseDto.setType(typeDao.findById(breed.getType().getId()).getName())
                .setTypeId(breed.getType().getId());
        return breedResponseDto;
    }
}
