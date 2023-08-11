package com.baleun.vegetablestore.domain.baleun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baleun.vegetablestore.VegetablestoreApplication;
import com.baleun.vegetablestore.domain.baleun.dto.BaleunVegetableDTO;
import com.baleun.vegetablestore.domain.baleun.dto.ResBaleunDTO;


@Service
@Transactional(readOnly = true)
public class BaleunService {

    
    @Autowired
    private static VegetableRepository vegetableRepository;


    public ResBaleunDTO getMainData(){
         // 기본적으로 다 찾음 없는것들만 repository에서 만듬

        // 원두 가져오기
        List<VegetableEntity> userEntityList = vegetableRepository.findAll();
        //아메리카노 컵 준비하기
        List<BaleunVegetableDTO> mainVegetatableDTOList = new ArrayList<>();

        for (vegetavleEntity vegetableEntity : vegetableEntityList) {
            // 원두를 아메리카노로 만들기
            BaleunVegetableDTO mainUserDTO = new BaleunVegetableDTO();
            // 아메리카노를 컵에 담기
            mainVegetatableDTOList.add(baleunVegetableDTOList);
        }
        // 캐리어에 아메리카노를 담고 컨트롤러한테남겨주기
        return new ResBaleunDTO(baleunVegetableDTOList);

    }
    

}

    
    
}
