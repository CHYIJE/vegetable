package com.baleun.vegetablestore.domain.baleun.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ResBaleunDTO {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public class ResBaleunD{
        private List<BaleunVegetableDTO> baleunUserDTOList;
    }
    
}

