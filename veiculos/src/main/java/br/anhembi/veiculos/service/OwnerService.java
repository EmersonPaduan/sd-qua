package br.anhembi.veiculos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.anhembi.veiculos.entities.Car;
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

    public List<Car> getCars(long id) {
        Optional<Owner> optionalOwner = ownerRepo.findById(id);
        if(optionalOwner.isEmpty()){
            return new ArrayList<>();
        }
        return optionalOwner.get().getCars();
    }
}
