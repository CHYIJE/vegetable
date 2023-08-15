package com.baleun.vegetablestore.domain.baleun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baleun.vegetablestore.domain.baleun.dto.BaleunVegetableDTO;
import com.baleun.vegetablestore.domain.baleun.dto.ResBaleunDTO;
import com.baleun.vegetablestore.model.vegetable.entity.VegetableEntity;
import com.baleun.vegetablestore.model.vegetable.repository.VegetableRepository;


@Service
@Transactional(readOnly = true)
public class BaleunService {

    @Autowired
    private VegetableRepository vegetableRepository;

    public ResBaleunDTO getMainData() {
        // 원두 가져오기
        List<VegetableEntity> vegetableEntityList = vegetableRepository.findAll();
        // 아메리카노 컵 준비하기
        List<BaleunVegetableDTO> baleunVegetableDTOList = new ArrayList<>();
        for (VegetableEntity vegetableEntity : vegetableEntityList) {
            // 원두를 아메리카노로 만들기
            BaleunVegetableDTO baleunVegetableDTO = new BaleunVegetableDTO();
            // 아메리카노를 컵에 담기
            baleunVegetableDTOList.add(baleunVegetableDTO);
        }
        // 캐리어에 아메리카노를 담고 컨트롤러한테 남겨주기
        return new ResBaleunDTO(baleunVegetableDTOList);

    }

    
}