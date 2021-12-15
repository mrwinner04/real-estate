package com.bigProject.RealEstate.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estate_feature")
@Builder
@Getter
public class EstateFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Length(min = 3, max = 30, message = "Length should be between 3 adn 30.")
    @Column(nullable = false)
    private String feature;

    @ManyToMany(mappedBy = "estateFeatures")
    private Set<Estate> estates;






}
