package br.anhembi.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.anhembi.veiculos.entities.Car;

public interface CarRepo extends JpaRepository<Car, Long> {
   
}
