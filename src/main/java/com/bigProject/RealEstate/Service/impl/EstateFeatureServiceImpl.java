package com.bigProject.RealEstate.Service.impl;

import com.bigProject.RealEstate.Repository.EstateFeatureRepository;
import com.bigProject.RealEstate.Service.EstateFeatureService;
import com.bigProject.RealEstate.model.EstateFeature;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstateFeatureServiceImpl implements EstateFeatureService {
    private final EstateFeatureRepository estateFeatureRepository;


    @Override
    public EstateFeature save(EstateFeature estateFeature) {
        return estateFeatureRepository.save(estateFeature);
    }
}
