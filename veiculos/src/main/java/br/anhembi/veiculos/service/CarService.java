package br.anhembi.veiculos.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.anhembi.veiculos.dto.CarDTO;
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

    public Optional<Car> findById(long id) {
        return carRepo.findById(id);
    }

    public Optional<CarDTO> findByPlate(String plate) {
        Optional<Car> carOptional = carRepo.findByPlate(plate);

        if(carOptional.isPresent()){
            Car carFound = carOptional.get();
            return Optional.of(new CarDTO(carFound));
        }
        return Optional.empty();
    }
}
