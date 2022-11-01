package oleksandr.spring5.petclinicdemo.services.springdatajpa;

import oleksandr.spring5.petclinicdemo.model.Owner;
import oleksandr.spring5.petclinicdemo.repositories.OwnerRepository;
import oleksandr.spring5.petclinicdemo.repositories.PetRepository;
import oleksandr.spring5.petclinicdemo.repositories.PetTypeRepository;
import oleksandr.spring5.petclinicdemo.services.OwnerService;
import oleksandr.spring5.petclinicdemo.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")

public class OwnersSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnersSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteByID(Long id) {
     ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        return ownerRepository.findAllByLastNameLike(lastName);
    }
}
