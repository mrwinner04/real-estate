package com.bigProject.RealEstate.Converter;

import com.bigProject.RealEstate.dto.EstateDto;
import com.bigProject.RealEstate.model.City;
import com.bigProject.RealEstate.model.Estate;
import com.bigProject.RealEstate.model.Floor;
import com.bigProject.RealEstate.model.Quadrature;
import org.springframework.stereotype.Component;

@Component
public class EstateConverter {
    public Estate toEstate( EstateDto estateDto) {
        return Estate.builder().city(City.builder().id(estateDto.getId()).build()).floor(Floor.builder().id(estateDto.getId()).build())
                .description(estateDto.getDescription()).quadrature(Quadrature.builder().pureArea(estateDto.getPureArea()).builtUpArea(estateDto.getBuiltUpArea()).build())

                .estateFeatures(estateDto.getEstateFeatureIds().stream().map()).build();
    }
}
