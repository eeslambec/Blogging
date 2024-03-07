package uz.pdp.blogging.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.clickuzusers.dto.CustomResponseEntity;
import uz.pdp.clickuzusers.exception.AlreadyExistsException;
import uz.pdp.clickuzusers.exception.InvalidArgumentException;
import uz.pdp.clickuzusers.exception.NotFoundException;
import uz.pdp.clickuzusers.exception.NullOrEmptyException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AlreadyExistsException.class)
    public CustomResponseEntity<?> handleAlreadyExistsException(AlreadyExistsException e){
        return CustomResponseEntity.badRequest(e.getMessage());
    }
    @ExceptionHandler(NullOrEmptyException.class)
    public CustomResponseEntity<?> handleNullOrEmptyException(NullOrEmptyException e){
        return CustomResponseEntity.badRequest(e.getMessage());
    }
    @ExceptionHandler(NotFoundException.class)
    public CustomResponseEntity<?> handleNotFoundException(NotFoundException e){
        return CustomResponseEntity.badRequest(e.getMessage());
    }
    @ExceptionHandler(InvalidArgumentException.class)
    public CustomResponseEntity<?> handleInvalidArgumentException(InvalidArgumentException e){
        return CustomResponseEntity.badRequest(e.getMessage());
    }

}
