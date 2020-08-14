package com.thoughtworks.twuc.store.repository;

import com.thoughtworks.twuc.store.Dto.CommodityDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommodityRepository extends CrudRepository<CommodityDto, Integer> {
    @Override
    List<CommodityDto> findAll();
}
