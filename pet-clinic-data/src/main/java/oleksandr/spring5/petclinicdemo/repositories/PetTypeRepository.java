package oleksandr.spring5.petclinicdemo.repositories;

import oleksandr.spring5.petclinicdemo.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
