package com.project.planner.service;

import com.project.planner.domain.Provider;
import com.project.planner.domain.Specialty;
import com.project.planner.dto.provider.ProviderRequestDTO;
import com.project.planner.dto.provider.ProviderResponseDTO;
import com.project.planner.exception.BusinessRulesException;
import com.project.planner.exception.ResourceNotFoundException;
import com.project.planner.repository.ProviderRepository;
import com.project.planner.repository.SpecialtyRepository;
import com.project.planner.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final SpecialtyRepository specialtyRepository;

    public ProviderService(
            ProviderRepository providerRepository,
            UserRepository userRepository,
            SpecialtyService specialtyService,
            BCryptPasswordEncoder passwordEncoder,
            SpecialtyRepository specialtyRepository
    ) {
        this.providerRepository = providerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.specialtyRepository = specialtyRepository;
    }

    @Transactional(readOnly = true)
    public List<ProviderResponseDTO> findAll() {
        return providerRepository.findAll().stream()
                .map(ProviderResponseDTO::new)
                .toList();
    }

    @Transactional
    public ProviderResponseDTO save(ProviderRequestDTO requestDTO) {

        if(userRepository.existsByEmail(requestDTO.getEmail())) {
            throw new BusinessRulesException("Email alraedy exists! Try with another.");
        }

        String passwordHash = passwordEncoder.encode(requestDTO.getPasswordHash());

        Specialty specialty = specialtyRepository.findById(requestDTO.getSpecialty())
                .orElseThrow(() -> new ResourceNotFoundException("Specialty not found!"));

        Provider provider = new Provider(
                requestDTO.getName(),
                requestDTO.getEmail(),
                passwordHash,
                specialty
        );

        Provider response = providerRepository.save(provider);

        return new ProviderResponseDTO(response);
    }

}
