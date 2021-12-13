package com.bigProject.RealEstate.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
@Builder
@Getter
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Column(nullable = false, unique = true)
    private String name;


    @ManyToMany
    @JoinTable(
            name = "cities_neighborhoods",
            joinColumns = @JoinColumn(name = "city_id"),
            inverseJoinColumns = @JoinColumn(name = "neighborhood_id")
    )
    private Set<Neighborhood> neighborhoods;


}
