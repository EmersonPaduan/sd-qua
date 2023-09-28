package br.anhembi.veiculos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.anhembi.veiculos.security.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long>{
    Optional<AppUser> findByEmail(String email);
}
