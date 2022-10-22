package oleksandr.spring5.petclinicdemo.repositories;

import oleksandr.spring5.petclinicdemo.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
