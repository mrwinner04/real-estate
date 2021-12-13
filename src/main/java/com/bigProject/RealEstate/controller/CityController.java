package com.bigProject.RealEstate.controller;

import com.bigProject.RealEstate.Converter.CityConverter;
import com.bigProject.RealEstate.Service.CityService;
import com.bigProject.RealEstate.dto.CityDto;
import com.bigProject.RealEstate.model.City;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
    private final CityService cityService;
    private final CityConverter cityConverter;

    public CityController(CityService cityService, CityConverter cityConverter) {
        this.cityService = cityService;
        this.cityConverter = cityConverter;
    }

    @PostMapping
    public ResponseEntity<CityDto> save(@RequestBody CityDto cityDto) {
        City city = cityConverter.toCity(cityDto);
        City savedCity = cityService.save(city);
        CityDto cityDtoResponse= cityConverter.toCityDto(city);
        return ResponseEntity.ok(cityDtoResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDto>findByName(@PathVariable Long id) {
        City foundCity = cityService.findById(id);
        CityDto cityDto = cityConverter.toCityDto(foundCity);

        return ResponseEntity.ok().build();
    }
}
