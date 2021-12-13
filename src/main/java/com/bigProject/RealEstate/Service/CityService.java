package com.bigProject.RealEstate.Service;

import com.bigProject.RealEstate.model.City;

import java.util.Set;

public interface CityService {
    City findById(Long id);

    City save(City city);

    Set<City> findAll();
}
