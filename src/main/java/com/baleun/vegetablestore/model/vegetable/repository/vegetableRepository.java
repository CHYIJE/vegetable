package com.baleun.vegetablestore.model.vegetable.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baleun.vegetablestore.model.vegetable.entity.VegetableEntity;




public interface VegetableRepository extends JpaRepository<VegetableEntity, Long>{
    Optional<VegetableEntity> findByIdx(Integer idx);
    Optional<VegetableEntity> findByVegename(String vegename);
    List<VegetableEntity> findByPrice(Integer price);
    List<VegetableEntity> findByOrigin(String origin);
    List<VegetableEntity> findByPicture(String picture);
    List<VegetableEntity> findByAmount(Integer amount);
    Optional<VegetableEntity>findByIdxAndVegename(Integer idx, String vegename);
    List<VegetableEntity> findAll();
}
