package com.project.planner.service;

import com.project.planner.domain.Client;
import com.project.planner.domain.User;
import com.project.planner.dto.client.ClientRequestDTO;
import com.project.planner.dto.client.ClientResponseDTO;
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

    @Transactional(readOnly = true)
    public List<ClientResponseDTO> findAll() {
        return clientRepository.findAll().stream()
                .map(client -> new ClientResponseDTO(client))
                .toList();
    }

    @Transactional
    public ClientResponseDTO save(ClientRequestDTO dto) {
        if(userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("O email já existe na base de dados");
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
}
