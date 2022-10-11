package oleksandr.spring5.petclinicdemo.services;

import oleksandr.spring5.petclinicdemo.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findByLastName(String lastName);

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
