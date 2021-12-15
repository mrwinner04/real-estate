package com.bigProject.RealEstate.Repository;

import com.bigProject.RealEstate.model.EstateFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstateFeatureRepository extends JpaRepository<EstateFeatureRepository, Long> {
    Optional<EstateFeature> findByFeature
}
