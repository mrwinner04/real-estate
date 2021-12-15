package com.bigProject.RealEstate.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class EstateDto {

    private  Long id;

    private String description;

    private BigDecimal pureArea;

    private BigDecimal builtUpArea;

    private Long floorId;


    private Set<Long> estateFeatureIds
}
