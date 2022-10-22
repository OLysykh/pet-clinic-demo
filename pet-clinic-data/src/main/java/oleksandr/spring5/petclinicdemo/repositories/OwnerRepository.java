package oleksandr.spring5.petclinicdemo.repositories;

import oleksandr.spring5.petclinicdemo.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);


}
