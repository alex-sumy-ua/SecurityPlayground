package com.northcoders.SecurityPlayground.data;

public class User {

    private Long id;
    private String name;
    private String githubUsername;

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, String githubUsername) {
        this.id = id;
        this.name = name;
        this.githubUsername = githubUsername;
    }

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
