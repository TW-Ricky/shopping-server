package com.thoughtworks.twuc.store.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.twuc.store.Dto.CommodityDto;
import com.thoughtworks.twuc.store.repository.CommodityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class CommodityControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    CommodityRepository commodityRepository;

    @BeforeEach
    void setUp() {
        commodityRepository.deleteAll();
        commodityRepository.save(CommodityDto.builder().imgUrl("kele.jpg").name("可乐").price(1).build());
        commodityRepository.save(CommodityDto.builder().imgUrl("xuebi.jpg").name("雪碧").price(2).build());
        commodityRepository.save(CommodityDto.builder().imgUrl("fenda.jpg").name("芬达").price(3).build());
        commodityRepository.save(CommodityDto.builder().imgUrl("kafei.jpg").name("咖啡").price(4).build());
        commodityRepository.save(CommodityDto.builder().imgUrl("binghongcha.jpg").name("冰红茶").price(5).build());
        commodityRepository.save(CommodityDto.builder().imgUrl("naicha.jpg").name("奶茶").price(6).build());
    }
    @Test
    public void shouldReturnGoods() throws Exception {
        mockMvc.perform(get("/commodities"))
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$[0].name", is("可乐")))
                .andExpect(jsonPath("$[1].name", is("雪碧")))
                .andExpect(jsonPath("$[2].name", is("芬达")))
                .andExpect(jsonPath("$[3].name", is("咖啡")))
                .andExpect(jsonPath("$[4].name", is("冰红茶")))
                .andExpect(jsonPath("$[5].name", is("奶茶")));
    }
}