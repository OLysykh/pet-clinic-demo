package oleksandr.spring5.petclinicdemo.services.springdatajpa;

import oleksandr.spring5.petclinicdemo.model.Pet;
import oleksandr.spring5.petclinicdemo.repositories.PetRepository;
import oleksandr.spring5.petclinicdemo.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.awt.desktop.OpenFilesEvent;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpdaService implements PetService {

   private final PetRepository petRepository;

    public PetSDJpdaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {

        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteByID(Long aLong) {
        petRepository.deleteById(aLong);
    }


}
