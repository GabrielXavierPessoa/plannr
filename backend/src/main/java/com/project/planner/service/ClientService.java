package com.project.planner.service;

import com.project.planner.domain.Client;
import com.project.planner.domain.User;
import com.project.planner.dto.client.ClientRequestDTO;
import com.project.planner.dto.client.ClientResponseDTO;
import com.project.planner.exception.BadRequestException;
import com.project.planner.exception.BusinessRulesException;
import com.project.planner.exception.ResourceNotFoundException;
import com.project.planner.repository.ClientRepository;
import com.project.planner.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ClientService {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ClientService(
            UserRepository userRepository,
            ClientRepository clientRepository,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    static String validator = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-_=+]).{8,20}$";


    @Transactional(readOnly = true)
    public List<ClientResponseDTO> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientResponseDTO::new)
                .toList();
    }

    @Transactional
    public ClientResponseDTO save(ClientRequestDTO dto) {
        if(userRepository.existsByEmail(dto.getEmail())) {
            throw new BusinessRulesException("This E-mail already registered in database");
        }

        String passwordHash = passwordEncoder.encode(dto.getPassword());
        User user = new User(dto.getEmail(), passwordHash);

        Client client = new Client();
        client.setName(dto.getName());
        client.setPhone(dto.getPhone());
        client.setUser(user);

        Client saveClient = clientRepository.save(client);

        return new ClientResponseDTO(saveClient);
    }

    @Transactional
    public void deleteById(Long id) {
        if(!clientRepository.existsById(id) || !userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id " + id + "not found");
        }

        clientRepository.deleteById(id);
    }
}
