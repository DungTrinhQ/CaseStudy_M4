package com.codegym.casestudy.models;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
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
    @Column(nullable = false)
    private String userName;
    private String password;
    private Timestamp registeredAt;
    private Timestamp lastLogin;
    private String avatar;

    public User() {
        this.registeredAt = new Timestamp(System.currentTimeMillis());
    }
    @OneToOne
    @JoinColumn(name = "permission_id")
    private Role role;
}
