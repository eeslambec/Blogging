package uz.pdp.blogging.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.pdp.blogging.dto.request.UserAuthorizationDto;
import uz.pdp.blogging.dto.request.UserDto;
import uz.pdp.blogging.dto.request.UserUpdateDto;
import uz.pdp.blogging.entity.Role;
import uz.pdp.blogging.entity.User;
import uz.pdp.blogging.exception.AlreadyExistsException;
import uz.pdp.blogging.exception.InvalidArgumentException;
import uz.pdp.blogging.exception.NotFoundException;
import uz.pdp.blogging.exception.NullOrEmptyException;
import uz.pdp.blogging.repository.UserRepository;
import uz.pdp.blogging.service.UserService;
import uz.pdp.blogging.util.Validator;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDto register(UserAuthorizationDto userAuthorizationDto) {
        if (userAuthorizationDto == null)
            throw new NullOrEmptyException("UserDto");
        if (Validator.isNullOrEmpty(userAuthorizationDto.getEmail()))
            throw new NullOrEmptyException("Email");
        if (Validator.isNullOrEmpty(userAuthorizationDto.getPassword()))
            throw new NullOrEmptyException("Password");
        if (Validator.isNullOrEmpty(userAuthorizationDto.getUsername()))
            throw new NullOrEmptyException("Username");
        if (userRepository.findByUsername(userAuthorizationDto.getUsername()).isPresent())
            throw new AlreadyExistsException("User with this username:" + userAuthorizationDto.getUsername());
        if (userRepository.findByEmail(userAuthorizationDto.getEmail()).isPresent())
            throw new AlreadyExistsException("User with this email:" + userAuthorizationDto.getEmail());
        return new UserDto(userRepository.save(User.builder()
                .email(userAuthorizationDto.getEmail())
                .password(passwordEncoder.encode(userAuthorizationDto.getPassword()))
                .username(userAuthorizationDto.getUsername())
                .build()));
    }

    @Override
    public UserDto login(UserAuthorizationDto userAuthorizationDto) {
        if (Validator.isNullOrEmpty(userAuthorizationDto.getUsername())
                && (!Validator.isNullOrEmpty(userAuthorizationDto.getEmail()))){
            User user = userRepository.findByEmail(userAuthorizationDto.getEmail()).orElseThrow(
                    () -> new NotFoundException("User"));
            if (!passwordEncoder.matches(userAuthorizationDto.getPassword(), user.getPassword()))
                throw new InvalidArgumentException("Password");
            return new UserDto(user);
        }
        else if (Validator.isNullOrEmpty(userAuthorizationDto.getEmail())
                && (!Validator.isNullOrEmpty(userAuthorizationDto.getUsername()))){
            User user = userRepository.findByUsername(userAuthorizationDto.getUsername()).orElseThrow(
                    () -> new NotFoundException("User"));
            if (!passwordEncoder.matches(userAuthorizationDto.getPassword(), user.getPassword()))
                throw new InvalidArgumentException("Password");
            return new UserDto(user);
        }
        else throw new NullOrEmptyException("User details");
    }

    @Override
    public UserDto getById(Long id) {
        if (id == null)
            throw new NullOrEmptyException("Id");
        return new UserDto(userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User")));
    }

    @Override
    public UserDto getByUsername(String username) {
        if (Validator.isNullOrEmpty(username))
            throw new NullOrEmptyException("Username");
        return new UserDto(userRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundException("User")));
        }

    @Override
    public UserDto getByEmail(String email) {
        if (Validator.isNullOrEmpty(email))
            throw new NullOrEmptyException("Email");
        return new UserDto(userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException("User")));
    }

    @Override
    public UserDto getByUserRole(Role role) {
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }


    @Override
    public void deleteByUsername(String username) {

    }

    @Override
    public void deleteByEmail(String email) {

    }

    @Override
    public void update(UserUpdateDto userUpdateDto) {

    }
}
