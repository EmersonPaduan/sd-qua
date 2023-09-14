package br.anhembi.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.anhembi.veiculos.entities.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Long> {
    
}
