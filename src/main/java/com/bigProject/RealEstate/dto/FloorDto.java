package com.bigProject.RealEstate.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class FloorDto {
    @Range(min = -3, max = 164, message = "Floors must be between -3 and 164")
    private Integer number;

    private Long id;


}
