package com.bigProject.RealEstate.controller;


import com.bigProject.RealEstate.Converter.NeighborhoodConverter;
import com.bigProject.RealEstate.Service.NeighborhoodService;
import com.bigProject.RealEstate.dto.NeighborhoodDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/neighborhoods")
public class NeighborhoodController {
    private final NeighborhoodService neighborhoodService;
    private final NeighborhoodConverter neighborhoodConverter;

    public NeighborhoodController(NeighborhoodService neighborhoodService, NeighborhoodConverter neighborhoodConverter) {
        this.neighborhoodService = neighborhoodService;
        this.neighborhoodConverter = neighborhoodConverter;
    }
    @GetMapping
    public ResponseEntity<Set<NeighborhoodDto>> findAll() {
        return ResponseEntity.ok(neighborhoodService.findAll()
                .stream()
                .map(neighborhoodConverter::toNeighborhoodDto)
                .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<NeighborhoodDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(neighborhoodConverter.toNeighborhoodDto(neighborhoodService.findByName(name)));
    }

    @PostMapping
    public ResponseEntity<NeighborhoodDto> save(@RequestBody NeighborhoodDto neighborhoodDto) {
        return ResponseEntity.ok(neighborhoodConverter
                .toNeighborhoodDto(neighborhoodService
                .save(neighborhoodConverter.toNeighborhood(neighborhoodDto))));
    }
}
