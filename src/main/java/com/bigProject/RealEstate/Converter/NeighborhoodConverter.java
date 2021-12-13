package com.bigProject.RealEstate.Converter;

import com.bigProject.RealEstate.dto.FloorDto;
import com.bigProject.RealEstate.dto.NeighborhoodDto;
import com.bigProject.RealEstate.model.Floor;
import com.bigProject.RealEstate.model.Neighborhood;

import javax.persistence.Converter;

@Converter
public class NeighborhoodConverter {
    public NeighborhoodDto toNeighborhoodDto(Neighborhood neighborhood) {
        return NeighborhoodDto.builder()
                .id(neighborhood.getId())
                .name(neighborhood.getName())
                .build();
    }
    public Neighborhood toNeighborhood(NeighborhoodDto neighborhoodDto) {
        return Neighborhood.builder()
                .id(neighborhoodDto.getId())
                .name(neighborhoodDto.getName())
                .build();
    }
}
