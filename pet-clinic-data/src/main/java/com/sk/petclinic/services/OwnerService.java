package com.sk.petclinic.services;

import com.sk.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CRUDService<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
