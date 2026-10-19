package com.project.planner.repository;

import com.project.planner.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByPublicId(UUID publicId);

    boolean existsByPublicId(UUID publicId);

    void deleteByPublicId(UUID publicId);

}
