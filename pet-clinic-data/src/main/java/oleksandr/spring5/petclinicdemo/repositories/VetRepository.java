package oleksandr.spring5.petclinicdemo.repositories;

import oleksandr.spring5.petclinicdemo.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {

    Vet findByLastName(String lastName);
}
