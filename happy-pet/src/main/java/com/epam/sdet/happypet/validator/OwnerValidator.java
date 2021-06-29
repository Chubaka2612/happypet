package com.epam.sdet.happypet.validator;

import com.epam.sdet.happypet.repository.OwnerRepository;
import com.epam.sdet.happypet.request.dto.OwnerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Service
public class OwnerValidator extends AbstractValidator implements Validator {

    private static final String REGEX_FOR_NAME = "^.{2,250}$";
    private static final String REGEX_FOR_PHONE = "^\\+?3?8?0[\\s\\.-]\\d{2}[\\s\\.-]\\d{3}[\\s\\.-]\\d{2}[\\s\\.-]\\d{2}$";

    private static final String NAME_VALIDATION_ERROR = "Organization name is not valid";
    private static final String PHONE_VALIDATION_ERROR = "Organization phone number is not valid";

    @Autowired
    private OwnerRepository ownerDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return OwnerDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OwnerDto ownerDtoToValidate = (OwnerDto) target;
        validateName(ownerDtoToValidate.getFirstName()).
                ifPresent(errorMessage -> errors.rejectValue("firstName", HttpStatus.BAD_REQUEST.toString(), errorMessage));
        validateName(ownerDtoToValidate.getLastName()).
                ifPresent(errorMessage -> errors.rejectValue("lastName", HttpStatus.BAD_REQUEST.toString(), errorMessage));
        validatePhone(ownerDtoToValidate.getPhoneNumber()).
                ifPresent(errorMessage -> errors.rejectValue("phoneNumber", HttpStatus.BAD_REQUEST.toString(), errorMessage));
    }

    private Optional<String> validateName(String name) {
        if (!matchesPattern(name, REGEX_FOR_NAME)) {
            return Optional.of(NAME_VALIDATION_ERROR);
        }
        return Optional.empty();
    }

    private Optional<String> validatePhone(String phoneNumber) {
        if (!matchesPattern(phoneNumber, REGEX_FOR_PHONE)) {
            return Optional.of(PHONE_VALIDATION_ERROR);
        }
        return Optional.empty();
    }
}