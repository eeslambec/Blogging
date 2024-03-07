package uz.pdp.blogging.service;

import org.springframework.stereotype.Service;
import uz.pdp.blogging.dto.request.UserAuthorizationDto;
import uz.pdp.blogging.dto.request.UserDto;
import uz.pdp.blogging.dto.request.UserUpdateDto;
import uz.pdp.blogging.entity.Role;
import uz.pdp.blogging.entity.User;

import java.util.List;

@Service
public interface UserService {
    UserDto register(UserAuthorizationDto userAuthorizationDto);
    UserDto login(UserAuthorizationDto userAuthorizationDto);
    UserDto getById(Long id);
    UserDto getByUsername(String username);
    UserDto getByEmail(String email);
    UserDto getByUserRole(Role role);
    List<UserDto> getAll();
    void deleteById(Long id);
    void deleteByUsername(String username);
    void deleteByEmail(String email);
    void update(UserUpdateDto userUpdateDto);


}
