package com.northcoders.SecurityPlayground.repository;

import com.northcoders.SecurityPlayground.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByGithubUsername(String githubUsername);
}
