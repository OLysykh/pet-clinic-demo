package oleksandr.spring5.petclinicdemo.services;

import oleksandr.spring5.petclinicdemo.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
