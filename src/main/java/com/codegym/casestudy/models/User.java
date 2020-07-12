package com.codegym.casestudy.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Length(min = 4,max = 30)
    private String fullName;

    @URL
    private String avaUrl;

    @NotNull
    @Length(min = 4,max = 30)
    private String username;

    @NotNull
    @Length(min = 4,max = 30)
    private String password;
}
