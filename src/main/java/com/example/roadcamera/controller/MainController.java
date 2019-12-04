package com.example.roadcamera.controller;

import com.example.roadcamera.domain.Car;
import com.example.roadcamera.repos.CarRepo;
import com.example.roadcamera.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    public CarService carService;

    @Autowired
    private CarRepo carRepo;

    @GetMapping("/")
    public String registeredCars(Map<String, Object> model){
        Iterable<Car> cars = carRepo.findAll();
        model.put("cars", cars);
        return "registeredCars";
    }

    @PostMapping("/registeredCars")
    public String addCarNumber(@RequestParam String carNumber, Map<String, Object> model){
        Car car = new Car(carNumber);
        if (carService.validate(carNumber)) {
            carRepo.save(car);
            Iterable<Car> cars = carRepo.findAll();
            model.put("cars", cars);
            return "registeredCars";
        }else {
            return "registeredCars";
        }
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Car> cars;
        if (filter != null && !filter.isEmpty()) {
            cars = carRepo.findByCarNumber(filter);
        }else {
            cars = carRepo.findAll();
        }
        model.put("cars", cars);
        return "registeredCars";
    }


}
