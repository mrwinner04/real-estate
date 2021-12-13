package com.bigProject.RealEstate.controller;

import com.bigProject.RealEstate.Converter.FloorConverter;
import com.bigProject.RealEstate.Service.FloorService;
import com.bigProject.RealEstate.dto.FloorDto;
import com.bigProject.RealEstate.model.Floor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;

import static java.lang.invoke.VarHandleFloats.FieldInstanceReadOnly.get;
import static javax.swing.UIManager.put;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.get;



@WebMvcTest(value = FloorController.class)
class FloorControllerTest extends BaseControllerTest  {

    @MockBean
    private  FloorService floorService;

    @MockBean
    private  FloorConverter floorConverter;


    @Test
     void save() throws Exception {
        FloorDto floorDto = FloorDto.builder().number(1).build();
        String reqJson = objectMapper.writeValueAsString(floorDto);


        when(floorConverter.toFloor(any(FloorDto.class))).thenReturn(Floor.builder().build());
        when(floorService.save(any(Floor.class))).thenReturn(Floor.builder().build());
        when(floorConverter.toFloorDto(any(Floor.class))).thenReturn(FloorDto.builder().id(1L).number(1).build());

        mockMvc.perform(post("/floors")
                        .content(reqJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.number", is(1)));
    }

    @Test
    public void findById() throws Exception{

        when(floorService.findById(any(Long.class))).thenReturn(Floor.builder().build());
        when(floorConverter.toFloorDto(any(Floor.class))).thenReturn(FloorDto.builder().number(5).id(1L).build());



        mockMvc.perform(get("/floors/id/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.number" , is(1)));

    }

    @Test
    public void deleteHappy() throws Exception {
        mockMvc.perform(delete("/floors/1"))
                .andExpect(status().isOk());
    }


    @Test
    public void updateHappy() throws Exception{
        FloorDto floorDto = FloorDto.builder().id(1L).number(2).build();
        String reqJson = objectMapper.writeValueAsString(floorDto);

        when(floorConverter.toFloorDto(any())).thenReturn(floorDto);


        mockMvc.perform(put("/floors/1")
                .content(reqJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));


    }
}