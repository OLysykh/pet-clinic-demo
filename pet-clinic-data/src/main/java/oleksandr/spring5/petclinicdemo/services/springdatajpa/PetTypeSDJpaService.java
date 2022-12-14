package oleksandr.spring5.petclinicdemo.services.springdatajpa;

import oleksandr.spring5.petclinicdemo.model.PetType;
import oleksandr.spring5.petclinicdemo.repositories.PetTypeRepository;
import oleksandr.spring5.petclinicdemo.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")

public class PetTypeSDJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        Optional<PetType> optionalPetType = petTypeRepository.findById(aLong);
        return optionalPetType.orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteByID(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
