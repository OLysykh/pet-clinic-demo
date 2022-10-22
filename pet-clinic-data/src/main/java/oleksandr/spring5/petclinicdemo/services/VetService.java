package oleksandr.spring5.petclinicdemo.services;

import oleksandr.spring5.petclinicdemo.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet,Long>{
    Vet findByLastName(String lastName);
    Vet findById(Long id);




}
