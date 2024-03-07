package uz.pdp.blogging.util.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uz.pdp.blogging.exception.InvalidArgumentException;
import uz.pdp.blogging.util.annotations.Length;

public class LengthValidator implements ConstraintValidator<Length, String> {
    private int min;
    private int max;
    private String fieldName;
    @Override
    public void initialize(Length constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        int length = value.length();
        if (length >= min && length <= max)
            return true;
        throw new InvalidArgumentException("Length of " + fieldName);
    }
}

