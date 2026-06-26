package com.attendancemanagement.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
//@Table(name="user_table")

public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @Column(name="first_name")
    private String firstName;
    //@Column(name="last_name")
    private String lastName;
    //@Column(name="email",nullable = true,unique = true)
    private String email;
    //@Column(name="password")
    private String password;
    //@Column(name="roll_no")
    private long rollNumber;
   // @Column(name="role")
    private String role;

}
