package com.baleun.vegetablestore.domain.baleun.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BaleunVegetableDTO {

    private Integer idx;
    private String vegename;
    private Integer price;
    private String origin;
    private String picture;
    private Integer amount;
}
