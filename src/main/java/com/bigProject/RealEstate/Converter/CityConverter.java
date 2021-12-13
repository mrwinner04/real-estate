package com.bigProject.RealEstate.Converter;

import com.bigProject.RealEstate.dto.CityDto;
import com.bigProject.RealEstate.dto.FloorDto;
import com.bigProject.RealEstate.model.City;
import com.bigProject.RealEstate.model.Floor;
import com.bigProject.RealEstate.model.Neighborhood;

import java.util.stream.Collectors;

public class CityConverter {

    public CityDto toCityDto(City city) {

        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())

                .build();
    }

    public City toCity(CityDto cityDto) {
        return City.builder()

                .id(cityDto.getId())
                .name(cityDto.getName())
                .neighborhoods(cityDto.getNeighborhoods().stream().map((neighborhoodId) -> Neighborhood.builder().id(neighborhoodId).build()).collect(Collectors.toSet()))

                .build();
    }

}
