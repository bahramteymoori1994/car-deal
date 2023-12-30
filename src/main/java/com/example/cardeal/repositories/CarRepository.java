package com.example.cardeal.repositories;

import com.example.cardeal.model.entities.Car;
import com.example.cardeal.model.enums.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>
{
    List<Car> findCarByName(String name);
    List<Car> findCarsByCompanyName(String companyName);
    List<Car> findCarsByCarModel(CarModel carModel);
}