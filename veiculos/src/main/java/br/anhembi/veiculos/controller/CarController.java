package br.anhembi.veiculos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.veiculos.dto.CarDTO;
import br.anhembi.veiculos.entities.Car;
import br.anhembi.veiculos.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody CarDTO cardDto) {
        Car carSaved = carService.saveCar(cardDto.toCar());
        return ResponseEntity.status(HttpStatus.CREATED).body(carSaved);
    }

    @GetMapping("/{plate}")
    public ResponseEntity<CarDTO> findByPlate(@PathVariable String plate) {
        Optional<CarDTO> carDto =  carService.findByPlate(plate);

        if(carDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carDto.get());
    }
}
