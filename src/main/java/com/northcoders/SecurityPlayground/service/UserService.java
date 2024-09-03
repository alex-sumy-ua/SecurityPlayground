package com.northcoders.SecurityPlayground.service;

import com.northcoders.SecurityPlayground.data.User;
import com.northcoders.SecurityPlayground.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        var delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String githubUsername = oAuth2User.getAttribute("login");
        String name = oAuth2User.getAttribute("name");

        User user = userRepository.findByGithubUsername(githubUsername);

        if (user == null) {
            // If user doesn't exist, create and save a new one
            user = new User();
            user.setGithubUsername(githubUsername);
            user.setName(name);
            userRepository.save(user);
        }

        return new DefaultOAuth2User(
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")),
                oAuth2User.getAttributes(),
                "login"
        );
    }
}