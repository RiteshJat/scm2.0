package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "user")
@Table(name = "users")
@Data
public class User {

    @Id
    private int userId;

    @Column(name = "user_name",nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;
    private String password;

    @Column(length = 5000)
    private String about;
    @Column(length = 5000)
    private String profilePic;
    private String role;
    // information
    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    //SELF, GOOGLE, FACEBOOK, GITHUB, LINKEDIN
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    
}
