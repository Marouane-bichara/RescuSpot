package com.example.rescuespot.user.service.intrfaces;

import com.example.rescuespot.user.DTO.request.UpdateUserRequestDTO;
import com.example.rescuespot.user.DTO.request.UserRequestDTO;
import com.example.rescuespot.user.DTO.response.UserResponseDTO;
import com.example.rescuespot.user.entity.User;

import java.util.List;

public interface IUserService {

    UserResponseDTO createUser(UserRequestDTO user);
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO updateUser(Long id, UpdateUserRequestDTO request);
    void deleteUser(Long id);
}
