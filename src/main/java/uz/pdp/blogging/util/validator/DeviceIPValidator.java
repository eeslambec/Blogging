package uz.pdp.blogging.util.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uz.pdp.blogging.exception.InvalidArgumentException;
import uz.pdp.blogging.util.annotations.DeviceIP;

public class DeviceIPValidator implements ConstraintValidator<DeviceIP, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return true;
        if (value.matches("^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"))
            return true;
        throw new InvalidArgumentException("Device IP");
    }
}