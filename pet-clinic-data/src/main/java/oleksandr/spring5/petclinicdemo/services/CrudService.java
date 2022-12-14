package oleksandr.spring5.petclinicdemo.services;

import java.util.Set;

public interface CrudService<T,ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T t);
    void delete(T t);
    void deleteByID(ID id);
}
