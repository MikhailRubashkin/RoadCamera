package com.example.roadcamera.repos;

import com.example.roadcamera.domain.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepo extends CrudRepository<Car, Long> {

    List<Car> findByCarNumber(String carNumber);
}
