package com.bigProject.RealEstate.controller;

import com.bigProject.RealEstate.Service.EstateService;
import com.bigProject.RealEstate.dto.EstateDto;
import com.bigProject.RealEstate.dto.EstateResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(value = "/estates")
@AllArgsConstructor
@RestController
public class EstateController {
    private final EstateService estateService;

    @PostMapping
    public ResponseEntity<EstateResponse> save(@RequestBody @Valid EstateDto estateDto){

    }
}
