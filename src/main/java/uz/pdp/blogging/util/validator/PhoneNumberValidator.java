package uz.pdp.blogging.util.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uz.pdp.blogging.exception.InvalidArgumentException;
import uz.pdp.blogging.util.annotations.PhoneNumber;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return true;
        if (value.matches("^\\+998\\d{2}\\d{3}\\d{2}\\d{2}$"))
            return true;
        throw new InvalidArgumentException("Phone number");
    }
}
