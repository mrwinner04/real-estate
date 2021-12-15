package com.bigProject.RealEstate.Service.impl;

import com.bigProject.RealEstate.Repository.EstateRepository;
import com.bigProject.RealEstate.Service.EstateService;
import com.bigProject.RealEstate.model.Estate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class EstateServiceImpl implements EstateService {
    private EstateRepository estateRepository;

    @Override
    public Estate save(Estate estate) {
        return null;
    }

    @Override
    public Set<Estate> findAll() {
        return new HashSet<>(estateRepository.findAll());
    }
}
