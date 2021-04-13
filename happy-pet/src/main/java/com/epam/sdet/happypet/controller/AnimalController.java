package com.epam.sdet.happypet.controller;


import com.epam.sdet.happypet.model.Animal;
import com.epam.sdet.happypet.request.dto.OwnerDto;
import com.epam.sdet.happypet.response.wrapper.ItemResponse;
import com.epam.sdet.happypet.response.wrapper.ItemsResponse;
import com.epam.sdet.happypet.service.AnimalBusinessService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/happy.pet/animals")
public class AnimalController extends AbstractController {

    private static final int DEFAULT_LIMIT = 5;

    @Autowired
    private AnimalBusinessService animalService;

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getById(@PathVariable long id) {
        return getResponseEntityObject(animalService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<ItemsResponse> getAll(
            @Join(path = "city", alias = "c")
            @Join(path = "type", alias = "t")
            @Join(path = "breed", alias = "b")
            @Join(path = "color", alias = "cl")
            @Join(path = "organization", alias = "o")
            @And({
                    @Spec(path = "c.id", params = "cityId", spec = Equal.class),
                    @Spec(path = "t.id", params = "typeId", spec = Equal.class),
                    @Spec(path = "b.id", params = "breedId", spec = Equal.class),
                    @Spec(path = "cl.id", params = "colorId", spec = Equal.class),
                    @Spec(path = "o.id", params = "organizationId", spec = Equal.class),
                    @Spec(path = "isSterilized", spec = Equal.class),
                    @Spec(path = "isVaccinated", spec = Equal.class),
            }) Specification<Animal> specification,
            @PageableDefault(size = DEFAULT_LIMIT, sort = "createdAt") Pageable pageable) {
        return getResponseEntityList(animalService.getAll(specification, pageable));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemResponse> bookById(@PathVariable long id, @Valid @RequestBody OwnerDto ownerDto) {
        return putResponseEntityObject(animalService.bookById(id, ownerDto));
    }
}
