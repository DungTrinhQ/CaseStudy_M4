package com.codegym.casestudy.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    private long id;

    @NotEmpty
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
