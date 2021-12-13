package com.bigProject.RealEstate.Service.impl;

import com.bigProject.RealEstate.Repository.FloorRepository;
import com.bigProject.RealEstate.Service.FloorService;
import com.bigProject.RealEstate.exception.DuplicateRecordException;
import com.bigProject.RealEstate.exception.ResourceNotFoundException;
import com.bigProject.RealEstate.model.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class FloorServiceImpl implements FloorService {
    private final FloorRepository floorRepository;

    @Autowired
    public FloorServiceImpl(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public Set<Floor> findALl() {
        return new TreeSet<>(floorRepository.findAll());
    }

    public Floor findById(Long id) {
        return floorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Floor with id %d does not exist", id), id));
    }

    @Override
    public Floor save(Floor floor) {
        try {
            return floorRepository.save(floor);
        } catch (DataIntegrityViolationException exception) {
            throw new DuplicateRecordException(String.format("Floor with number %d already exists", floor.getNumber()));
        }
    }

    @Override
    public Floor findByNumber(Integer number) {
        return floorRepository.findByNumber(number)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Floor with %d does not exist", number)));
    }

    @Override
    public Floor update(Floor floor, Long id) {
        Floor foundFloor = findById(id);
        Floor updatedFloor = Floor.builder()
                .id(foundFloor.getId())
                .number(floor.getNumber())
                .build();
        return save(updatedFloor);
    }

    @Override
    public void delete(Long id) {

    }


}
