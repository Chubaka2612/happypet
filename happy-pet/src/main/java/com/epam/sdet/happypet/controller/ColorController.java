package com.epam.sdet.happypet.controller;

import com.epam.sdet.happypet.response.wrapper.ItemsResponse;
import com.epam.sdet.happypet.service.ColorBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/happy_pet/colors")
public class ColorController extends AbstractController {

    @Autowired
    private ColorBusinessService colorBusinessService;

    @GetMapping("/list")
    public ResponseEntity<ItemsResponse> getAll() {
        return getResponseEntityList(colorBusinessService.getAll());
    }
}
