package com.epam.sdet.happypet.controller;

import com.epam.sdet.happypet.response.wrapper.ItemsResponse;
import com.epam.sdet.happypet.service.TypeBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/happy.pet/types")
public class TypesController extends AbstractController {

    @Autowired
    private TypeBusinessService typeBusinessService;

    @GetMapping("/list")
    public ResponseEntity<ItemsResponse> getAll() {
        return getResponseEntityList(typeBusinessService.getAll());
    }
}
