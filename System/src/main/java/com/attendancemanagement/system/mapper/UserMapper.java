package com.attendancemanagement.system.mapper;

import com.attendancemanagement.system.dto.UserDto;
import com.attendancemanagement.system.entity.User;

public class UserMapper {


    public static UserDto maptoUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRollNumber(),
                user.getRole()


        );
    }

    public static User maptoUser(UserDto userDto){
        return new User(
                null,
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getRollNumber(),
                userDto.getRole()
        );
    }
}
