package com.bigProject.RealEstate.Service;

import com.bigProject.RealEstate.model.Floor;

import java.util.List;
import java.util.Set;

public interface FloorService {
    Floor save(Floor floor);

    Floor findByNumber(Integer number);

    Floor update(Floor floor, Long id);

    void delete(Long id);

    Set<Floor> findALl();

    Floor findById(Long id);
}
