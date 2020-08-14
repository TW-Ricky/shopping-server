package com.thoughtworks.twuc.store.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "commodity")
public class CommodityDto {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Integer price;
    private String imgUrl;
}
