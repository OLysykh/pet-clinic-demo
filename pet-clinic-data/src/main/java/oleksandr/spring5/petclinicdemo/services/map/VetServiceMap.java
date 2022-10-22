package oleksandr.spring5.petclinicdemo.services.map;

import oleksandr.spring5.petclinicdemo.model.Speciality;
import oleksandr.spring5.petclinicdemo.model.Vet;
import oleksandr.spring5.petclinicdemo.services.SpecialityService;
import oleksandr.spring5.petclinicdemo.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
       if(object.getSpecialties().size()>0){
           object.getSpecialties().forEach(speciality->{
               if(speciality.getId() == null){
                Speciality savedSpeciality = specialityService.save(speciality);
                speciality.setId(savedSpeciality.getId());
               }
           });
       }
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
