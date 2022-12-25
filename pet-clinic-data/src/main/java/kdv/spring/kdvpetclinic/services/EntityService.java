package kdv.spring.kdvpetclinic.services;

import java.util.Set;

public interface EntityService <T> {

    T findBiId(Long id);

    T save(T entity);

    Set<T> findAll();
}
