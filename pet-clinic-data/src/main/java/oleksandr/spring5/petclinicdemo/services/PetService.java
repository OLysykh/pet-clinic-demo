package oleksandr.spring5.petclinicdemo.services;

import oleksandr.spring5.petclinicdemo.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long>{
    Pet findByLastName(String lastName);


}
