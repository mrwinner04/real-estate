package com.bigProject.RealEstate.Repository;

import com.bigProject.RealEstate.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Long> {

    Optional<Floor> findByNumber(Integer number);
}
