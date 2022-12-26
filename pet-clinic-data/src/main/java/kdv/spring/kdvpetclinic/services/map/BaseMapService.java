package kdv.spring.kdvpetclinic.services.map;

import java.util.*;

public abstract class BaseMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(ID id, T entity) {
        map.put(id, entity);
        return entity;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T entity) {
        map.entrySet().removeIf(e -> Objects.equals(e.getValue(), entity));
    }
}