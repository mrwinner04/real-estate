package com.bigProject.RealEstate.Service;

import com.bigProject.RealEstate.model.Estate;

import java.util.Set;

public interface EstateService {
    Estate save(Estate estate);

    Set<Estate> findAll();

}
