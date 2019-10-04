package com.sk.petclinic.services.map;

import com.sk.petclinic.model.Vet;
import com.sk.petclinic.services.CRUDService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CRUDService<Vet, Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteByID(id);

    }
}
