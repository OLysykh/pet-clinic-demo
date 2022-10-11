package oleksandr.spring5.petclinicdemo.services;

import oleksandr.spring5.petclinicdemo.model.Pet;
import oleksandr.spring5.petclinicdemo.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLastName(String lastName);

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
