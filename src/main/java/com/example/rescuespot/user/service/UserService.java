package com.example.rescuespot.user.service;

import com.example.rescuespot.exeptions.email.EmailNotFoundExeption;
import com.example.rescuespot.exeptions.password.PasswordIsRequiredExeption;
import com.example.rescuespot.exeptions.user.UserNotFoundExeption;
import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.user.DTO.request.UpdateUserRequestDTO;
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
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserMapper userMapper;

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(emailRegex)
                .matcher(email)
                .matches();
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequest) {

        User userEntity = userMapper.toEntity(userRequest);

        Account account = userEntity.getAccount();

        if (account != null) {

            String email = account.getEmail();
            if (email == null || !isValidEmail(email)) {
                throw new EmailNotFoundExeption("Invalid email format");
            }

            if (account.getPassword() != null) {
                account.setPassword(
                        passwordEncoder.encode(account.getPassword())
                );
            }
            if(account.getPassword() == null){
                throw new PasswordIsRequiredExeption("Password is required");
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
    public UserResponseDTO updateUser(Long id, UpdateUserRequestDTO request) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundExeption("User not found with id: " + id)
                );

        User updatedData = userMapper.toEntityUpdate(request);

        if (updatedData.getFirstName() != null) {
            existingUser.setFirstName(updatedData.getFirstName());
        }

        if (updatedData.getLastName() != null) {
            existingUser.setLastName(updatedData.getLastName());
        }

        if (updatedData.getBio() != null) {
            existingUser.setBio(updatedData.getBio());
        }

        if (updatedData.getLinkedin() != null) {
            existingUser.setLinkedin(updatedData.getLinkedin());
        }

        if (updatedData.getInstagram() != null) {
            existingUser.setInstagram(updatedData.getInstagram());
        }

        if (updatedData.getFacebook() != null) {
            existingUser.setFacebook(updatedData.getFacebook());
        }

        if (updatedData.getTwitter() != null) {
            existingUser.setTwitter(updatedData.getTwitter());
        }

        if (updatedData.getLocation() != null) {
            existingUser.setLocation(updatedData.getLocation());
        }

        if (request.getAccount() != null) {

            Account account = existingUser.getAccount();

            if (request.getAccount().getEmail() != null) {

                String email = request.getAccount().getEmail();

                if (!isValidEmail(email)) {
                    throw new EmailNotFoundExeption("Invalid email format");
                }

                account.setEmail(email);
            }

            if (request.getAccount().getUsername() != null) {
                account.setUsername(request.getAccount().getUsername());
            }

            if (request.getAccount().getProfilePhoto() != null) {
                account.setProfilePhoto(request.getAccount().getProfilePhoto());
            }

            if (request.getAccount().getProfileBackground() != null) {
                account.setProfileBackground(request.getAccount().getProfileBackground());
            }

            if (request.getAccount().getPassword() != null) {

                account.setPassword(
                        passwordEncoder.encode(request.getAccount().getPassword())
                );
            }
        }

        User savedUser = userRepository.save(existingUser);

        return userMapper.toResponse(savedUser);
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundExeption("User not found with id: " + id)
                );

        userRepository.delete(user);
    }
}