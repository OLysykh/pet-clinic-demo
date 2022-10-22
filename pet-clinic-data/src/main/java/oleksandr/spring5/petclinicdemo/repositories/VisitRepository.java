package oleksandr.spring5.petclinicdemo.repositories;

import oleksandr.spring5.petclinicdemo.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
