package com.epam.sdet.happypet.converter;

import com.epam.sdet.happypet.entity.Owner;
import com.epam.sdet.happypet.request.dto.OwnerDto;
import com.epam.sdet.happypet.response.dto.OwnerResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OwnerConverter extends Converter {

    public OwnerResponseDto entityToResponseDto(Owner owner) {
        OwnerResponseDto ownerResponseDto = new OwnerResponseDto();
        super.convert(owner, ownerResponseDto);
        return ownerResponseDto;
    }

    public Owner dtoToEntity(OwnerDto ownerDto) {
        Owner owner = new Owner();
        super.convert(ownerDto, owner);
        return owner;
    }
}
