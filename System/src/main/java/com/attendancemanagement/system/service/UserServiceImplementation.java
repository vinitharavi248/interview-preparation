package com.attendancemanagement.system.service;

import com.attendancemanagement.system.dto.UserDto;
import com.attendancemanagement.system.entity.User;
import com.attendancemanagement.system.exception.ResourceNotFoundException;
import com.attendancemanagement.system.mapper.UserMapper;
import com.attendancemanagement.system.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user= UserMapper.maptoUser(userDto);
        User createUser=userRepository.save(user);
        return UserMapper.maptoUserDto(createUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user= (User) userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User is not exits with given Id:"+userId));
        return UserMapper.maptoUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User>users=userRepository.findAll();
        return users.stream().map((user)->UserMapper.maptoUserDto(user)).collect(Collectors.toList());

    }

    @Override
    public UserDto updateUser(Long userId, UserDto updateUser) {
        User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User is not exits from the given Id:"+userId));
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());
        user.setRollNumber(updateUser.getRollNumber());
        user.setRole(updateUser.getRole());

        User updatedUser=userRepository.save(user);  //save the all updated values
        return UserMapper.maptoUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User is not exits from the given Id:"+userId));
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto login(UserDto loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());

        if(user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return UserMapper.maptoUserDto(user);
    }
}
