package kdv.spring.kdvpetclinic.services.map;

import kdv.spring.kdvpetclinic.model.Owner;
import kdv.spring.kdvpetclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends BaseMapService<Owner, Long> implements CrudService<Owner, Long> {


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner entity) {
        super.delete(entity);
    }

    @Override
    public Owner findBiId(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner entity) {
        super.save(entity.getId(), entity);
        return entity;
    }
}