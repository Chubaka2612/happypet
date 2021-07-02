package com.epam.sdet.happypet.service;

import com.epam.sdet.happypet.converter.AnimalConverter;
import com.epam.sdet.happypet.converter.OwnerConverter;
import com.epam.sdet.happypet.exception.NotFoundException;
import com.epam.sdet.happypet.exception.UpdateException;
import com.epam.sdet.happypet.entity.Animal;
import com.epam.sdet.happypet.entity.Owner;
import com.epam.sdet.happypet.repository.AnimalRepository;
import com.epam.sdet.happypet.repository.OwnerRepository;
import com.epam.sdet.happypet.request.dto.OwnerDto;
import com.epam.sdet.happypet.response.dto.AnimalResponseDto;
import com.epam.sdet.happypet.response.dto.AnimalStatisticsResponseDto;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnimalBusinessService {

    @Autowired
    private AnimalRepository animalDao;

    @Autowired
    private OwnerRepository ownerDao;

    @Autowired
    private OwnerConverter ownerConverter;

    @Autowired
    private AnimalConverter animalConverter;

    public Map<List<AnimalResponseDto>, Long> getAll(Specification specification, Pageable pageable)  {
        Page<Animal> animals = animalDao.findAll(specification, pageable);
        long totalEntries = animals.getTotalElements();
        List<AnimalResponseDto> result =  animals.getContent().stream().map(
                animal -> animalConverter.entityToResponseDto(animal))
                .collect(Collectors.toList());
        return  Collections.singletonMap(result, totalEntries);
    }

    public AnimalResponseDto getById(Long animalId) {
        Optional<Animal> animal = animalDao.findById(animalId);
        if (!animal.isPresent()) {
            throw new NotFoundException("Can't find animal with id: " + animalId);
        }
        AnimalResponseDto animalResponseDto = animalConverter.entityToResponseDto(animal.get());
        return animalResponseDto;
    }

    public AnimalStatisticsResponseDto getStatistics(Specification<Animal> specification) {
        AnimalStatisticsResponseDto statisticsResponseDto = new AnimalStatisticsResponseDto();
        int total = IteratorUtils.toList(animalDao.findAll(specification).iterator()).size();
        statisticsResponseDto.setTotal(total);
        int atHomeBooked  = IteratorUtils.toList(animalDao.findAll().iterator())
                .stream().filter(animal -> animal.isBooked())
                .collect(Collectors.toList()).size();
        statisticsResponseDto.setInHomeBooked(atHomeBooked);
        statisticsResponseDto.setInShelters(total - atHomeBooked);
        return statisticsResponseDto;
    }

    @Transactional
    public AnimalResponseDto bookById(Long animalId, OwnerDto ownerDto) {
        Optional<Animal> animal = animalDao.findById(animalId);
        if (!animal.isPresent()) {
            throw new NotFoundException("Can't find animal with id: " + animalId);
        }
        if (animal.get().isBooked()) {
            throw new UpdateException("Can't book animal since it's already booked. Animal id: " + animalId);
        }
        Owner owner = ownerDao.findByPhoneNumber(ownerDto.getPhoneNumber());
        if (Objects.isNull(owner)) {
            owner =  ownerDao.save(ownerConverter.dtoToEntity(ownerDto));
        }
        //update booked status
        animal.get().setBooked(true);
        //assign potential owner
        animal.get().setOwner(owner);
        animalDao.save(animal.get());

        return animalConverter.entityToResponseDto(animal.get());
    }

}