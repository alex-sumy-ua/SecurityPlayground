package com.northcoders.SecurityPlayground.data;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  // Ensure table name is not "User"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)  // GitHub username should be unique
    private String githubUsername;

    // Default constructor
    public User() {}

    // Constructor with fields
    public User(Long id, String name, String githubUsername) {
        this.id = id;
        this.name = name;
        this.githubUsername = githubUsername;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public void setGithubUsername(String githubUsername) {
        this.githubUsername = githubUsername;
    }
}