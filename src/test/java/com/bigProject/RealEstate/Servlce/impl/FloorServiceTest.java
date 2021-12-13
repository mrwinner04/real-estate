package com.bigProject.RealEstate.Servlce.impl;

import com.bigProject.RealEstate.Repository.FloorRepository;
import com.bigProject.RealEstate.Service.impl.FloorServiceImpl;
import com.bigProject.RealEstate.exception.DuplicateRecordException;
import com.bigProject.RealEstate.exception.ResourceNotFoundException;
import com.bigProject.RealEstate.model.Floor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class FloorServiceTest {

    @Mock
    private FloorRepository floorRepository;

    private Floor floor;


    @InjectMocks
    private FloorServiceImpl floorServiceImpl;

    @Test
    public void verifyFindAll() {

        when(floorRepository.findAll()).thenReturn(Collections.singletonList(Floor.builder().build()));

        floorServiceImpl.findALl();

        verify(floorRepository, times(1)).findAll();
    }

    @Test
    public void verifySafe() {
        when(floorRepository.save(any(Floor.class))).thenReturn(floor);
        Floor floorSave = Floor.builder().build();
        floorServiceImpl.save(floorSave);
        verify(floorRepository, times(1)).save();
    }

    @Test(expected = DuplicateRecordException.class)
    public void verifyDuplicateException() {


        when(floorRepository.save(any(Floor.class)))
                .thenThrow(DataIntegrityViolationException.class);

        floorServiceImpl.save(Floor.builder().build());




    }
    @Test
    public void verifyFindByNumber() {
        when(floorRepository.findByNumber(any(Integer.class)))
                .thenReturn(Optional.of(Floor.builder().build()));

        floorServiceImpl.findByNumber(1);

        verify(floorRepository,times(1)).findByNumber(1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void verifyFindByNumberException() {
        when(floorRepository.findByNumber(any(Integer.class)))
                .thenReturn(Optional.of(Floor.builder().build()));

        floorServiceImpl.findByNumber(1);


    }

    public void verifyDelete() {
        doNothing().when(floorRepository.deleteById(any(Long.class));

        floorServiceImpl.delete(1L);

        verify(floorRepository, times(1)).deleteById(1L);

    }
}
