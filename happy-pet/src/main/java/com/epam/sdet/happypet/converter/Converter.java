package com.epam.sdet.happypet.converter;

import com.epam.sdet.happypet.exception.DataConversionException;
import org.springframework.beans.BeanUtils;

public class Converter {

    protected void convert(Object source, Object target) {
        try {
            BeanUtils.copyProperties(source, target);
        } catch (Exception e) {
            throw new DataConversionException("Can't convert data" + e.getMessage());
        }
    }
}
