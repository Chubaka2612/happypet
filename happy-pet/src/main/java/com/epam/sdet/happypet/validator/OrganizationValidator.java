package com.epam.sdet.happypet.validator;

import com.epam.sdet.happypet.model.City;
import com.epam.sdet.happypet.repository.CityRepository;
import com.epam.sdet.happypet.request.dto.OrganizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;
import java.util.Optional;

@Service
public class OrganizationValidator extends AbstractValidator implements Validator {

    private static final String REGEX_FOR_NAME = "([a-zA-Zа-яА-Яё]){2,200}";
    private static final String REGEX_FOR_ADDRESS = "([a-zA-Zа-яА-Яё]){2,250}";
    private static final String REGEX_FOR_PHONE = "^\\+?3?8?(0[\\s\\.-]\\d{2}[\\s\\.-]\\d{3}[\\s\\.-]\\d{2}[\\s\\.-]\\d{2})$";

    private static final String NAME_VALIDATION_ERROR = "Organization name is not valid";
    private static final String ADDRESS_VALIDATION_ERROR = "Organization address is not valid";
    private static final String PHONE_VALIDATION_ERROR = "Organization phone number is not valid";
    private static final String CITY_VALIDATION_ERROR = "City was not found";

    @Autowired
    private CityRepository cityDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return OrganizationDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrganizationDto organizationDtoToValidate = (OrganizationDto) target;
        validateName(organizationDtoToValidate.getName()).
                ifPresent(errorMessage -> errors.rejectValue("name", HttpStatus.BAD_REQUEST.toString(), errorMessage));
        validateAddress(organizationDtoToValidate.getAddress()).
                ifPresent(errorMessage -> errors.rejectValue("address", HttpStatus.BAD_REQUEST.toString(), errorMessage));
        validatePhone(organizationDtoToValidate.getPhoneNumber()).
                ifPresent(errorMessage -> errors.rejectValue("phoneNumber", HttpStatus.BAD_REQUEST.toString(), errorMessage));
        validateCity(organizationDtoToValidate.getCityId()).
                ifPresent(errorMessage -> errors.rejectValue("cityId", HttpStatus.BAD_REQUEST.toString(), errorMessage));
    }

    private Optional<String> validateName(String name) {
        if (!matchesPattern(name, REGEX_FOR_NAME)) {
            return Optional.of(NAME_VALIDATION_ERROR);
        }
        return Optional.empty();
    }

    private Optional<String> validateAddress(String address) {
        if (!matchesPattern(address, REGEX_FOR_ADDRESS)) {
            return Optional.of(ADDRESS_VALIDATION_ERROR);
        }
        return Optional.empty();
    }

    private Optional<String> validatePhone(String phoneNumber) {
        if (!matchesPattern(phoneNumber, REGEX_FOR_PHONE)) {
            return Optional.of(PHONE_VALIDATION_ERROR);
        }
        return Optional.empty();
    }

    private Optional<String> validateCity(Long cityId) {
        if (Objects.nonNull(cityDao.findById(cityId))) {
            Optional<City> city = cityDao.findById(cityId);
            if (!city.isPresent()) {
                return Optional.of(CITY_VALIDATION_ERROR);
            }
        }
        return Optional.empty();
    }
}