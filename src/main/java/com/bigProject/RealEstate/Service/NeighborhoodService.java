package com.bigProject.RealEstate.Service;

import com.bigProject.RealEstate.model.Neighborhood;

import java.util.Set;

public interface NeighborhoodService {

    Neighborhood findByName(String name);

    Set<Neighborhood> findAll();
    Neighborhood findById(Long id);

    Neighborhood save(Neighborhood neighborhood);
}
