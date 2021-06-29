package com.epam.sdet.happypet.controller;

import com.epam.sdet.happypet.response.wrapper.ItemsResponse;
import com.epam.sdet.happypet.service.BreedBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/happy_pet/breeds")
public class BreedController extends AbstractController {

    @Autowired
    private BreedBusinessService breedService;

    @GetMapping("/list")
    public ResponseEntity<ItemsResponse> getAll() {
        return getResponseEntityList(breedService.getAll());
    }
}
