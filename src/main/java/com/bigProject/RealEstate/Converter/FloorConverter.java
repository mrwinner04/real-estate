package com.bigProject.RealEstate.Converter;

import com.bigProject.RealEstate.dto.FloorDto;
import com.bigProject.RealEstate.model.Floor;
import org.springframework.stereotype.Component;

@Component
public class FloorConverter {

    public FloorDto toFloorDto(Floor floor) {
        return FloorDto.builder()
                .id(floor.getId())
                .number(floor.getNumber())
                .build();
    }
    public Floor toFloor(FloorDto floorDto) {
        return Floor.builder()
                .id(floorDto.getId())
                .number(floorDto.getNumber())
                .build();
    }
}
