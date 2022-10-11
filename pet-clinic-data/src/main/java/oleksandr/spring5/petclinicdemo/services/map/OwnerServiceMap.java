package oleksandr.spring5.petclinicdemo.services.map;

import oleksandr.spring5.petclinicdemo.model.Owner;
import oleksandr.spring5.petclinicdemo.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
