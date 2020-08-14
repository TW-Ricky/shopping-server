package com.thoughtworks.twuc.store.api;

import com.thoughtworks.twuc.store.domain.Commodity;
import com.thoughtworks.twuc.store.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommodityController {
    @Autowired
    CommodityService commodityService;

    @GetMapping("/commodities")
    public ResponseEntity<List<Commodity>> getCommodityList() {
        return ResponseEntity.ok(commodityService.getCommodityList());
    }
}
