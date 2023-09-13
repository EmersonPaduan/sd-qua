package br.anhembi.veiculos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.anhembi.veiculos.entities.Car;

public interface CarRepo extends JpaRepository<Car, Long> {
   Optional<Car> findByPlate(String plate);
}
