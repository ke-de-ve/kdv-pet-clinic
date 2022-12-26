package kdv.spring.kdvpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findBiId(ID id);

    T save(T entity);

    void delete(T entity);

    void deleteById(ID id);
}
