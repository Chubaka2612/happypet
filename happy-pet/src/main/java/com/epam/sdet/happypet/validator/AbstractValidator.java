package com.epam.sdet.happypet.validator;

import java.util.Objects;

public abstract class AbstractValidator {

    protected boolean matchesPattern(String value, String pattern) {
        return Objects.nonNull(value) && value.matches(pattern);
    }
}
