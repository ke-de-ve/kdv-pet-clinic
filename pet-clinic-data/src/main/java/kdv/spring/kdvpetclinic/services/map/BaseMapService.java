package kdv.spring.kdvpetclinic.services.map;

import kdv.spring.kdvpetclinic.model.BaseEntity;

import java.util.*;

public abstract class BaseMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    private Long getNextId() {
        Set<Long> keys = map.keySet();
        if (keys.size() == 0) {
            return 1L;
        } else {
            return Collections.max(keys) + 1;
        }
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T entity) {
        if(entity != null) {
            if(entity.getId() == null) {
                entity.setId(getNextId());
            }
            map.put(entity.getId(), entity);
        } else {
            throw new RuntimeException("Object can not be bull.");
        }

        return entity;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T entity) {
        map.entrySet().removeIf(e -> Objects.equals(e.getValue(), entity));
    }

}