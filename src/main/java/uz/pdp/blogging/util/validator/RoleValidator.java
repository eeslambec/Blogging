package uz.pdp.blogging.util.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uz.pdp.blogging.exception.InvalidArgumentException;
import uz.pdp.blogging.util.annotations.Role;

public class RoleValidator implements ConstraintValidator<Role, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null)
            return true;
        if (value.matches("^ROLE_[A-Z]+$"))
            return true;
        throw new InvalidArgumentException("Role");
    }
}