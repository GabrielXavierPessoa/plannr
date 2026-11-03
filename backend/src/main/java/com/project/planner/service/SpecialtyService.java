package com.project.planner.service;

import com.project.planner.domain.Specialty;
import com.project.planner.exception.BusinessRulesException;
import com.project.planner.repository.SpecialtyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Transactional(readOnly = true)
    public List<Specialty> findAll() {
        return specialtyRepository.findAll();
    }

    @Transactional
    public Specialty save(Specialty specialtyRequest) {
        if(specialtyRepository.existsByName(specialtyRequest.getName())) {
            throw new BusinessRulesException("The name of the specialty already exists");
        }

        return specialtyRepository.save(specialtyRequest);
    }

    @Transactional
    public Specialty update(Integer id, Specialty specialtyRequest) {
        Specialty specialty = specialtyRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Id " + id + " not found"));

        if(specialtyRequest.getName().equals(specialty.getName())){
            throw new BusinessRulesException("It is not possible to use the same name!");
        }

        specialty.setName(specialtyRequest.getName());

        return specialtyRepository.save(specialty);
    }

    @Transactional
    public void deleteById(Integer id) {
        Specialty specialty = specialtyRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Id not found"));

        specialtyRepository.delete(specialty);
    }


}
