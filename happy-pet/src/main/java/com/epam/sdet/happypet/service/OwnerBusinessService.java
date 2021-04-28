package com.epam.sdet.happypet.service;

import com.epam.sdet.happypet.entity.Owner;
import com.epam.sdet.happypet.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerBusinessService {

    @Autowired
    private OwnerRepository ownerDao;

    public List<Owner> findAll() {
        return ownerDao.findAll();
    }
}