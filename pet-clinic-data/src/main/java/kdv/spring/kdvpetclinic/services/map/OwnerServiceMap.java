package kdv.spring.kdvpetclinic.services.map;

import kdv.spring.kdvpetclinic.model.Owner;
import kdv.spring.kdvpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends BaseMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner entity) {
        return super.save(entity);
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
    public Owner findByLastName(String lastName) {
        //TODO: implement findByLastName !
        return null;
    }
}