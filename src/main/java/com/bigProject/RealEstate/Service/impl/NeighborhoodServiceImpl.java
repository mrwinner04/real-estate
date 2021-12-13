package com.bigProject.RealEstate.Service.impl;

import com.bigProject.RealEstate.Repository.NeighborhoodRepository;
import com.bigProject.RealEstate.Service.NeighborhoodService;
import com.bigProject.RealEstate.exception.ResourceNotFoundException;
import com.bigProject.RealEstate.model.Neighborhood;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;

    public NeighborhoodServiceImpl(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }


    @Override
    public Neighborhood findByName(String name) {
        return neighborhoodRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Neighborhood with name: %s does not exist", name), id));
    }

    @Override
    public Set<Neighborhood> findAll() {
        return new HashSet<>(neighborhoodRepository.findAll());
    }

    @Override
    public Neighborhood findById(Long id) {
        return neighborhoodRepository.findById(findById(neighborhood.getId()).getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Neighborhood with name: %s does not exist", name), id));
    }

    @Override
    public Neighborhood save(Neighborhood neighborhood) {
        return neighborhoodRepository.save(neighborhood);
    }
}
