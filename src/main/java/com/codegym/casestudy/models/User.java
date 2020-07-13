package com.codegym.casestudy.models;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String userName;
    private String password;
    private Date registeredAt;
    private Date lastLogin;
    private String avatar;

    @OneToOne
    @JoinColumn(name = "permission_id")
    private Role role;
}
