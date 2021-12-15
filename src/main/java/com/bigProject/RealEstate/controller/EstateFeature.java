package com.bigProject.RealEstate.controller;

import com.bigProject.RealEstate.Service.EstateFeatureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "estate-feature")
@AllArgsConstructor
public class EstateFeature {

    private final EstateFeatureService estateFeatureService;

    public ResponseEntity<EstateFeature> save(@RequestBody @Valid EstateFeature estateFeature) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estateFeatureService).save(estateFeature);
    }
}
