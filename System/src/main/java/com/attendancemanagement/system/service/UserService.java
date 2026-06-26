package com.attendancemanagement.system.service;

import com.attendancemanagement.system.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long userId,UserDto updateUser);
    void deleteUser(Long userId);
    UserDto login(UserDto loginRequest);
}
