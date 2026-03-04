package com.example.rescuespot.user.service;

import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.user.DTO.request.UserRequestDTO;
import com.example.rescuespot.user.DTO.response.UserResponseDTO;
import com.example.rescuespot.user.entity.User;
import com.example.rescuespot.user.mapper.IUserMapper;
import com.example.rescuespot.user.repository.UserRepository;
import com.example.rescuespot.user.service.intrfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserMapper userMapper;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequest) {

        User userEntity = userMapper.toEntity(userRequest);

        Account account = userEntity.getAccount();

        if (account != null) {

            if (account.getPassword() != null) {
                account.setPassword(
                        passwordEncoder.encode(account.getPassword())
                );
            }

            account.setUser(userEntity);
        }

        User savedUser = userRepository.save(userEntity);

        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id)
                );

        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequest) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id)
                );

        existingUser.setFirstName(userRequest.getFirstName());
        existingUser.setLastName(userRequest.getLastName());

        User updatedUser = userRepository.save(existingUser);

        return userMapper.toResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id)
                );

        userRepository.delete(user);
    }
}