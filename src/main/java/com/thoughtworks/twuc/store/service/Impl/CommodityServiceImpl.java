package com.thoughtworks.twuc.store.service.Impl;

import com.thoughtworks.twuc.store.Dto.CommodityDto;
import com.thoughtworks.twuc.store.domain.Commodity;
import com.thoughtworks.twuc.store.repository.CommodityRepository;
import com.thoughtworks.twuc.store.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityRepository commodityRepository;
    @Override
    public List<Commodity> getCommodityList() {

        return commodityRepository.findAll().stream()
                .map(item -> changeCommodityDtoToCommodity(item)).collect(Collectors.toList());
    }

    private Commodity changeCommodityDtoToCommodity(CommodityDto item) {
        return Commodity.builder()
                .imgUrl(item.getImgUrl())
                .name(item.getName())
                .price(item.getPrice())
                .id(item.getId())
                .build();
    }
}
