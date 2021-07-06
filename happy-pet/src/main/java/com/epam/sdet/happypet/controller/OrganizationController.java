package com.epam.sdet.happypet.controller;

import com.epam.sdet.happypet.entity.Organization;
import com.epam.sdet.happypet.request.dto.OrganizationDto;
import com.epam.sdet.happypet.response.wrapper.ItemResponse;
import com.epam.sdet.happypet.response.wrapper.ItemsResponse;
import com.epam.sdet.happypet.service.OrganizationBusinessService;
import com.epam.sdet.happypet.validator.OrganizationValidator;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/happy_pet/organizations")
@CrossOrigin(origins = "*")
public class OrganizationController extends AbstractController {

    private static final int DEFAULT_LIMIT = 10;

    @Autowired
    private OrganizationBusinessService organizationService;

    @Autowired
    private OrganizationValidator organizationValidator;

    @InitBinder
    public void initBinder(DataBinder dataBinder) {
        dataBinder.addValidators(organizationValidator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getById(@PathVariable long id) {
        return getResponseEntityObject(organizationService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<ItemsResponse> getAll(
            @Join(path = "city", alias = "c")
            @Spec(path = "c.id", params = "cityId", spec = Equal.class)
                    Specification<Organization> specification,
            @PageableDefault(size = DEFAULT_LIMIT, sort = "createdAt") Pageable pageable) {
        return getResponseEntityList(organizationService.getAll(specification, pageable));
    }

    @PostMapping
    public ResponseEntity<ItemResponse> createOrganization(@Valid @RequestBody OrganizationDto organizationDto) {
        return postResponseEntityObject(organizationService.addOrganization(organizationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Organization> deleteOrganization(@PathVariable long id) {
        organizationService.delete(id);
        return deleteResponseEntityObject();
    }
}