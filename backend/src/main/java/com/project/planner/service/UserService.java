package com.project.planner.service;

import com.project.planner.domain.User;
import com.project.planner.dto.user.UserResponseDTO;
import com.project.planner.repository.UserRepository;
import com.project.planner.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserResponseDTO::new)
                .toList();
    }

    @Transactional
    public User save(User user) {

        String passwordHash = passwordEncoder.encode(user.getPasswordHash());

        User perfil = new User(user.getEmail(), passwordHash, user.getRole());

        return userRepository.save(perfil);
    }
}
