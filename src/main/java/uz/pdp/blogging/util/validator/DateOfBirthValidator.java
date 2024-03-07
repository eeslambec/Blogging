package uz.pdp.blogging.util.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uz.pdp.blogging.exception.InvalidArgumentException;
import uz.pdp.blogging.util.annotations.DateOfBirth;

import java.time.LocalDate;

public class DateOfBirthValidator implements ConstraintValidator<DateOfBirth, LocalDate> {
    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if (date == null)
            return true;
        if (date.isAfter(LocalDate.now()))
            return true;
        throw new InvalidArgumentException("Date of birth");
    }
}