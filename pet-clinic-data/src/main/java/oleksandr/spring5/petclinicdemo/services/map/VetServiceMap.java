package oleksandr.spring5.petclinicdemo.services.map;

import oleksandr.spring5.petclinicdemo.model.Vet;
import oleksandr.spring5.petclinicdemo.services.CrudService;
import oleksandr.spring5.petclinicdemo.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);

    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}