package oleksandr.spring5.petclinicdemo.services;

import oleksandr.spring5.petclinicdemo.model.PetType;
import org.springframework.stereotype.Service;

@Service
public interface PetTypeService extends CrudService<PetType, Long> {
}
