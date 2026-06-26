package com.attendancemanagement.system.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long rollNumber;
    private String role;
}

