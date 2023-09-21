package br.anhembi.veiculos.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.anhembi.veiculos.dto.CarDTO;
import br.anhembi.veiculos.entities.Car;
import br.anhembi.veiculos.entities.Owner;
import br.anhembi.veiculos.exceptions.OwnerNotFoundException;
import br.anhembi.veiculos.repository.CarRepo;
import br.anhembi.veiculos.repository.OwnerRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {
    
    private final CarRepo carRepo;
    private final OwnerRepo ownerRepo;

    public Car saveCar(Car newCar, long idProprietatio) {
        Owner owner = ownerRepo.findById(idProprietatio)
            .orElseThrow(()-> new OwnerNotFoundException("Proprietário não existe"));
        
        newCar.setOwner(owner);
        return carRepo.save(newCar);
    }

    public Optional<Car> findById(long id) {
        return carRepo.findById(id);
    }

    public Optional<Car> findByPlate(String plate) {
        Optional<Car> carOptional = carRepo.findByPlate(plate);

        if(carOptional.isPresent()){
            Car carFound = carOptional.get();
            return Optional.of(carFound);
        }
        return Optional.empty();
    }
    
    public Optional<CarDTO> update(CarDTO carDTO) {
        Optional<Car> carfound = carRepo.findByPlate(carDTO.getPlate());
        if(carfound.isEmpty()) {
            return Optional.empty();
        }
        Car car = carfound.get();

        if(carDTO.getColor() != null) {
            car.setColor(carDTO.getColor());
        }

        if(carDTO.getYear() > 0) {
            car.setYear(carDTO.getYear());
        }

        Car carUpdated = carRepo.save(car);

        return Optional.of(new CarDTO(carUpdated));
    }

    public boolean delete(String plate) {
        Optional<Car> carfound = carRepo.findByPlate(plate);
        if(carfound.isEmpty()) {
            return false;
        }

        carRepo.deleteById(carfound.get().getId());
        return true;
    }
}
