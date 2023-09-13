package br.anhembi.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.veiculos.entities.Car;
import br.anhembi.veiculos.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car car) {
        Car carSaved = carService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(carSaved);
    }
}
