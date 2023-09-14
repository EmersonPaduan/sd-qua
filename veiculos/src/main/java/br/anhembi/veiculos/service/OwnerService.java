package br.anhembi.veiculos.service;

import org.springframework.stereotype.Service;

import br.anhembi.veiculos.entities.Owner;
import br.anhembi.veiculos.repository.OwnerRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepo ownerRepo;

    public Owner save(Owner owner) {
        return ownerRepo.save(owner);
    }
}
