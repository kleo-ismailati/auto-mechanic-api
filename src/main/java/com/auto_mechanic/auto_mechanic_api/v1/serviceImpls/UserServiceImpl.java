package com.auto_mechanic.auto_mechanic_api.v1.serviceImpls;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.UserCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.UserUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.UserItemDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.UserDto;
import com.auto_mechanic.auto_mechanic_api.v1.mappers.UserMapper;
import com.auto_mechanic.auto_mechanic_api.v1.models.Role;
import com.auto_mechanic.auto_mechanic_api.v1.models.RolesConstants;
import com.auto_mechanic.auto_mechanic_api.v1.models.User;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.RoleRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.UserRepository;
import com.auto_mechanic.auto_mechanic_api.v1.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passEncryptor;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passEncryptor) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passEncryptor = passEncryptor;
    }

    public ResponseEntity<List<UserItemDto>> getAllUsers() {

        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(userMapper.toUserDtoList(users));
    }

    public ResponseEntity<UserDto> getUser(Long id) {

        User user = userRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    public ResponseEntity<Void> addUser(UserCreateDto newUser) {
        Role adminRole = roleRepository.findByName(RolesConstants.ADMIN).orElseThrow();
        User user = userMapper.toNewEntity(newUser, adminRole);
        user.setPassword(passEncryptor.encode(user.getPassword()));
        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteUser(Long id) {

        userRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> editUser(Long id, UserUpdateDto userUpdateDto) {

        User user = userRepository.findById(id).orElseThrow();

        if (userUpdateDto.getPassword() != null) {
            user.setPassword(passEncryptor.encode(userUpdateDto.getPassword()));
        }

        userMapper.updateEntity(userUpdateDto, user);
        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
