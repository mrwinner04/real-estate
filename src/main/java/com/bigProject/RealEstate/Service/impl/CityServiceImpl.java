package com.bigProject.RealEstate.Service.impl;

import com.bigProject.RealEstate.Repository.CityRepository;
import com.bigProject.RealEstate.Service.CityService;
import com.bigProject.RealEstate.Service.NeighborhoodService;
import com.bigProject.RealEstate.exception.ResourceNotFoundException;
import com.bigProject.RealEstate.model.City;
import com.bigProject.RealEstate.model.Neighborhood;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final NeighborhoodService neighborhoodService;

    public CityServiceImpl(CityRepository cityRepository, NeighborhoodService neighborhoodService) {
        this.cityRepository = cityRepository;
        this.neighborhoodService = neighborhoodService;
    }


    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("City not found %d"), id));
    }

    @Override
    public City save(City city) {


        Set<Neighborhood> neighborhoods = new HashSet<>();
        for (Neighborhood neighborhood: city.getNeighborhoods()) {
            Neighborhood foundNeighborhood = neighborhoodService.findById(neighborhood.getId());
            neighborhoods.add(foundNeighborhood);
        }
       return cityRepository.save()City.builder()
                .name(city.getName())
                .neighborhoods(neighborhoods)
                .build();




    }

    @Override
    public Set<City> findAll() {
        return null;
    }
}
