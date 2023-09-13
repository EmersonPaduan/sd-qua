package br.anhembi.veiculos.service;

import org.springframework.stereotype.Service;

import br.anhembi.veiculos.entities.Car;
import br.anhembi.veiculos.repository.CarRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {
    
    private final CarRepo carRepo;

    public Car saveCar(Car newCar) {
        return carRepo.save(newCar);
    }

}
