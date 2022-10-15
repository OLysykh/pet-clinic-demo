package oleksandr.spring5.petclinicdemo.services.map;

import oleksandr.spring5.petclinicdemo.model.Pet;
import oleksandr.spring5.petclinicdemo.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void deleteByID(Long id) {
super.deleteById(id);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
